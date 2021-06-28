package ires.corso.parttwo.firstclasses.biblioteca;

import java.util.List;

public class Prestito {
    //Prestito (Utente, 1 o + Libro)

    private Utente utente;
    private List<Libro> libroPrestiti;

    public Prestito(Utente utente, List<Libro> libroPrestiti) {
        this.utente = utente;
        this.libroPrestiti = libroPrestiti;
    }

    public List<Libro> getLibri(){
        return libroPrestiti;
    }
}


