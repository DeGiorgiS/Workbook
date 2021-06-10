package ires.corso.parttwo.firstclasses;

public class Pen {

    private int charges; //carica residua, max 100 (sarebbe da controllare che sia positivo e <100, ma per ora salto)
    private String color; //colore (sarebbe da controllare colore con enum o simile, ma per ora salto)
    private boolean isBroken = false; //se è rotta

    //costruttore con 2 argomenti
    public Pen (int charges, String color){
        this.charges = charges;
        this.color = color;
        isBroken = false;
    }

    //costruttore con 3 argomenti
    public Pen (int charges, String color, boolean isBroken){
        this.charges = charges;
        this.color = color;
        this.isBroken = isBroken;
    }

    //getter e setter

    public int getCharges() {
        return charges;
    }

    public void setCharges(int charges){
        if(charges >= 0 && charges <= 100){
            this.charges = charges;
        }
        else{
            System.out.println("Inserisci un numero tra 0 e 100 di carica residua");
        }
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean getIsBroken(){
        return isBroken;
    }

    public void setIsBroken(boolean isBroken){
        this.isBroken = isBroken;
    }

    //metodo "prettyPrint" che stampa in console le caratteristiche dell'istanza
    public void prettyPrint(){
        if(isBroken == false)
            System.out.printf("Sono una penna %s con %d cariche residue su 100 e non sono rotta\n", color, charges);
        else System.out.printf("Sono una penna %s con %d cariche residue su 100 e sono rotta\n", color, charges);
    }
}
