package ires.corso.parttwo.firstclasses.interfaceGame;

public class Eroe
        implements Umano{

    private int forza;

    public Eroe(){
        forza = 10;
    }

    public int getForza() {
        return forza;
    }

    public void setForza(int forza) {
        this.forza = forza;
    }

    public void combatti(){
        forza = forza - 3;
    }

    @Override
    public String msgForza() {
        return "La forza residua all'eroe è : " + getForza();
    }
}
