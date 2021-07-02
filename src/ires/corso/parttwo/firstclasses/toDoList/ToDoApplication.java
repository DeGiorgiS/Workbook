package ires.corso.parttwo.firstclasses.toDoList;

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
        //todo se non trova il file, se lo crea
        repo = ToDoRepository.loadFromFile("ToDoExercise.txt"); //todo da sistemare il nome del file di default
        ToDoList tdl = new ToDoList();

        //incipit
        printer("------------------------");
        printer("|TO DO LIST APPLICATION|");
        printer("------------------------");

        boolean quit = false;
        Scanner in = new Scanner(System.in);

        while(!quit){
            printer("1. VISUALIZZA");
            printer("2. AGGIUNGI, RIMUOVI, MODIFICA");
            printer("3. IMPORT/EXPORT");
            printer("4. USCITA");
            askForInputNum();

            //scelta dell'azione
            switch(in.nextLine()){
                case "1":
                    printer("1. VISUALIZZA E ORDINA PER PRIORITà");
                    printer("2. VISUALIZZA E ORDINA PER STATO");
                    printer("3. VISUALIZZA E ORDINA PER DATA");
                    askForInputNum();
                    switch(in.nextLine()){
                        case "1":
                            tdl.viewByPriority();
                            printer(tdl.print());
                            break;
                        case "2":
                            tdl.viewByState();
                            printer(tdl.print());
                            break;
                        case "3":
                            tdl.viewByExpiration();
                            printer(tdl.print());
                            break;
                        default:
                            inputNotValid();
                            break;
                    }
                    break;

                case "2":
                    printer("1. AGGIUNGI");
                    printer("2. RIMUOVI");
                    printer("3. MODIFICA");
                    askForInputNum();
                    switch(in.nextLine()){ //todo forse dovrei spostare qui la parte testuale del ToDoManager???
                        case "1":
                            //metodo di creazione testuale di un TO-DO
                            ToDoManager.createNewToDo();
                            break;
                        case "2":
                            //metodo di rimozione testuale di un TO-DO
                            ToDoManager.removeToDo();
                            break;
                        case "3":
                            //metodo di modifica testuale di un TO-DO
                            ToDoManager.updateToDo();
                            break;
                        default:
                            inputNotValid();
                            break;
                    }
                    break;

                case "3": //todo da fare la classe apposita

                case"4":
                    printer("SEI SICURO DI VOLER USCIRE? Digita il carattere \"S\" per confermare o un altro tasto per annullare");
                    String answer = in.nextLine();
                    if(answer.equalsIgnoreCase("S")){
                        repo.writeToFile("ToDoExercise.txt"); //todo da sistemare il nome del file in output
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
        printer("Non ho capito la tua richiesta. Torno al menù principale");
    }
}
