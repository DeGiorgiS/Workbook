package ires.corso.parttwo.firstclasses.toDoList;

public class ToDoList {
    // Implementa le funzionalità di visualizzazione con:
    // - ordinamento per priorità
    // - ordinamento per data
    // - ordinamento per stato
    // Si appoggia a un metodo di ToDoRepository per avere una lista (= copia dei TO-DO
    // originali) dei TO-DO attualmente a sistema, cioè un ArrayList facilmente utilizzabile

    public void viewByPriority() {
        // Questa funzione è chiamata qunado l'utente sceglie di visualizzare i dati per priorità...
        ToDoRepository tdr = ToDoRepository.getToDoRepository();
    }
}
