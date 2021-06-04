package ires.corso.partone;

import java.util.Scanner;

public class InputTest {

    public static void main(String[] args){
        Scanner in;
        in = new Scanner(System.in);

        // chiedo inserimento di 3 numeri
        int[] numeri = new int[3];
        System.out.println("Inserisci un primo numero intero");
        numeri[0] = in.nextInt();
        System.out.println("Inserisci un secondo numero intero");
        numeri[1] = in.nextInt();
        System.out.println("Inserisci un terzo numero intero");
        numeri[2] = in.nextInt();
        System.out.println("Hai inserito: " + numeri[0] + "; " + numeri[1] + "; " + numeri[2]);

        // confronto di 3 numeri per trovarne il maggiore, stapandone anche la posizione
        int magg;
        String posizione;

        if(numeri[1]>=numeri[2]){
            magg = numeri[1];
            posizione = "SECONDA";
        }
        else{
            magg = numeri[2];
            posizione = "TERZA";
        }

        if (numeri[0]>=magg){
            magg = numeri[0];
            posizione = "PRIMA";
        }

        System.out.println("Il numero maggiore è: " + magg+ " ed occupa la "+ posizione + " posizione");
    }
}
