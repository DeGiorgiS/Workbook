package ires.corso.parttwo.firstclasses.toDoList;

import java.time.LocalDate;
import java.util.ArrayList;
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
        //inizializzazione del repository
        ToDoRepository.initialization("ToDoExercise.ser");
        ToDoRepository repo = null;
        try{
            repo = ToDoRepository.getToDoRepository();
        }
        catch (Exception e) {
            printer("COLTA ECCEZIONE NEL CARICAMENTO INIZIALE DEL REPOSITORY");
            printer("\n");
        }

        //TO-DO aggiunti a mano per test classe main todo da eliminare
        /*try
        {
            ToDo t1 = new ToDo("prova 1", "la prima prova", LocalDate.of(2021, 02, 10), ToDo.Priorities.ALTA, ToDo.States.COMPLETATA);
            ToDo t2 = new ToDo("prova 2", "la seconda prova", LocalDate.of(2021, 04, 10), ToDo.Priorities.MEDIA, ToDo.States.IN_ESECUZIONE);
            ToDo t3 = new ToDo("prova 3", "la terza prova", LocalDate.of(2021, 01, 10), ToDo.Priorities.BASSA, ToDo.States.DA_FARE);
            ToDo t4 = new ToDo("prova 4", "la quarta prova", LocalDate.of(2021, 05, 10), ToDo.Priorities.MEDIA, ToDo.States.ANNULLATA);
            repo.add(t1);
            repo.add(t2);
            repo.add(t3);
            repo.add(t4);
        }
        catch (Exception e){
            printer("ECCEZIONE NELLA CREAZIONE DEI TODO DI TEST");
        }*/

        //incipit
        printer("------------------------");
        printer("|TO DO LIST APPLICATION|");
        printer("------------------------");

        boolean quit = false;
        ToDoList tdl = new ToDoList();
        Scanner in = new Scanner(System.in);

        while(!quit){
            printer("\n");
            printer("1. VISUALIZZA");
            printer("2. AGGIUNGI, RIMUOVI, MODIFICA");
            printer("3. IMPORT/EXPORT");
            printer("X. USCITA");
            printer("\n");
            boolean insideQuit = false; //variabile usata per il loop dei sotto-menù in caso di scelta non valida
            askForInputNum();

            //scelta dell'azione
            switch(in.nextLine()){
                case "1":
                    printer("\n");
                    printer("1. VISUALIZZA E ORDINA PER PRIORITà");
                    printer("2. VISUALIZZA E ORDINA PER STATO");
                    printer("3. VISUALIZZA E ORDINA PER DATA");
                    printer("X. TORNA INDIETRO");
                    askForInputNum();
                    while(!insideQuit) {
                        tdl.listGetter(); //prendo la lista dal Repo
                        switch (in.nextLine()) {
                            case "1":
                                printer(tdl.print(tdl.viewByPriority()));
                                insideQuit = true;
                                break;
                            case "2":
                                printer(tdl.print(tdl.viewByState()));
                                insideQuit = true;
                                break;
                            case "3":
                                printer(tdl.print(tdl.viewByExpiration()));
                                insideQuit = true;
                                break;
                            case "X":
                            case "x":
                                insideQuit = true;
                                break;
                            default:
                                inputNotValid();
                                break;
                        }
                    }
                    break;

                case "2":
                    printer("\n");
                    printer("1. AGGIUNGI");
                    printer("2. RIMUOVI");
                    printer("3. MODIFICA");
                    printer("X. TORNA INDIETRO");
                    askForInputNum();
                    while(!insideQuit) {
                        switch (in.nextLine()) { //todo forse dovrei spostare qui la parte testuale del ToDoManager???
                            case "1":
                                //metodo di creazione testuale di un TO-DO
                                try {
                                    ToDoManager.createNewToDo();
                                    insideQuit = true;
                                } catch (Exception e) {
                                    printer("ECCEZIONE NELLA CREAZIONE DI UN NUOVO TO-DO");
                                }
                                break;
                            case "2":
                                //metodo di rimozione testuale di un TO-DO
                                ToDoManager.removeToDo();
                                insideQuit = true;
                                break;
                            case "3":
                                //metodo di modifica testuale di un TO-DO
                                ToDoManager.updateToDo(); //todo posso impostare un controllo che se ID inesistente mi faccia riprovare l'inserimento?
                                insideQuit = true;
                                break;
                            case "X":
                            case "x":
                                insideQuit = true;
                                break;
                            default:
                                inputNotValid();
                                break;
                        }
                    }
                    break;

                case "3":
                    printer("\n");
                    printer("1. IMPORTA DA FILE TESTUALE");
                    printer("2. ESPORTA SU FILE TESTUALE");
                    printer("X. TORNA INDIETRO");
                    askForInputNum();
                    while(!insideQuit) {
                        switch (in.nextLine()) {
                            case "1":
                                try {
                                    ToDoImportExport.importFromFile("ToDoImport.txt");
                                    printer("IMPORT ESEGUITO CON SUCCESSO");
                                } catch (Exception e) {
                                    printer("ECCEZIONE nel import da testo di To-Do");
                                }
                                insideQuit = true;
                                break;

                            case "2":
                                try {
                                    ToDoImportExport.exportToFile("ToDoExport.txt");
                                    printer("EXPORT ESEGUITO CON SUCCESSO");
                                } catch (Exception e) {
                                    printer("ECCEZIONE nel export su testo di To-Do");
                                }
                                insideQuit = true;
                                break;
                            case "X":
                            case "x":
                                insideQuit = true;
                                break;
                            default:
                                inputNotValid();
                                break;
                        }
                    }
                    break;

                //costruzione usata per unire i comportamenti in caso di scelta di "X" maiuscola o minuscola
                case "X":

                case "x":
                    printer("SEI SICURO DI VOLER USCIRE? Digita il carattere \"S\" per confermare o un altro tasto per annullare");
                    String answer = in.nextLine();
                    if(answer.equalsIgnoreCase("S")){
                        repo.writeToFile();
                        quit = true;
                    }
                    break;


                default:
                    inputNotValid();
                    break;
            }
        }
    }

    public static void printer(String s){
        consolePrinter(s);
    }

    public static void consolePrinter(String s){
        System.out.println(s);
    }

    public static void askForInputNum(){
        printer("Seleziona cosa fare digitando il numero corrispondente o un altro tasto per tornare al menù principale");
        System.out.print("==>");
    }

    public static void inputNotValid(){
        printer("Non ho capito la tua richiesta. Riprova.");
    }
}
