package ires.corso.parttwo.firstclasses.toDoList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ToDoList {
    // Implementa le funzionalità di visualizzazione con:
    // - ordinamento per priorità
    // - ordinamento per data
    // - ordinamento per stato
    // Si appoggia a un metodo di ToDoRepository per avere una lista (= copia dei TO-DO
    // originali) dei TO-DO attualmente a sistema, cioè un ArrayList facilmente utilizzabile


    // Questa funzione è chiamata quando l'utente sceglie di visualizzare i dati per priorità...
    public void viewByPriority() {
        ToDoRepository tdr = ToDoRepository.getToDoRepository();
        ArrayList<ToDo> tdl = tdr.getToDoList();

        List<ToDo> priorityOrdered = new ArrayList<>();
        //ancora da ordinare la List
    }

    //funzione per ordinare per data di scadenza
    public void viewByExpiration() {
        ToDoRepository tdr = ToDoRepository.getToDoRepository();
        List<ToDo> tdl = tdr.getToDoList();

        List<ToDo> expirationOrdered = new ArrayList<>();
        //ancora da ordinare

    }
}
