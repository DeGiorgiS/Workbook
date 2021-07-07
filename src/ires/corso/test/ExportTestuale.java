package ires.corso.test;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

public class ExportTestuale {

    //metodo di export testuale su file
    public static void exportToFile(String fileName, Biblioteca biblio) throws IOException, ClassNotFoundException {
        try(PrintWriter outputWriter = new PrintWriter(new FileWriter(fileName))){

            //prendo la lista dei libri presenti in Biblioteca e ci creo un iteratore
            List<Libro> listaLibri = biblio.getListaLibri();
            Iterator<Libro> itrLibri = listaLibri.iterator();

            while(itrLibri.hasNext()){
                String libroStringa = itrLibri.next().prettyPrint();
                outputWriter.println(libroStringa);
            }
        }
    }
}
