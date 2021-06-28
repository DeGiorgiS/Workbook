package ires.corso.parttwo.firstclasses.biblioteca;


// ArrayList
// Set
// Map

import java.time.LocalDate;
import java.util.*;

// 2. Biblioteca
//
//    Creare le seguenti classi:
//    - Libro (autore, data pubblicazione, num. pagine, num. volumi, num. capitoli)
//    - Categoria (titolo, descrizione)
//    - Utente (nome, cognome, id)
//    - Prestito (Utente, 1 o + Libro)
//
//    Create almeno 8 libri diversi e 5 categorie diverse.
//    Almeno 4 libri devono essere associati a più di una categoria.
//    Rappresentate opportunamente l'associazione tra libri e categorie in una struttura (basata sulle Java
//    collections) che permetta di ricavare agevolmente a quali categorie appartiene un libro.
//
//    Create poi almeno 3 utenti diversi.
//    Per ciascun utente create almeno 2 prestiti, con 2 o + volumi appartenenti a categorie distinte.
//    Rappresentate opportunamente l'associazione tra utenti e prestiti tramite una struttura (basata sulle
//    Java collections) che permetta di ricavare agevolmente quali prestiti ha eseguito un utente.
//
//    Incrociate i dati delle due strutture per costruire una terza struttura (basata.....) che dica
//    quanti e quali prestiti sono stati eseguiti per ciascuna categoria (vogliamo cioè fare un'analisi
//    statistica di quali siano le categorie più gradite).
//
//    Tutte le classi possono essere pensate come semplici strutture dati: quindi campi private e final,
//    valori dei campi da passare nel costruttore, solo metodi "getter" per recupare i valori.
public class Biblioteca {

    /*
    Create almeno 8 libri diversi e 5 categorie diverse.
    Almeno 4 libri devono essere associati a più di una categoria.
    Rappresentate opportunamente l'associazione tra libri e categorie in una struttura (basata sulle Java
    collections) che permetta di ricavare agevolmente a quali categorie appartiene un libro.
    Categorie: fantasy, storia, romanzo, saggistica, fantascienza
     */

    public static void main (String[] args) {
        //4 categorie
        HashSet<Categoria> categorie= new HashSet<>();
        Categoria fantasy = new Categoria("fantasy", "libri fantasy");
        categorie.add(fantasy);
        Categoria storia = new Categoria("storia", "libri di storia");
        categorie.add(storia);
        Categoria fantascienza = new Categoria("fantascienza", "libri di fantascienza");
        categorie.add(fantascienza);
        Categoria romanzi = new Categoria("romanzi", "libri con storie inventate");
        categorie.add(romanzi);
        Categoria saggistica = new Categoria("saggistica", "libri con fonti reali");
        categorie.add(saggistica);

        //8 libri
        HashSet<Libro> libri = new HashSet<>();
        Libro l1 = new Libro("The Lord of the Rings", "J.R.R. Tolkien",
                 LocalDate.of(1954, 07, 29), 1366, 3, 40);
        libri.add(l1);
        Libro l2 = new Libro("Idi di Marzo", "V.M. Manfredi",
                LocalDate.of(2008, 11, 13), 259, 1, 15);
        libri.add(l2);
        Libro l3 = new Libro("L ultimo giorno di Roma", "A. Angela",
                LocalDate.of(2020, 03, 11), 300, 3, 20);
        libri.add(l3);
        Libro l4 = new Libro("Io, Robot", "I. Asimov",
                LocalDate.of(1950, 05, 18), 200, 1, 10);
        libri.add(l4);
        Libro l5 = new Libro("Game of Thrones", "G.R.R. Martin",
                LocalDate.of(1996, 07, 20), 2000, 6, 100);
        libri.add(l5);
        Libro l6 = new Libro("Cronache del mondo emerso", "Licia Troisi",
                LocalDate.of(2004, 01, 25), 1000, 3, 30);
        libri.add(l6);
        Libro l7 = new Libro("Ubik", "P.K. Dick",
                LocalDate.of(1980, 02, 11), 150, 1, 10);
        libri.add(l7);
        Libro l8 = new Libro("I Pilastri della Terra", "K. Follett",
                LocalDate.of(2016, 04, 18), 1049, 1, 30);
        libri.add(l8);



        //abbinamento libri-categorie
        l1.setCategorie(Arrays.asList(fantasy, romanzi));
        l2.setCategorie(Arrays.asList(storia, romanzi));
        l3.setCategorie(Arrays.asList(storia, saggistica));
        l4.setCategorie(Arrays.asList(fantascienza, romanzi));
        l5.setCategorie(Arrays.asList(fantasy, romanzi));
        l6.setCategorie(Arrays.asList(fantasy, romanzi));
        l7.setCategorie(Arrays.asList(fantascienza, romanzi));
        l8.setCategorie(Arrays.asList(storia, romanzi));


    /*
    Create poi almeno 3 utenti diversi.
    Per ciascun utente create almeno 2 prestiti, con 2 o + volumi appartenenti a categorie distinte.
    Rappresentate opportunamente l'associazione tra utenti e prestiti tramite una struttura (basata sulle
    Java collections) che permetta di ricavare agevolmente quali prestiti ha eseguito un utente.
     */

       Utente aldo = new Utente("Aldo", "Baglio");
       Utente giovanni = new Utente("Giovanni", "Storti");
       Utente giacomo = new Utente("Giacomo", "Poretti");

       Prestito pAldo = new Prestito(aldo, Arrays.asList(l2,l4,l6));
       Prestito pGiovanni = new Prestito(giovanni, Arrays.asList(l1,l3));
       Prestito pGiacomo = new Prestito(giovanni, Arrays.asList(l7,l8));

       List<Prestito> prestiti = new ArrayList<>();
       prestiti.addAll(Arrays.asList(pAldo, pGiacomo, pGiovanni));

       /*
    Incrociate i dati delle due strutture per costruire una terza struttura (basata.....) che dica
    quanti e quali prestiti sono stati eseguiti per ciascuna categoria (vogliamo cioè fare un'analisi
    statistica di quali siano le categorie più gradite).
     */

        for (Categoria c:
             categorie) {
            int numPrestiti = 0;
            for (Prestito p:
                 prestiti) {
                for (Libro l:
                     p.getLibri()) {
                    for (Categoria c2:
                         l.getCategorie()) {
                        if(c2.equals(c)){
                            numPrestiti++;
                        }
                    }
                }
            }
            System.out.printf("La categoria %s è stata presa %d volte \n", c.getTitolo(), numPrestiti);
        }
    }





}
