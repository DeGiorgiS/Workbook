package ires.corso.parttwo.firstclasses.toDoList;

import java.time.LocalDate;
import java.util.Scanner;

public class ToDoApplication {
    // 1. Deserializza il repository da file (carica i dati dell'ultimo salvataggio)
    //    creando una classe Repository
    // 2. Gestione del MENU principale con un loop e due switch
    // 3. In corrispondenza di una scelta dell'utente (ramo dello switch) chiama
    //    le classi necessarie per svolgere l'azione
    // 4. Chiede conferma e serializza in uscita
    // 5. Fornisce anche i metodi della classe "lettore" di quiz... askForInput , display

    public static void main (String[] args){
        ToDoRepository repo = null;
        repo = ToDoRepository.loadFromFile("ToDoExercise"); //todo da sistemare il nome del file di default

        //incipit
        System.out.println("------------------------");
        System.out.println("|TO DO LIST APPLICATION|");
        System.out.println("------------------------");

        boolean quit = false;
        Scanner in = new Scanner(System.in);

        while(!quit){
            System.out.println("1. VISUALIZZA");
            System.out.println("2. AGGIUNGI, RIMUOVI, MODIFICA");
            System.out.println("3. IMPORT/EXPORT");
            System.out.println("4. USCITA");
            System.out.println("Seleziona cosa fare digitando il numero corrispondente");
            System.out.print("==>");

            //scelta dell'azione
            switch(in.nextLine()){
                case "1":
                    System.out.println("1. ORDINA PER PRIORITà");
                    System.out.println("2. ORDINA PER STATO");
                    System.out.println("3. ORDINA PER DATA");
                    System.out.println("Seleziona cosa fare digitando il numero corrispondente");
                    System.out.print("==>");
                    switch(in.nextLine()){
                        case "1": //todo chiama metodo per ordinare per priorità
                        case "2": //todo chiama metodo per ordinare per stato
                        case "3": //todo chiama metodo per ordinare per data
                        default:
                            System.out.println("Non ho capito la tua richiesta. Torno al menù principale");
                    }

                case "2":
                    System.out.println("1. AGGIUNGI");
                    System.out.println("2. RIMUOVI");
                    System.out.println("3. MODIFICA");
                    System.out.println("Seleziona cosa fare digitando il numero corrispondente");
                    System.out.print("==>");
                    switch(in.nextLine()){
                        case "1": repo.add();
                        case "2": //todo chiama metodo per ordinare per stato
                        case "3": //todo chiama metodo per ordinare per data
                        default:
                            System.out.println("Non ho capito la tua richiesta. Torno al menù principale");
                    }

            }
        }
    }
}
