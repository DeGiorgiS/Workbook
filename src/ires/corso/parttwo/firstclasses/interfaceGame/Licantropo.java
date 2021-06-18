package ires.corso.parttwo.firstclasses.interfaceGame;

import java.sql.SQLOutput;

public class Licantropo
        implements Umano, Mostro{

    private boolean siaUomo;
    private int forza;

    public Licantropo(boolean luna){
        if(luna){
            forza = 15;
            siaUomo = false;
        }
        else{
            forza = 10;
            siaUomo = true;
        }
    }

    public boolean isSiaUomo() {
        return siaUomo;
    }

    public void setSiaUomo(boolean siaUomo) {
        this.siaUomo = siaUomo;
    }

    public int getForza() {
        return forza;
    }

    public void setForza(int forza) {
        this.forza = forza;
    }

    @Override
    public void azzanna() {
        if (!siaUomo){
            forza = forza - 2;
        }
        else{
            System.out.println("Non posso azzannare da umano");
        }
    }

    @Override
    public String msgForza() {
        return "La forza rimanente al licantropo è : " + getForza();
    }

    @Override
    public void combatti() {
        if (siaUomo){
            forza = forza - 3;
        }
        else{
            System.out.println("Non posso combattere da mostro");
        }
    }

    public void trasformazione(boolean luna){
        if (luna == siaUomo){
            siaUomo = !siaUomo;
        }
    }
}
