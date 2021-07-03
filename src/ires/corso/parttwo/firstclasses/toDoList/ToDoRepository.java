package ires.corso.parttwo.firstclasses.toDoList;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;


/* GESTORE DELL'ARCHIVIO DEI TO-DO == DATABASE */

// Contiene una HashMap di tutti i TO-DO a sistema:
// - implementa il metodo di salvataggio su file
// - implementa il metodo di caricamento da file
// - metodi per individuare, aggiungere, eliminare un TO-DO
// - restituisce una copia di tutti i TO-DO come ArrayList, da
//   usare per le visualizzazioni di ToDoList

public class ToDoRepository implements Serializable {


    private static boolean _init = false; //flag che indica se il Repo è stato già inizializzato
    private static String _fileName; //contiene il nome del file da usare in serializzazione e deserializzazione

    // UNICA istanza del repository, dichiarata come membro static della classe ToDoRepository
    private static ToDoRepository _repository = null;

    //imposta il file dove faremo serializzazione/deserializzazione con catch di eccesione
    public static boolean initialization(String fileName){
        try{
            Path p = Paths.get(fileName);
            _fileName = p.toString();
            _init = true;
        }
        catch (InvalidPathException ipe){
            System.out.println("Trovata una InvalidPathException nell'inizializzazione");
            System.out.println();
        }
        return _init;
    }

    // Deserializza l'istanza del ToDoRepository da file
    public static ToDoRepository loadFromFile() {
        try (FileInputStream file = new FileInputStream(_fileName);
             ObjectInputStream in = new ObjectInputStream(file))
        {
            _repository = (ToDoRepository) in.readObject();
            System.out.println("Il repository di ToDo è stato deserializzato");
        }
        catch(IOException e){
            System.out.println("Trovata una IOException nella deserializzazione");
            System.out.println();
        }
        catch(ClassNotFoundException e){
            System.out.println("Trovata una ClassNotFoundException nella deserializzazione");
            System.out.println();
        }
        return _repository;
    }

    // Costruttore privato: non è possibile generare ToDoRepository con "new" dall'esterno
    private ToDoRepository(){}

    // Carica Repo da file, restituendo sempre la stessa istanza (quella serializzata/deserializzata da file)
    public static ToDoRepository getToDoRepository() throws Exception{
        if(!_init){
            throw new Exception("REPOSITORY NON ANCORA INIZIALIZZATO!!! da chiamare il metodo .initialization()");
        }

        if(_repository == null){
            if(!Files.exists(Paths.get(_fileName)))
                _repository = new ToDoRepository();
            else
                loadFromFile();
        }
        return _repository;
    }

    Map<Long, ToDo> _data = new HashMap<>();    //mappa con KEY: id; VALUE: oggetto TO-DO
    private long _idSeed;                       //contatore per la generazione degli ID

    // Utilizzato per generare un nuovo ID
    public long getNewId() {
        _idSeed++;
        return _idSeed;
    }

    //cancellazione di un TO-DO dal repository
    public void delete(Long ID) {
        _data.remove(ID);
    }

    //todo probabilmente riesco a farci la stessa cosa internamente ad update
    public void add(ToDo t) {
        _data.put(t.getEntityID(), t);
    }

    //aggiornamento dei TO-DO dal repository
    public void update(ToDo t) {
        //prendo ID del To-Do inserito
        Long id = t.getEntityID();

        //controllo esista già un to-do con quel ID
        boolean alreadyTakenID = false;
        for (Long ids:
             _data.keySet()) {
            if(id.equals(ids)){
                alreadyTakenID = true;
                break;
            }
        }

        //eseguo l'update
        if(alreadyTakenID) _data.remove(id);
        _data.put(id, t);
    }
/*
    //booleano che controlla se il TO-DO dato in argomento esista, da implementare un metodo di uguaglianza in classe TO-DO
    public boolean existence(ToDo t){
        boolean itExists = false;
        for (ToDo v:
                _data.values()) {
            if(v.equals(t)){itExists = true;}
        }
        return itExists;
    }*/

    //restituisce un ArrayList con i TO-DO
    public ArrayList<ToDo> getToDoList() {
        ArrayList<ToDo> toDoAsList= new ArrayList<>();

        //con metodo compatto
        toDoAsList.addAll(_data.values());

        return toDoAsList;
    }

    // Salva tutta l'istanza del repository (compresi gli oggetti
    // TO-DO presenti in mappa) in un file tramite il metodo
    // writeObject di ObjectOutputStream.
    // Anche il membro idSeed è salvato su file (è variabile di istanza).
    public void writeToFile() {
        try (FileOutputStream file = new FileOutputStream(_fileName);
             ObjectOutputStream out = new ObjectOutputStream(file)){
            out.writeObject(this);
            System.out.println("Il repository dei ToDo è stato serializzato");
        }
        catch(IOException e){
            System.out.println("Trovata una IOException nella serializzazione");
            System.out.println();
        }
    }
}
