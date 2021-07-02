package ires.corso.parttwo.firstclasses.toDoList;

import java.util.*;

public class ToDoList {
    // Implementa le funzionalità di visualizzazione con:
    // - ordinamento per priorità
    // - ordinamento per data
    // - ordinamento per stato
    // Si appoggia a un metodo di ToDoRepository per avere una lista (= copia dei TO-DO
    // originali) dei TO-DO attualmente a sistema, cioè un ArrayList facilmente utilizzabile

    private ArrayList<ToDo> theList = null;

    //funzione per creare una DeepCopy. Alla fine non la sto usando
    public ArrayList<ToDo> deepCopy(ArrayList<ToDo> altd){
        ArrayList<ToDo> copy = new ArrayList<>();
        Iterator<ToDo> itr = altd.iterator();

        while(itr.hasNext()){
            copy.add((ToDo) itr.next().cloneForUpdate());
        }

        return copy;
    }

    //prendo i TO-DO dal repository e li trasformo in lista
    public ArrayList<ToDo> listGetter(){
        ToDoRepository tdr = ToDoRepository.getToDoRepository();
        theList = tdr.getToDoList();
        return theList;
    }

    // Questa funzione è chiamata quando l'utente sceglie di visualizzare i dati per priorità...
    public void viewByPriority() {
        listGetter();

        Comparator<ToDo> comparator = new Comparator<ToDo>() {
            @Override
            public int compare(ToDo o1, ToDo o2) {
                return o1.comparePriority(o2);
            }
        };
        Collections.sort(theList,comparator);
    }

    // lista ordinata per stato
    public ArrayList<ToDo> viewByState() {
        ToDoRepository tdr = ToDoRepository.getToDoRepository();
        ArrayList<ToDo> stateOrdered = tdr.getToDoList();

        Comparator<ToDo> comparator = new Comparator<ToDo>() {
            @Override
            public int compare(ToDo o1, ToDo o2) {
                return o1.compareState(o2);
            }
        };
        Collections.sort(stateOrdered,comparator);

        return stateOrdered;
    }

    //funzione per ordinare per data di scadenza
    public ArrayList<ToDo> viewByExpiration() {
        ToDoRepository tdr = ToDoRepository.getToDoRepository();
        ArrayList<ToDo> expirationOrdered = tdr.getToDoList();

        Comparator<ToDo> comparator = new Comparator<ToDo>() {
            @Override
            public int compare(ToDo o1, ToDo o2) {
                int result = o1.getDateOfExpiration().compareTo(o2.getDateOfExpiration());
                return result;
            }
        };
        Collections.sort(expirationOrdered,comparator);

        return expirationOrdered;
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
