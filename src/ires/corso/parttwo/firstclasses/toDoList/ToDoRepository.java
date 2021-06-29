package ires.corso.parttwo.firstclasses.toDoList;

import java.io.Serializable;
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
        // Individua il file e lo deserializza con readObject
        // _repository = ...
        return _repository;
    }

    private static ToDoRepository _repository = null;

    public static ToDoRepository getToDoRepository() {
        return _repository;
    }

    Map<Long, ToDo> _data = new HashMap<>();

    public void delete(Long ID) {
        //todo print "stai eliminando l'oggetto -descrizione-, sei sicuro?", se SI...
        _data.remove(ID);
    };

    public void add(ToDo t) {
        // si deve entrare nell'oggetto t e leggere il suo ID
        // per poi salvarlo nella mappa correttamente (con put(ID, t))
        //todo print "stai aggiungendo l'oggetto -descrizione-, sei sicuro?", se SI...
        _data.put(t.getEntityID(), t);
    }

    public void update(ToDo t) {
        // si prende l'ID dall'oggetto t
        // si recupera dalla mappa il TO-DO corrispondente con get(t), per controllo
        // si sostituisce con put(ID, t)
        Long id = t.getEntityID();
        _data.get(id);
        //todo print "sei sicuro di voler eliminare l'oggetto... con descrizione dell'oggetto?", se SI...
        _data.remove(id);
        _data.put(id, t);
    }

    //todo controllo se il ciclo While funziona come dovrebbe
    public List<ToDo> getToDoList() {
        List<ToDo> toDoAsList= new ArrayList<>();

        //con metodo compatto
        _data.values().addAll(toDoAsList);

        //con iterazione
        /*
        Iterator<ToDo> iToDo = _data.values().iterator();
        while(iToDo.hasNext()){
            toDoAsList.add(iToDo.next());
        }
         */
        return toDoAsList;
    }

    public void writeToFile(String fileName) {

    }
}
