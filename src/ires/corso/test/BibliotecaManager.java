package ires.corso.test;

import java.time.LocalDate;
import java.util.Scanner;

public class BibliotecaManager {

    public static void aggiungiLibro(Biblioteca biblio){
        Libro l = creazioneLibro();
        Applicazione.printerLine("Stai aggiungendo il seguente libro: \n" + l.prettyPrint());
        if (Applicazione.confirm()) {
            biblio.add(l);
            Applicazione.printerLine("Libro aggiunto!");
        }
    }

    public static void modificaLibro(Biblioteca biblio){
        Applicazione.printerLine("Inserisci l'ID del libro da modificare");
        Scanner in = new Scanner(System.in);
        Long idUpdate = Long.parseLong(in.nextLine());
        if(biblio.isPresent(idUpdate)){
            Libro lNew = creazioneLibro();
            Applicazione.printerLine("Stai togliendo il seguente libro: \n" + biblio.getLibro(idUpdate).prettyPrint());
            Applicazione.printerLine("per aggiungere il seguente libro: \n" + lNew.prettyPrint());
            if (Applicazione.confirm()) {
                biblio.update(idUpdate, lNew);
                Applicazione.printerLine("Aggiornamento riuscito!");
            }
        }
        else
            Applicazione.printerLine("ID non presente nella biblioteca!!!!");
    }

    public static Libro creazioneLibro(){
        Scanner in = new Scanner(System.in);

        Applicazione.printerLine("Indica il titolo del libro");
        String titolo = in.nextLine();

        Applicazione.printerLine("Indica l'autore del libro");
        String autore = in.nextLine();

        Applicazione.printerLine("Indica una breve descrizione del libro");
        String sinossi = in.nextLine();

        boolean isbnValid = false;
        String isbn = null;
        while(!isbnValid) {
            Applicazione.printerLine("Indica l'ISBN di 10 caratteri del libro");
            isbn = in.nextLine();

            if(isbn.length() == 10) isbnValid = true;
            else Applicazione.printerLine("DEVE CONTENERE 10 CARATTERI");
        }

        //todo dovrei implementare un controllo sull'input con catch dell'errore ma non ho tempo
        Applicazione.printerLine("Indica la data di pubblicazione del libro (formato AAAA-MM-GG)");
        LocalDate dataPubb = LocalDate.parse(in.nextLine());

        //todo dovrei implementare un controllo sull'input con catch dell'errore ma non ho tempo
        Applicazione.printerLine("Indica il genere del libro (solo tra: HORROR, FANTASY, FANTASCIENZA, SAGGIO)");
        Libro.Genere genere = Libro.Genere.valueOf(in.nextLine().toUpperCase());

        Libro l = new Libro(titolo, autore, sinossi, isbn, dataPubb, genere);
        return l;
    }
}
