package ires.corso.partone.geometic;

import java.util.Scanner;

public class Quadrato {

    public static double paramethers(){
        Scanner in = new Scanner(System.in);
        System.out.println("Inserire la base");
        return in.nextDouble();
    }

    //Area quadrato: l*l
    public static double computeArea(double param){
        return param * param;
    }
}
// sarebbe più elegante usare una forma tipo Dictionary rispetto agli array, per chiarezza

