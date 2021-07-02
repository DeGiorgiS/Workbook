package ires.corso.partthree;

import java.util.ArrayList;
import java.util.Arrays;

public class LambdaNameList {

    /*
    // 1. Data una lista di nomi:
    //    - Agnese Stefano, Niki, Veronica, GabrieleM, Davide, GabrieleG, Alessandor, Albnerto, Fabiola, Alessio, Daniele
    //    - ...partire con un ArrayList che li contiene;
    //    - trasformarlo in stream
    //    - filtrare (escludendoli) i nomi che hanno lunghezza < 5 lettere
    //    - trasformare con UPPERCASE i rimanenti
    //    - stamparli su schermo
    //    ...concatenando il più possibile le varie operazioni
     */
    public static void main (String[] args){

        ArrayList<String> nameList = new ArrayList<String>(
                Arrays.asList("Agnese", "Stefano", "Niki", "Veronica", "GabrieleM", "Davide", "GabrieleG", "Alessandro",
                        "Alberto", "Fabiola", "Alessio", "Daniele"));


        nameList.stream().filter(s -> s.length()<= 5).map(s -> s.toUpperCase()).forEach(System.out::println);

        //o ancora più "tirato"
        System.out.println();
        System.out.println("versione con TUTTO in una sola riga");
        new ArrayList<String>(
                Arrays.asList("Agnese", "Stefano", "Niki", "Veronica", "GabrieleM", "Davide", "GabrieleG", "Alessandro",
                        "Alberto", "Fabiola", "Alessio", "Daniele")).stream().filter(s -> s.length()<= 5).map(s -> s.toUpperCase()).forEach(System.out::println);
    }
}
