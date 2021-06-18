package ires.corso.parttwo.firstclasses;

import ires.corso.parttwo.firstclasses.interfaceGame.*;

public class InterfaceTest {

    public static void main(String[] args){

        //Personaggio che può essere umano o mostro
        //classi: Eroe, Vampiro, Licantropo

        Eroe e = new Eroe();
        Vampiro v = new Vampiro();
        Licantropo l = new Licantropo(true);

        for(int i = 0; i < 3; i++) {
            e.combatti();
        }
        v.azzanna();
        for(int i = 0; i < 2; i++) {
            if(l.isSiaUomo()){
                l.combatti();
            }
            else{
                l.azzanna();
            }
        }

        System.out.println(e.msgForza());
        System.out.println(v.msgForza());
        System.out.println(l.msgForza());
    }
}
