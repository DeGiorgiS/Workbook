package ires.corso.parttwo.firstclasses.toDoList;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.stream.Stream;

public class ToDoImportExport {
    // Gestisce import/export da file
    // Mantiene i formati di import e di export (conversione da/verso stringa)

    private static String toStringConverter(ToDo t){
        String result = String.format("%s|%s|%s|%s|%s|%s|%s", t.getEntityID().toString(), t.getTitle(), t.getDescription(),
                t.getDateOfCreation().toString(), t.getDateOfExpiration().toString(), t.getPriority().toString(),
                t.getState().toString());
        return result;
    }

    private static ToDo toToDoConverter(String[] args) throws Exception{
        if(args.length != 7){
            throw new Exception("L'ARRAY NON è LEGGIBILE COME UNA LISTA DI PROPRIETà ACCETTABILE");
        }

        //properties da estrarre, tranne ID che verrà ri-settato
        Long id;
        String title = null;
        String description = null;
        LocalDate dateCreation;
        LocalDate dateExpiration = null;
        ToDo.Priorities priority = null;
        ToDo.States state = null;


        //controlli sui valori delle properties
        if(args[1] != null)
            title = args[1];
        else
            System.out.println("Il titolo era nullo.");

        if(args[2] != null)
            description = args[2];
        else
            System.out.println("La descrizione era nulla.");

        if(args[4] != null)
            dateExpiration = LocalDate.parse(args[4]);
        else
            System.out.println("La data di creazione era nulla.");

        if(args[5].equals("ALTA")){
            priority = ToDo.Priorities.ALTA;
        }
        else if(args[5].equals("MEDIA")){
            priority = ToDo.Priorities.MEDIA;
        }
        else if(args[5].equals("BASSA")){
            priority = ToDo.Priorities.BASSA;
        }
        else
            System.out.println("Valore di priorità nullo o non valido.");

        if(args[6].equals("DA_FARE")){
            state = ToDo.States.DA_FARE;
        }
        else if(args[6].equals("IN_ESECUZIONE")){
            state = ToDo.States.IN_ESECUZIONE;
        }
        else if(args[6].equals("COMPLETATA")){
            state = ToDo.States.COMPLETATA;
        }
        else if(args[6].equals("ANNULLATA")){
            state = ToDo.States.ANNULLATA;
        }
        else
            System.out.println("Valore di stato nullo o non valido.");

        ToDo td = new ToDo(title, description, dateExpiration, priority, state);
        return td;
    }

    //prende in input il nome del file su cui salvare e ci esporta il Repo di To-Do
    public static void exportToFile(String fileName){
        try(PrintWriter outputStream = new PrintWriter(new FileWriter(fileName)))
        {
            //trasformo in una lista e ci creo iteratore
            ArrayList<ToDo> tdl = ToDoRepository.getToDoRepository().getToDoList();
            Iterator<ToDo> itrToDo = tdl.iterator();

            //ciclo sull'iteratore stampando lo stream sul file indicato
            while(itrToDo.hasNext()){
                String strToDo = toStringConverter(itrToDo.next());
                outputStream.println(strToDo);
            }
        }
        catch (IOException ioe){
            ioe.getStackTrace();
        }
        catch (Exception e){
            e.getStackTrace();
        }
    }

    //prende in input un file da cui caricare una lista di To-Do
    //ipotesi: 1. formato in input rispetta quello del exportToFile; 2. l'ID viene ri-settato in fase di import dal Repo e anche la data di creazione
    //problemi: 1. formato non rispettato; 2. carattere di separazione usato nelle properties del To-Do
    //todo cerco se c'è un modo di trasformare format della serializzazione in stringa "leggibile dall'uomo"
    public static void importFromFile(String fileName) throws Exception{
        ArrayList<String> fileLines = new ArrayList<>();

        //todo ATTUALMENTE AGGIUNGE I TO-DO IMPORTATI, MA FACCIO UN SELETTORE SE AGGIUNGERE O SOVRASCRIVERE

        //trasformo il file di input in un array con le linee = To-Do
        try(BufferedReader inputStream = new BufferedReader(new FileReader(fileName))){
            String s;

            while((s = inputStream.readLine()) != null){
                fileLines.add(s); //vede i caratteri nel inputStream ma s resta stringa nulla
            }
        }
        catch (IOException ioe){
            ioe.getStackTrace();
        }

        //itero sulla lista di linee, trasformandole in oggetti To-Do
        Iterator<String> itrLines = fileLines.iterator(); //fileLines ha la riga prevista dal file in input
        int numImportedToDo = 0;
        while(itrLines.hasNext()){
            String line = itrLines.next();
            String[] splitter = line.split("\\|");

            ToDo td = toToDoConverter(splitter);

            ToDoRepository.getToDoRepository().add(td);
            numImportedToDo++;
        }

        System.out.printf("Sono stati importati %d nuovi TO-DO\n", numImportedToDo);
    }
}
