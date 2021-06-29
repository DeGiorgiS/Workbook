package ires.corso.parttwo.firstclasses.toDoList;

import java.time.LocalDate;
import java.util.Scanner;

public class ToDoManager {
    // Classe responsabile per le operazioni sull'insieme dei TO-DO:
    // - metodi per creazione nuovo TO-DO
    // - metodi per la modifica, la rimozione
    // - gestisce input utente (cioè loop di richiesta di quali campi devono essere modificati)
    // - ha al suo interno funzioni di controllo sull'input utente

    public ToDo createNewToDo() {
        Scanner in = new Scanner (System.in);
        ToDo t = new ToDo();

        System.out.println("Scegli un titolo per il To-Do");
        String name = in.nextLine();

        System.out.println("Scegli una descrizione per il To-Do");
        String description = in.nextLine();

        System.out.println("Scegli un anno di scadenza per il To-Do");
        int year = Integer.parseInt(in.nextLine());
        System.out.println("Scegli un mese di scadenza per il To-Do");
        int month = Integer.parseInt(in.nextLine());
        System.out.println("Scegli un giorno di scadenza per il To-Do");
        int day = Integer.parseInt(in.nextLine());
        LocalDate expiration = LocalDate.of(year, month, day);

        //ancora da mettere priorità e stato
        System.out.println("Scegli una priorità per il To-Do SOLAMENTE tra: ALTA, MEDIA, BASSA");
        t.setPriority(Integer.parseInt(in.nextLine()));


        return t;
    }

    public void updateToDo() {
        // Chiede quale Id si vuole modificare
        // Si chiede un "clone" del TO-DO
        // Loop di richiesta dati da modificare
        // Salvataggio delle modifiche tramite ToDoRepository (update...)
    }
}
