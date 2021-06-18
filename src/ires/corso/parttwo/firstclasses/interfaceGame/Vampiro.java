package ires.corso.parttwo.firstclasses.interfaceGame;

public class Vampiro
        implements Mostro{

    private int forza;

    public Vampiro(){
        forza = 15;
    }

    public int getForza() {
        return forza;
    }

    public void setForza(int forza) {
        this.forza = forza;
    }

    public void azzanna(){
        forza = forza - 2;
    }

    @Override
    public String msgForza() {
        return "La forza rimanente al vampiro è : " + getForza();
    }
}
