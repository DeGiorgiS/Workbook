package ires.corso.parttwo.firstclasses.biblioteca;

public class Utente {
    //Utente (nome, cognome, id)

    private final String nome;
    private final String cognome;
    private static int countID;
    private final String ID;

    public Utente(String nome, String cognome) {
        this.nome = nome;
        this.cognome = cognome;
        this.ID = "ID" + countID;
        countID ++;
    }
}
