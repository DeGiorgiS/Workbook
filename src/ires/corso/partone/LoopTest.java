package ires.corso.partone;

import java.util.Scanner;

public class LoopTest {

    public static void main(String[] args){
        loopTestThree();
    }

    public static void loopTestOne(){
        int i, j, n;
        int incr = 1;

        System.out.println("Inserisci il numero di righe: ");
        Scanner in = new Scanner(System.in);
        n = in.nextInt();

        for(i = 1; i <= n; i++) {
            for(j = 1; j <= i; j++) {
                System.out.print(incr + " ");
                incr++;
            }
            System.out.println("");
        }
    }

    public static void loopTestTwo(){
        int i, j, d;

        d = 7; //lunghezza della riga di mezzo

        //loop originario per stampa di diamante di stelle
        for(i = 1; i <= d; i++) {
            //stampo spazi
            int numSpaces = d - i;
            for(j = 1; j <= numSpaces; j++) {
                System.out.print(" ");
            }

            //stampo stelle
            int numStars = (2 * i) - 1;
            for(j = 1; j <= numStars; j++) {
                System.out.print("*");
            }
            System.out.println("");
        }

        for(i = d - 1; i >= 1; i--) {
            //stampo spazi
            int numSpaces = d - i;
            for(j = 1; j <= numSpaces; j++) {
                System.out.print(" ");
            }

            //stampo stelle
            int numStars = (2 * i) - 1;
            for(j = 1; j <= numStars; j++) {
                System.out.print("*");
            }
            System.out.println("");
        }

        System.out.println("------------------");
        //in alternativa, mettendo in evidenza la stampa
        for(i = 1; i <= d; i++) {

            int numSpaces = d - i;
            int numChars = (2 * i) - 1;
            printDiamondStars(numSpaces, numChars);

        }

        for(i = d - 1; i >= 1; i--) {
            int numSpaces = d - i;
            int numChars = (2 * i) - 1;
            printDiamondStars(numSpaces, numChars);

        }


        System.out.println("--------------");
        //alternativa, mettendo in evidenza input e definizione spazi/stelle
        for(i = 1; i <= d; i ++) computeAndPrintDiamondLine(i,d);
        for(i = d - 1; i >= 1; i--) computeAndPrintDiamondLine(i,d);

    }

    public static void printDiamondStars(int spaces, int stars){
        int j;
        for(j = 1; j <= spaces; j++) System.out.print(" ");
        for(j = 1; j <= stars; j++) System.out.print("*");
        System.out.println("");
    }

    public static void computeAndPrintDiamondLine(int lineIndex, int diamondSize){
        int numSpaces = diamondSize - lineIndex;
        int numStars = (2*lineIndex) - 1;
        printDiamondStars(numSpaces, numStars);
    }

    /*
        VARIAZIONE: per d = 7

              1
             212
            32123
           4321234
          543212345
         65432123456
        7654321234567
         65432123456
          543212345
           4321234
            32123
             212
              1
     */
    public static void loopTestThree(){
        int i, d, j;

        //d sarà dato in Input
        d = 7;

        // metodo più brutale
        for(i = 1; i <= d; i++) {
            //stampo spazi
            int numSpaces = d - i;
            for(j = 1; j <= numSpaces; j++) {
                System.out.print(" ");
            }
            //stampo numeri
            for(j = i; j > 1; j--) {
                System.out.print(j);
            }
            for(j = 1; j <= i; j++) {
                System.out.print(j);
            }
            System.out.println("");
        }
        for(i = d - 1; i >= 1; i--) {
            //stampo spazi
            int numSpaces = d - i;
            for(j = 1; j <= numSpaces; j++) {
                System.out.print(" ");
            }

            //stampo numeri
            for(j = i; j > 1; j--) {
                System.out.print(j);
            }
            for(j = 1; j <= i; j++) {
                System.out.print(j);
            }
            System.out.println("");
        }


        System.out.println("------------------------");
        //alternativa istanziando il print
        for(i = 1; i <= d; i++) {
            int numSpaces = d - i;
            printDiamondNumbers(numSpaces, i);
        }
        for(i = d - 1; i >= 1; i--) {
            int numSpaces = d - i;
            printDiamondNumbers(numSpaces, i);
        }


        System.out.println("------------------------");
        //alternativa istanziando print e parametri
        for(i = 1; i <= d; i++) {
            computeAndPrintDiamondNumbers(i, d);
        }
        for(i = d - 1; i >= 1; i--){
            computeAndPrintDiamondNumbers(i, d);
        }
    }

    public static void printDiamondNumbers(int spaces, int num){
        //argomenti: spaces-> numero di spazi; num -> numero + alto da stampare nella riga

        int j;
        //stampa spazi
        for(j = 1; j <= spaces; j++) {
            System.out.print(" ");
        }
        //stampa numeri
        for(j = num; j > 1; j--) {
            System.out.print(j);
        }
        for(j = 1; j <= num; j++) {
            System.out.print(j);
        }
        System.out.println("");

    }

    public static void computeAndPrintDiamondNumbers(int row, int maxNumber){
        int numSpaces = maxNumber - row;
        printDiamondNumbers(numSpaces, row);
    }
}
