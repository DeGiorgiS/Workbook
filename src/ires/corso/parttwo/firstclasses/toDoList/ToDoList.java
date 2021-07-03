package ires.corso.parttwo.firstclasses.toDoList;

import java.time.LocalDate;
import java.util.*;

public class ToDoList {
    // Implementa le funzionalità di visualizzazione con:
    // - ordinamento per priorità
    // - ordinamento per data
    // - ordinamento per stato
    // Si appoggia a un metodo di ToDoRepository per avere una lista (= copia dei TO-DO
    // originali) dei TO-DO attualmente a sistema, cioè un ArrayList facilmente utilizzabile

    private ArrayList<ToDo> theList = null;

    public ToDoList(){
        listGetter();
    }

    //funzione per creare una DeepCopy. Alla fine non la sto usando
    /*public ArrayList<ToDo> deepCopy(ArrayList<ToDo> altd){
        ArrayList<ToDo> copy = new ArrayList<>();
        Iterator<ToDo> itr = altd.iterator();

        while(itr.hasNext()){
            copy.add((ToDo) itr.next().cloneForUpdate());
        }

        return copy;
    }*/

    //prendo i TO-DO dal repository e li trasformo in lista
    public void listGetter(){
        ToDoRepository tdr = null;
        try{
            tdr = ToDoRepository.getToDoRepository();
        }
        catch (Exception e) {
            System.out.println("COLTA ECCEZIONE NEL CARICAMENTO INIZIALE DEL REPOSITORY");
            System.out.println("\n");
        }
        theList = tdr.getToDoList();
    }

    // Questa funzione è chiamata quando l'utente sceglie di visualizzare i dati per priorità...
    public void viewByPriority() {
        Comparator<ToDo> comparator = new Comparator<ToDo>() {
            @Override
            public int compare(ToDo o1, ToDo o2) {
                return o1.getPriority().compareTo(o2.getPriority());
            }
        };
        Collections.sort(theList,comparator);
    }

    // lista ordinata per stato
    public void viewByState() {
        Comparator<ToDo> comparator = new Comparator<ToDo>() {
            @Override
            public int compare(ToDo o1, ToDo o2) {
                return o1.getState().compareTo(o2.getState());
            }
        };
        Collections.sort(theList,comparator);
    }

    //funzione per ordinare per data di scadenza
    public void viewByExpiration() {
        Collections.sort(theList, (ToDo t1, ToDo t2) -> t1.getDateOfExpiration().compareTo(t2.getDateOfExpiration()));
    }

    public String print(){
        String result = "\n";

        for (ToDo t:
             theList) {
            result = result + "\n" + t.prettyPrint() + "\n";
        }

        return result;
    }
}
