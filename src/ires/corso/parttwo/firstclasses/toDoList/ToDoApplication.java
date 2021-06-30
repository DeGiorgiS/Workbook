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
        repo = ToDoRepository.loadFromFile("ToDoExercise"); //todo da sistemare il nome del file di default
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
            askForInput();

            //scelta dell'azione
            switch(in.nextLine()){
                case "1":
                    printer("1. VISUALIZZA E ORDINA PER PRIORITà");
                    printer("2. VISUALIZZA E ORDINA PER STATO");
                    printer("3. VISUALIZZA E ORDINA PER DATA");
                    askForInput();
                    switch(in.nextLine()){
                        case "1":
                            tdl.viewByPriority();
                            printer(tdl.print());
                        case "2":
                            tdl.viewByPriority();
                            printer(tdl.print());
                        case "3":
                            tdl.viewByPriority();
                            printer(tdl.print());
                        default:
                            inputNotValid();
                    }

                case "2":
                    printer("1. AGGIUNGI");
                    printer("2. RIMUOVI");
                    printer("3. MODIFICA");
                    askForInput();
                    switch(in.nextLine()){
                        case "1":
                            ToDo t = new ToDo();
                            //metodo di creazione testuale di un todo
                            repo.add(t);
                        case "2": //todo chiama metodo per ordinare per stato
                        case "3": //todo chiama metodo per ordinare per data
                        default:
                            inputNotValid();
                    }

            }
        }
    }

    public static void printer(String s){
        consolePrinter(s);
    }

    public static void consolePrinter(String s){
        System.out.println(s);
    }

    public static void askForInput(){
        printer("Seleziona cosa fare digitando il numero corrispondente");
        System.out.print("==>");
    }

    public static void inputNotValid(){
        printer("Non ho capito la tua richiesta. Torno al menù principale");
    }
}
