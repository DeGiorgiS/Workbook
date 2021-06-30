package ires.corso.parttwo.firstclasses.toDoList;

import java.io.*;
import java.util.*;

public class ToDoRepository implements Serializable {

    /* GESTORE DELL'ARCHIVIO DEI TO-DO == DATABASE */

    // Contiene una HashMap di tutti i TO-DO a sistema:
    // - implementa il metodo di salvataggio su file
    // - implementa il metodo di caricamento da file
    // - metodi per individuare, aggiungere, eliminare un TO-DO
    // - restituisce una copia di tutti i TO-DO come ArrayList, da
    //   usare per le visualizzazioni di ToDoList

    // Serializzabile con la funzione writeObject()
    public static ToDoRepository loadFromFile(String fileName) {
        try (FileInputStream file = new FileInputStream(fileName);
             ObjectInputStream in = new ObjectInputStream(file)){
            _repository = (ToDoRepository) in.readObject();
            System.out.println("Il repository di ToDo è stato deserializzato");
        }
        catch(IOException e){
            System.out.println("Trovata una IOException");
        }
        catch(ClassNotFoundException e){
            System.out.println("Trovata una ClassNotFoundException");
        }
        return _repository;
    }

    private static ToDoRepository _repository = null;

    public static ToDoRepository getToDoRepository() {
        return _repository;
    }

    Map<Long, ToDo> _data = new HashMap<>();

    public void delete(Long ID) {
        _data.remove(ID);
    }


    public void add(ToDo t) {
        // si deve entrare nell'oggetto t e leggere il suo ID
        // per poi salvarlo nella mappa correttamente (con put(ID, t))
        _data.put(t.getEntityID(), t);
    }

    public void update(ToDo t) {
        // si prende l'ID dall'oggetto t
        // si recupera dalla mappa il TO-DO corrispondente con get(t), per controllo
        // si sostituisce con put(ID, t)

        //prendo ID del To-Do inserito
        Long id = t.getEntityID();

        //controllo esista già un to-do con quel ID
        boolean alreadyTakenID = false;
        for (Long ids:
             _data.keySet()) {
            if(id.equals(ids)){
                alreadyTakenID = true;
                break;
            }
        }

        //eseguo l'update
        if(alreadyTakenID) _data.remove(id);
        _data.put(id, t);
    }

    public boolean existence(ToDo t){
        boolean itExists = false;
        for (ToDo v:
                _data.values()) {
            if(v.equals(t)){itExists = true;}
        }
        return itExists;
    }

    public ArrayList<ToDo> getToDoList() {
        ArrayList<ToDo> toDoAsList= new ArrayList<>();

        //con metodo compatto
        _data.values().addAll(toDoAsList);

        //con iterazione
        //todo controllo se il ciclo While funziona come dovrebbe
        /*
        Iterator<ToDo> iToDo = _data.values().iterator();
        while(iToDo.hasNext()){
            toDoAsList.add(iToDo.next());
        }
         */
        return toDoAsList;
    }

    public void writeToFile(String fileName) {
        //con try-with-resources
        try (FileOutputStream file = new FileOutputStream(fileName);
             ObjectOutputStream out = new ObjectOutputStream(file)){
            out.writeObject(this);
            System.out.println("Il repository dei ToDo è stato serializzato");
        }
        catch(IOException e){
            System.out.println("Trovata una IOException");
        }
    }
}
