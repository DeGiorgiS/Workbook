package ires.corso.partthree;


import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;
import java.util.Scanner;

public class LambdaNumberList {

    /*
    // 2. Fare un programma Java che:
    //    - chiede all'utente una lista di numeri (separati da virgola) <== RIUSATE IL CODICE DEL SORTING GAME
    //    - li trasforma in stream
    //    - filtra i duplicati (HINT: guardate bene i metodi dell'interfaccia Stream...)
    //    - eleva al quadrato i numeri filtrati
    //    - calcola la media
     */

    public static void main(String[] args){
        System.out.println("INSERISCI UNA LISTA DI NUMERI INTERI SEPARATI DA UNA VIRGOLA"); //tralascio controlli input per sta volta

        Scanner in = new Scanner(System.in);
        String inputLine = in.nextLine();
        List<String> inputList = Arrays.asList(inputLine.split(","));

        //metodo .average() ritorna type OptionalDouble
        OptionalDouble result = inputList.stream().mapToInt(s -> Integer.parseInt(s)).distinct().map(i -> i*i).average();
        System.out.println();

        //se la media è calcolabile la stampa, mentre se la variabile del risultato è rimasta nulla stampa un avviso a riguardo
        if(result.isPresent()){
            System.out.println("La media dei loro quadrati, eliminando i doppioni, è : " + result.getAsDouble());
        }
        else
            System.out.println("Non è stato possibile calcolare la media dei loro quadrati, eliminando i doppioni.");

    }
}
