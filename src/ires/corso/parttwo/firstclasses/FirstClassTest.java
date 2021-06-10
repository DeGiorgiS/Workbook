package ires.corso.parttwo.firstclasses;

public class FirstClassTest {
    // Create 2 classi a vostro piacimento, ispirandovi agli oggetti che + vi piacciono.
    //
    // Includete:
    // - almeno un campo int/long
    // - almeno un campo Stringa
    // - almeno un campo boolean
    //
    // TUTTE le variabili devono essere "private"!
    //
    // Aggiungete:
    // - getter e setter per tutti i campi
    // - un costruttore diverso da quello di default che accetta almeno 2 argomenti e li imposta come valore dei campi
    // - un metodo "prettyPrint" che stampa in console le caratteristiche dell'istanza
    //
    // Fate un test creando almeno un'istanza di ciascuna classe

    public static void main(String[] args){
        //istanzio prima classe
        Pen penna = new Pen(100, "Rossa");
        Pen penna2 = new Pen(50, "Blu", true);
        System.out.println("Dati iniziali penna (100, Rossa), dati iniziali penna2 (50, Blu, true)");

        //test getter
        int car = penna.getCharges();
        String col = penna.getColor();
        boolean rot = penna.getIsBroken();
        System.out.println("test: cariche " + car + " colore " + col + " rotta " + rot);

        //test setter
        penna.setCharges(80);
        penna.setColor("Nera");
        penna.setIsBroken(true);
        System.out.printf("test: cariche %d, colore %s, rotta %b\n", penna.getCharges(), penna.getColor(), penna.getIsBroken());

        // test prettyPrint
        penna.prettyPrint();
        System.out.println("test della seconda penna istanziata");
        penna2.prettyPrint();

        System.out.printf("\n\n");
        //istanzio seconda classe
        Speaker sp1 = new Speaker(100, "Stereo");
        Speaker sp2 = new Speaker(20, "Dolby", false);
        System.out.println("Dati iniziali sp1 (100, Stereo); dati iniziali sp2 (20, Dolby, false)");

        //test getter
        int v = sp2.getVolume();
        String t = sp2.getType();
        boolean o = sp2.getIsOn();
        System.out.printf("test: volume %d, tipo %s, acceso %b\n", v, t, o);

        //test setter
        sp2.setVolume(70);
        sp2.setType("Mono");
        sp2.setIsOn(true);
        System.out.printf("test: volume %d, tipo %s, acceso %b\n", sp2.getVolume(), sp2.getType(), sp2.getIsOn());

        //test prettyPrint
        sp2.prettyPrint();
    }
}
