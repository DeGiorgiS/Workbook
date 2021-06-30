package ires.corso.parttwo.firstclasses.toDoList;

import java.time.LocalDate;
import java.util.Scanner;

public class ToDoManager {
    // Classe responsabile per le operazioni sull'insieme dei TO-DO:
    // - metodi per creazione nuovo TO-DO
    // - metodi per la modifica, la rimozione
    // - gestisce input utente (cioè loop di richiesta di quali campi devono essere modificati)
    // - ha al suo interno funzioni di controllo sull'input utente

    private static Scanner in = new Scanner (System.in);

    public static void createNewToDo() {
        String name = choseTitle();
        String description = choseDescription();
        LocalDate expiration = choseDateOfExpiration();
        ToDo.Priorities pr = chosePriority();
        ToDo.States st = choseState();
        ToDo t = new ToDo(name, description, expiration, pr, st);

        System.out.printf("Stai aggiungendo il seguente TO-DO \n%s", t.prettyPrint());
        confirmAdd(t);
    }

    /* Chiede quale Id si vuole modificare
    // Si chiede un "clone" del TO-DO
    // Loop di richiesta dati da modificare
    // Salvataggio delle modifiche tramite ToDoRepository (update...) */
    public static void updateToDo() {
        System.out.println("Qual'e' l'ID del TO-DO da modificare?");
        Long id = (Long) in.nextLong();

        ToDoRepository repo = ToDoRepository.getToDoRepository();
        //stampa del TO-DO scelto
        ToDo oldToDo = repo._data.get(id);
        System.out.println(oldToDo.prettyPrint()); //todo gestione caso in cui l'ID non esiste

        //loop di richiesta di quali dati cambiare
        ToDo t = oldToDo.cloneForUpdate();
        boolean confirmation = false;
        String input = "";


        //todo vedere questo ciclo usando i metodi per choseX() per le varie voci
        System.out.println("Vuoi cambiare il titolo?");
        if(confirm()){
            System.out.println("Inserisci il nuovo titolo");
            input = in.nextLine();
            t.setTitle(input);
        }
        System.out.println("Vuoi cambiare la descrizione?");
        if(confirm()){
            System.out.println("Inserisci la nuova descrizione");
            input = in.nextLine();
            t.setDescription(input);
        }
        System.out.println("Vuoi cambiare la data di scadenza?");
        if(confirm()){
            System.out.println("Inserisci il nuovo anno in cifre");
            int anno = in.nextInt();
            System.out.println("Inserisci il nuovo mese in cifre");
            int mese = in.nextInt();
            System.out.println("Inserisci il nuovo giorno in cifre");
            int giorno = in.nextInt();
            t.setDateOfExpiration(LocalDate.of(anno, mese, giorno));
        }
        System.out.println("Vuoi cambiare la priorità?");
        if(confirm()){
            System.out.println("Inserisci");
        }
        System.out.println("Vuoi cambiare lo stato?");





        System.out.printf("Stai sostituendo il seguente TO-DO \n%s", oldToDo.prettyPrint());
        System.out.printf("con il seguente TO-DO \n%s", t.prettyPrint());
        System.out.println("Sei sicuro? Digita il carattere S per confermare o altro per annullare");

        confirmUpdate(t);
    }

    public static String choseTitle(){
        System.out.println("Scegli un titolo per il To-Do");
        String name = in.nextLine();
        return name;
    }

    public static String choseDescription(){
        System.out.println("Scegli una descrizione per il To-Do");
        String description = in.nextLine();
        return description;
    }

    public static LocalDate choseDateOfExpiration(){
        System.out.println("Scegli un anno di scadenza per il To-Do");
        int year = Integer.parseInt(in.nextLine());
        System.out.println("Scegli un mese di scadenza per il To-Do");
        int month = Integer.parseInt(in.nextLine());
        System.out.println("Scegli un giorno di scadenza per il To-Do");
        int day = Integer.parseInt(in.nextLine());
        LocalDate expiration = LocalDate.of(year, month, day);
        return expiration;
    }

    public static ToDo.Priorities chosePriority(){
        System.out.println("Scegli una priorità per il To-Do SOLAMENTE tra: ALTA, MEDIA, BASSA");
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

    public static ToDo.States choseState(){
        System.out.println("Scegli una priorità per il To-Do SOLAMENTE tra: DA_FARE, IN_ESECUZIONE, COMPLETATA, ANNULLATA");
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

    //todo tra i due metodi di conferma cambia solo l'operazione sul repo. Trasformo in booleano e metto l'operazione
    //todo in metodo che fa il resto?
    private static void confirmAdd(ToDo t){
        System.out.println("Sei sicuro? Digita il carattere S per confermare o altro per annullare");
        String answer = in.nextLine();
        if(answer.equalsIgnoreCase("S")){
            ToDoRepository repo = ToDoRepository.getToDoRepository();
            repo.add(t);
            System.out.println("OPERAZIONE ESEGUITA!");
        }
        else{
            System.out.println("OPERAZIONE ANNULLATA");
        }
    }

    private static void confirmUpdate(ToDo t){
        System.out.println("Sei sicuro? Digita il carattere S per confermare o altro per annullare");
        String answer = in.nextLine();
        if(answer.equalsIgnoreCase("S")){
            ToDoRepository repo = ToDoRepository.getToDoRepository();
            repo.update(t);
            System.out.println("OPERAZIONE ESEGUITA!");
        }
        else{
            System.out.println("OPERAZIONE ANNULLATA");
        }
    }

    private static boolean confirm(){
        boolean confirmation = false;
        System.out.println("Sei sicuro? Digita il carattere S per confermare o altro per annullare");
        String answer = in.nextLine();
        if(answer.equalsIgnoreCase("S")){
            confirmation = true;
        }
        else{
            confirmation = false;
        }
        return confirmation;
    }
}
