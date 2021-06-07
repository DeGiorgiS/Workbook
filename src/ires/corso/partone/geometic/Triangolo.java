package ires.corso.partone.geometic;

import java.util.Scanner;

public class Triangolo {

    public static double[] paramethers(){
        Scanner in = new Scanner(System.in);
        double[] param = new double[2];
        System.out.println("Inserire in sequenza: base ed altezza");
        for(int i=0; i<2; i++){
            param[i] = in.nextDouble();
        }
        return param;
    }

    //Area triangolo: B*h/2
    public static double computeArea(double[] param){
        double base = param[0];
        double height = param[1];
        return base * height / 2;
    }
}
// sarebbe più elegante usare una forma tipo Dictionary rispetto agli array, per chiarezza

