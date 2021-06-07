package ires.corso.partone.geometic;

import java.util.Scanner;

public class Trapezio {

    public static double[] paramethers(){
        Scanner in = new Scanner(System.in);
        double[] param = new double[3];
        System.out.println("Inserire in sequenza: base maggiore, base minore ed altezza");
        for(int i=0; i<3; i++){
            param[i] = in.nextDouble();
        }
        return param;
    }

    //Area trapezio: (B + b) * h / 2
    public static double computeArea(double[] param){
        double bmaj = param[0];
        double bmin = param[1];
        double height = param[2];
        return (bmaj + bmin) * height / 2;
    }
}
// sarebbe più elegante usare una forma tipo Dictionary rispetto agli array, per chiarezza