package ires.corso.parttwo.firstclasses.biblioteca;

import java.time.LocalDate;
import java.util.List;

public class Libro {

    //Libro (autore, data pubblicazione, num. pagine, num. volumi, num. capitoli)
    private final String titolo;
    private final String autore;
    private final LocalDate dataPubblicazione;
    private final Integer pagine;
    private Integer numVolumi;
    private final Integer numCapitoli;
    private List<Categoria> categorie;

    public Libro(String titolo, String autore, LocalDate dataPubblicazione, Integer pagine, Integer numVolumi,
                 Integer numCapitoli, List<Categoria> categorie) {
        this.titolo = titolo;
        this.autore = autore;
        this.dataPubblicazione = dataPubblicazione;
        this.pagine = pagine;
        this.numVolumi = numVolumi;
        this.numCapitoli = numCapitoli;
        this.categorie = categorie;
    }

    public Libro(String titolo, String autore, LocalDate dataPubblicazione, Integer pagine, Integer numVolumi,
                 Integer numCapitoli) {
        this.titolo = titolo;
        this.autore = autore;
        this.dataPubblicazione = dataPubblicazione;
        this.pagine = pagine;
        this.numVolumi = numVolumi;
        this.numCapitoli = numCapitoli;
    }

    public String getAutore() {
        return autore;
    }

    public LocalDate getDataPubblicazione() {
        return dataPubblicazione;
    }

    public Integer getPagine() {
        return pagine;
    }

    public Integer getNumVolumi() {
        return numVolumi;
    }

    public Integer getNumCapitoli() {
        return numCapitoli;
    }

    public List<Categoria> getCategorie(){
        return categorie;
    }

    public void setCategorie(List<Categoria> categorie){
        this.categorie = categorie;
    }
}
