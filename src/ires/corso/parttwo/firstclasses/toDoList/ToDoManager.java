package ires.corso.parttwo.firstclasses.toDoList;

import java.time.LocalDate;
import java.util.Scanner;

public class ToDoManager {
    // Classe responsabile per le operazioni sull'insieme dei TO-DO:
    // - metodi per creazione nuovo TO-DO
    // - metodi per la modifica, la rimozione
    // - gestisce input utente (cioè loop di richiesta di quali campi devono essere modificati)
    // - ha al suo interno funzioni di controllo sull'input utente //todo i controlli forse?

    public static void createNewToDo() throws Exception{
        //invoco i singoli metodi che ho fatto per impostare le singole properties
        String name = chooseTitle();
        String description = chooseDescription();
        LocalDate expiration = chooseDateOfExpiration();
        ToDo.Priorities pr = choosePriority();
        ToDo.States st = chooseState();
        ToDo t = new ToDo(name, description, expiration, pr, st);

        //ultima conferma finale
        System.out.printf("Stai aggiungendo il seguente TO-DO \n%s", t.prettyPrint());
        System.out.println();
        if(confirm()){
            ToDoRepository repo = null;
            try{
                repo = ToDoRepository.getToDoRepository();
            }
            catch (Exception e) {
                System.out.println("COLTA ECCEZIONE NEL CARICAMENTO INIZIALE DEL REPOSITORY");
                System.out.println("\n");
            }

            repo.add(t);
            System.out.println("OPERAZIONE ESEGUITA!");
        }
        else System.out.println("OPERAZIONE ANNULLATA");
        System.out.println();
    }

    /* Chiede quale Id si vuole modificare
    // Si chiede un "clone" del TO-DO
    // Loop di richiesta dati da modificare
    // Salvataggio delle modifiche tramite ToDoRepository (update...) */
    public static void updateToDo() {
        System.out.println("Qual'e' l'ID del TO-DO da modificare?");
        Scanner in = new Scanner (System.in);
        Long id = (Long) in.nextLong();

        ToDoRepository repo = null;
        try{
            repo = ToDoRepository.getToDoRepository();
        }
        catch (Exception e) {
            System.out.println("COLTA ECCEZIONE NEL CARICAMENTO INIZIALE DEL REPOSITORY");
            System.out.println("\n");
        }
        //stampa del TO-DO scelto se esiste, altrimenti di un messaggio di errore
        if(!repo._data.containsKey(id)){
            System.out.println("ERRORE: ID non presente");
            return;
        }

        ToDo oldToDo = repo._data.get(id);
        System.out.println(oldToDo.prettyPrint());

        //loop di richiesta di quali dati cambiare
        ToDo t = null;
        try{
            t = oldToDo.cloneForUpdate();
        }
        catch (CloneNotSupportedException cnse){
            System.out.println("ERRORE! To Do non clonabile");
        }

        String input = "";

        System.out.println("Vuoi cambiare il titolo?");
        if(confirm()){
            input = chooseTitle();
            t.setTitle(input);
        }
        System.out.println("Vuoi cambiare la descrizione?");
        if(confirm()){
            input = chooseDescription();
            t.setDescription(input);
        }
        System.out.println("Vuoi cambiare la data di scadenza?");
        if(confirm()){
            LocalDate inputDate = chooseDateOfExpiration();
            t.setDateOfExpiration(inputDate);
        }
        System.out.println("Vuoi cambiare la priorità?");
        if(confirm()){
            t.setPriority(choosePriority());
        }
        System.out.println("Vuoi cambiare lo stato?");
        if(confirm()){
            t.setState(chooseState());
        }

        //chiedo ultima conferma prima di cambiare
        System.out.printf("Stai sostituendo il seguente TO-DO \n%s \n", oldToDo.prettyPrint());
        System.out.printf("con il seguente TO-DO \n%s\n", t.prettyPrint());
        System.out.println();
        if(confirm()){
            repo.update(t);
            System.out.println("OPERAZIONE ESEGUITA!");
        }
        else System.out.println("OPERAZIONE ANNULLATA");
        System.out.println();
    }

    public static void removeToDo() {
        System.out.println("Qual'e' l'ID del TO-DO da eliminare?");
        Scanner in = new Scanner (System.in);
        Long id = (Long) in.nextLong();

        ToDoRepository repo = null;
        try{
            repo = ToDoRepository.getToDoRepository();
        }
        catch (Exception e) {
            System.out.println("COLTA ECCEZIONE NEL CARICAMENTO INIZIALE DEL REPOSITORY");
            System.out.println("\n");
        }
        //stampa del TO-DO scelto se esiste, altrimenti di un messaggio di errore
        if(!repo._data.containsKey(id)){
            System.out.println("ERRORE: ID non presente");
            return;
        }

        ToDo oldToDo = repo._data.get(id);

        System.out.printf("Stai eliminando il seguente TO-DO \n%s", oldToDo.prettyPrint());
        System.out.println();
        if(confirm()){
            repo.delete(id);
            System.out.println("OPERAZIONE ESEGUITA!");
        }
        else System.out.println("OPERAZIONE ANNULLATA");
        System.out.println();
    }

    //todo meglio implementare un try-catch o lascio stacktrace automatico se utente dà formato non applicabile? vale anche per tutti i metodi .chooseX() più sotto
    public static String chooseTitle(){
        System.out.println("Scegli un titolo per il To-Do");
        Scanner in = new Scanner (System.in);
        String name = in.nextLine();
        return name;
    }

    public static String chooseDescription(){
        System.out.println("Scegli una descrizione per il To-Do");
        Scanner in = new Scanner (System.in);
        String description = in.nextLine();
        return description;
    }

    //todo qui quasi sicuramente dovrei controllare che non sia data vecchia
    public static LocalDate chooseDateOfExpiration(){
        Scanner in = new Scanner (System.in);
        System.out.println("Scegli un anno di scadenza IN CIFRE per il To-Do");
        int year = Integer.parseInt(in.nextLine());
        System.out.println("Scegli un mese di scadenza IN CIFRE per il To-Do");
        int month = Integer.parseInt(in.nextLine());
        System.out.println("Scegli un giorno di scadenza IN CIFRE per il To-Do");
        int day = Integer.parseInt(in.nextLine());
        LocalDate expiration = LocalDate.of(year, month, day);
        return expiration;
    }

    public static ToDo.Priorities choosePriority(){
        System.out.println("Scegli una priorità per il To-Do SOLAMENTE tra: ALTA, MEDIA, BASSA");

        Scanner in = new Scanner (System.in);
        String priority = in.nextLine();
        ToDo.Priorities pr = null;
        if(priority.equalsIgnoreCase("alta")){
            pr = ToDo.Priorities.ALTA;
        }else if(priority.equalsIgnoreCase("media")){
            pr = ToDo.Priorities.MEDIA;
        }else if(priority.equalsIgnoreCase("BASSA")){
            pr = ToDo.Priorities.BASSA;
        } else{
            pr = ToDo.Priorities.ALTA;
            System.out.println("Input non comprensibile. Priorità impostata ad ALTA di default, modificare il" +
                    "TO-DO per cambiarla.");
        }
        return pr;
    }

    public static ToDo.States chooseState(){
        System.out.println("Scegli una priorità per il To-Do SOLAMENTE tra: DA_FARE, IN_ESECUZIONE, COMPLETATA, ANNULLATA");
        Scanner in = new Scanner (System.in);
        String state = in.nextLine();
        ToDo.States st = null;
        if(state.equalsIgnoreCase("DA_FARE")){
            st = ToDo.States.DA_FARE;
        }else if(state.equalsIgnoreCase("IN_ESECUZIONE")){
            st = ToDo.States.IN_ESECUZIONE;
        }else if(state.equalsIgnoreCase("COMPLETATA")){
            st = ToDo.States.COMPLETATA;
        }else if(state.equalsIgnoreCase("ANNULLATA")){
            st = ToDo.States.ANNULLATA;
        }else{
            st = ToDo.States.DA_FARE;
            System.out.println("Input non comprensibile. Stato impostato a DA_FARE di default, modificare il" +
                    "TO-DO per cambiarla.");
        }

        return st;
    }

    private static boolean confirm(){
        boolean confirmation = false;
        System.out.println();
        System.out.println("Sei sicuro? Digita il carattere S per confermare o altro per annullare");

        Scanner in = new Scanner (System.in);
        String answer = in.nextLine();
        confirmation = answer.equalsIgnoreCase("S");
        return confirmation;
    }
}
