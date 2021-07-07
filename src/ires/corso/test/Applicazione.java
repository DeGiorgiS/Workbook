package ires.corso.test;

import java.io.IOException;
import java.time.LocalDate;
import java.util.*;

public class Applicazione {

    public static void main(String[] args){
        //inizializzo il repository
        Biblioteca.init("Biblioteca.ser");
        Biblioteca biblio = null;

        try{
            biblio = Biblioteca.getBiblio();
        }
        catch(ClassNotFoundException cnfe){
            printerLine("Non è stato possibile trovare la classe in fase di getter della Biblioteca");
        }
        catch(IOException ioe){
            printerLine("Errore Input/Output in fase di getter della Biblioteca");
        }

        //mia parte di test per riempire inizialmente la biblioteca
        /*Libro l1 = new Libro("il signore degli anelli", "j.r.r. tolkien", "fantasy famoso", "ISBN000001",
                LocalDate.parse("1990-02-15"), Libro.Genere.FANTASY);
        Libro l2 = new Libro("IT", "Stephen King", "pagliaccio cattivo", "ISBN000002",
                LocalDate.parse("2000-09-01"), Libro.Genere.HORROR);
        Libro l3 = new Libro("il ciclo della fondazione", "isaac asimov", "epopea fantascientifica", "ISBN000003",
                LocalDate.parse("1980-05-03"), Libro.Genere.FANTASCIENZA);
        Libro l4 = new Libro("la storia di Roma", "alberto angela", "i romani nei dettagli", "ISBN000004",
                LocalDate.parse("2021-01-25"), Libro.Genere.SAGGIO);
        Libro l5 = new Libro("game of thrones", "g.r.r. martin", "fantasy dove muoiono tutti", "ISBN000005",
                LocalDate.parse("2000-07-20"), Libro.Genere.FANTASY);
        biblio.add(l1);
        biblio.add(l2);
        biblio.add(l3);
        biblio.add(l4);
        biblio.add(l5);*/

        //header del menu
        boolean quit = false;
        printerLine("---------------");
        printerLine("|LA BIBLIOTECA|");
        printerLine("---------------");

        //menu con le scelte
        Scanner in = new Scanner(System.in);
        while(!quit) {
            menuPrinter();
            printerLine("Indica cosa vuoi fare selezionando un'opzione");
            switch (in.nextLine()) {
                case "1":
                    List<Libro> lista = biblio.getListaLibri();
                    Collections.sort(lista,
                            Comparator.comparing(Libro::getTitolo));
                    lista.stream().map(Libro::prettyPrint).forEach(Applicazione::printerLine);
                    break;

                case "2":
                    BibliotecaManager.aggiungiLibro(biblio);
                    break;

                case "3":
                    BibliotecaManager.modificaLibro(biblio);
                    break;


                case "4":
                    printerLine("Inserisci l'ID del libro da rimuovere");
                    Long idRemove = Long.parseLong(in.nextLine());
                    if (biblio.getLibro(idRemove) == null){
                        break; //interrompo se il libro non c'è
                    }
                    printerLine("Stai rimuovendo il seguente libro: \n" + biblio.getLibro(idRemove).prettyPrint());
                    if (confirm()) {
                        biblio.remove(idRemove);
                        printerLine("Libro rimosso!");
                    }
                    break;

                case "5":
                    printerLine("Inserisci l'ID del libro che stai leggendo");
                    Long idRead = Long.parseLong(in.nextLine());
                    Libro libroAperto = biblio.getLibro(idRead); //controllo se ID è presente viene fatto in Biblioteca
                    if (libroAperto == null){
                        break; //interrompo se il libro non c'è
                    }
                    printerLine("Stai leggendo il seguente libro: \n" + libroAperto.prettyPrint());
                    printerLine("Inserisci un valore tra 0 e 100 per indicare l'avanzamento della lettura");
                    int quantoLetto = in.nextInt();
                    libroAperto.setAvanzamentoLettura(quantoLetto); //i controlli su valore tra 0 e 100 viene fatto in classe Libro
                    //todo aggiungo che se inserisco lettura 100 mi lancia la possibilità di mettere un giudizio
                    break;

                case "6":
                    printerLine("Inserisci l'ID del libro da recensire");
                    Long idVoto = Long.parseLong(in.nextLine());
                    Libro libroGiudizio = biblio.getLibro(idVoto); //controllo se ID è presente viene fatto in Biblioteca
                    if (libroGiudizio == null){
                        break; //interrompo se il libro non c'è
                    }
                    if (!libroGiudizio.isLettoTutto()){
                        printerLine("Non hai letto tutto il libro! Riprova quando lo avrai finito!");
                        break;
                    }
                    printerLine("Stai recensendo il seguente libro: \n" + libroGiudizio.prettyPrint());

                    printerLine("Indica il giudizio sul libro usando la scala: BRUTTO, DECENTE, BELLO, MAGNIFICO, CAPOLAVORO");
                    Libro.GiudizioPersonale giudizio = Libro.GiudizioPersonale.valueOf(in.nextLine().toUpperCase());
                    printerLine("Stai dando il giudizio " + giudizio + " al libro " + libroGiudizio.getTitolo());

                    if(confirm()){
                        libroGiudizio.setGiudizio(giudizio);
                        printerLine("Giudizio aggiunto con successo!");
                    }
                    break;

                case "7":
                    printerLine("Inserisci il nome del file da usare per l'export, usa il formato NomeDelFile.txt");
                    String fileName = in.nextLine();
                    try {
                        ExportTestuale.exportToFile(fileName, biblio);
                        printerLine("Export riuscito correttamente");
                    }
                    catch (IOException ioe){
                        printerLine("IOEXCEPTION nel export testuale");
                    }
                    catch (ClassNotFoundException cnfe){
                        printerLine("CLASSNOTFOUNDEXCEPTION nel export testuale");
                    }
                    break;

                case "X":

                case "x":
                    printerLine("Stai uscendo");
                    if(confirm()){
                        try {
                            biblio.serialize();
                            quit = true;
                        }
                        catch (IOException ioe){
                            printerLine("ERRORE INPUT/OUTPUT in fase di serializzazione della Biblioteca");
                        }
                    }
                    break;

                default:
                    printerLine("Non ho capito cosa vuoi fare, riprova!");
                    break;
            }
        }
    }

    public static void printerLine(String s){
        System.out.println(s);
    }

    //todo da togliere da qua
    public static Libro creazioneLibro(){
        Scanner in = new Scanner(System.in);

        printerLine("Indica il titolo del libro");
        String titolo = in.nextLine();

        printerLine("Indica l'autore del libro");
        String autore = in.nextLine();

        printerLine("Indica una breve descrizione del libro");
        String sinossi = in.nextLine();

        boolean isbnValid = false;
        String isbn = null;
        while(!isbnValid) {
            printerLine("Indica l'ISBN di 10 caratteri del libro");
            isbn = in.nextLine();

            if(isbn.length() == 10) isbnValid = true;
            else printerLine("DEVE CONTENERE 10 CARATTERI");
        }

        //todo dovrei implementare un controllo sull'input con catch dell'errore ma non ho tempo
        printerLine("Indica la data di pubblicazione del libro (formato AAAA-MM-GG)");
        LocalDate dataPubb = LocalDate.parse(in.nextLine());

        //todo dovrei implementare un controllo sull'input con catch dell'errore ma non ho tempo
        printerLine("Indica il genere del libro (solo tra: HORROR, FANTASY, FANTASCIENZA, SAGGIO)");
        Libro.Genere genere = Libro.Genere.valueOf(in.nextLine().toUpperCase());

        Libro l = new Libro(titolo, autore, sinossi, isbn, dataPubb, genere);
        return l;
    }

    public static boolean confirm(){
        printerLine("CONFERMI??? Inserisci S per confermare o un altro tasto per annullare.");
        Scanner in = new Scanner(System.in);
        String answer = in.nextLine();
        return answer.equalsIgnoreCase("S");
    }

    public static void menuPrinter(){
        printerLine("_____________________________________");
        printerLine("1.Visualizza volumi");
        printerLine("2.Aggiungi un volume");
        printerLine("3.Modifica un volume");
        printerLine("4.Rimuovi un volume");
        printerLine("5.Cambia avanzamento lettura");
        printerLine("6.Inserisci giudizio personale");
        printerLine("7.Export testuale");
        printerLine("X.Uscita");
    }
}
