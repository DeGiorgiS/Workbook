package ires.corso.test;

import java.io.Serializable;
import java.time.LocalDate;

public class Libro implements Serializable {

    protected enum Genere{
        HORROR,
        FANTASY,
        FANTASCIENZA,
        SAGGIO
    }

    protected enum GiudizioPersonale{
        BRUTTO,
        DECENTE,
        BELLO,
        MAGNIFICO,
        CAPOLAVORO
    }

    private String titolo;
    private String autore;
    private String sinossi;
    private String isbn;
    private LocalDate dataPubblicazione;
    private Genere genere;
    private GiudizioPersonale giudizio;
    private int avanzamentoLettura;
    private boolean lettoTutto;

    public Libro(String titolo, String autore, String sinossi, String isbn, LocalDate dataPubblicazione, Genere genere){
        this.titolo = titolo.toUpperCase();
        this.autore = autore;
        this.sinossi = sinossi;
        this.isbn = isbn;
        this.dataPubblicazione = dataPubblicazione;
        this.genere = genere;
        avanzamentoLettura = 0;
        lettoTutto = false;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo.toUpperCase();
    }

    public String getAutore() {
        return autore;
    }

    public void setAutore(String autore) {
        this.autore = autore;
    }

    public String getSinossi() {
        return sinossi;
    }

    public void setSinossi(String sinossi) {
        this.sinossi = sinossi;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) throws Exception{
        if(isbn.length() == 10){
            this.isbn = isbn;
        }
        else
            throw new Exception("Il codice ISBN deve essere lungo 10 caratteri");
    }

    public LocalDate getDataPubblicazione() {
        return dataPubblicazione;
    }

    public void setDataPubblicazione(LocalDate dataPubblicazione) {
        this.dataPubblicazione = dataPubblicazione;
    }

    public Genere getGenere() {
        return genere;
    }

    public void setGenere(Genere genere) {
        this.genere = genere;
    }

    public GiudizioPersonale getGiudizio() {
        return giudizio;
    }

    public void setGiudizio(GiudizioPersonale giudizio) {
        this.giudizio = giudizio;
    }

    public int getAvanzamentoLettura() {
        return avanzamentoLettura;
    }

    public void setAvanzamentoLettura(int avanzamentoLettura) {
        if(!lettoTutto) {
            if (avanzamentoLettura > 0 && avanzamentoLettura < 100) {
                this.avanzamentoLettura = avanzamentoLettura;
            } else if (avanzamentoLettura == 100) {
                this.avanzamentoLettura = avanzamentoLettura;
                setLettoTutto();
                System.out.println("Hai finito di leggere questo libro, complimenti!");
            } else
                System.out.println("L'AVANZAMENTO DEVE RESTARE TRA 0 E 100");
        }
        else
            System.out.println("IL LIBRO è GIà STATO FINITO, NON PUOI CAMBIARE QUESTO VALORE");
    }

    public boolean isLettoTutto() {
        return lettoTutto;
    }

    public void setLettoTutto() {
        this.lettoTutto = true;
    }

    public String prettyPrint(){
        String result = String.format("Sono un libro di genere %s, ho titolo %s e autore %s, in breve racconto di %s, ho ISBN %s," +
                " sono stato pubblicato nel %s. Sono arrivato al %d per cento di lettura.", this.getGenere().toString(),
                this.getTitolo(), this.getAutore(), this.getSinossi(), this.getIsbn(), this.getDataPubblicazione().toString(),
                this.getAvanzamentoLettura());
        if(giudizio != null)
            result = result + String.format("Ritengo il libro sia %s.", this.getGiudizio().toString());

        return result;
    }
}
