package ires.corso.test;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Biblioteca implements Serializable{

    private static Biblioteca _biblio; //unica istanza del repository
    private static boolean _init;  //flag se ho inizializzato o no
    private static String _fileName; //file di serializzazione/deserializzazione

    //metodo inizializzazione
    public static void init(String fileName){
        Path p = Paths.get(fileName);
        _fileName = p.toString();
        _init = true;
    }

    //ritorna l'istanza della Biblioteca
    public static Biblioteca getBiblio() throws IOException, ClassNotFoundException{
        if(!_init){
            System.out.println("DEVI PRIMA INIZIALIZZARE IL REPOSITORY");
        }
        else{
            if(!Files.exists(Paths.get(_fileName))){
                _biblio = new Biblioteca();
            }
            else
                deserialize();
        }
        return _biblio;
    }

    //deserializzazione
    private static void deserialize() throws IOException, ClassNotFoundException {
        try(FileInputStream file = new FileInputStream(_fileName);
            ObjectInputStream in = new ObjectInputStream(file)){
            _biblio = (Biblioteca) in.readObject();
            System.out.println("Biblioteca deserializzata correttamente");
        }
    }

    //costruttore privato per non farlo istanziare dall'esterno
    private Biblioteca(){}


    private Map<Long, Libro> libriMap = new HashMap<>();    //mappa K: ID assegnato da Biblioteca; V: Libri
    private long idSeed;                                    //contatore univoco degli ID incrementale

    //aggiunta di un libro
    public void add(Libro l){
        libriMap.put(getIDSeed(), l);
    }

    //rimozione di un libro
    public void remove(Long id){
        if(libriMap.containsKey(id)){
            libriMap.remove(id);
        }
        else
            System.out.println("Libro non presente nella biblioteca");
    }

    //aggiornamento di un libro
    public void update(Long id, Libro nuovoLibro){
        if(isPresent(id)){
            libriMap.get(id);
            libriMap.put(id, nuovoLibro);
        }
        else
            System.out.println("Libro non presente nella biblioteca");
    }

    //ritorna una lista dei libri presenti nella Biblioteca
    public List<Libro> getListaLibri(){
        List<Libro> listaLibri = new ArrayList<>();
        listaLibri.addAll(libriMap.values());
        return listaLibri;
    }

    public Libro getLibro(Long id){
        if(isPresent(id)){
            return libriMap.get(id);
        }
        else{
            System.out.println("ID non presente");
            return null;
        }


    }

    public boolean isPresent(Long id){
        return libriMap.containsKey(id);
    }

    public void serialize() throws IOException{
        try(FileOutputStream file = new FileOutputStream(_fileName);
            ObjectOutputStream out = new ObjectOutputStream(file)){
            out.writeObject(this);
            System.out.println("Biblioteca serializzata correttamente");
        }
    }

    //prende ID ed aumenta il contatore interno
    private Long getIDSeed(){
        idSeed++;
        return idSeed;
    }
}
