package ires.corso.partone;

import java.util.Scanner;

public class ArrayTest {

    public static void main(String[] args) {
        System.out.println("Inserisci un array (numeri separati da |, esempio 1|2|3|...");
        System.out.print("==>");
        Scanner in = new Scanner(System.in);
        String nl = in.nextLine();
        String[] strArr = nl.split("\\|");

        int[] intArr = new int[strArr.length];

        for(int j = 0; j < strArr.length; j++){
            System.out.printf("Elemento %d-esimo dell'array ==> %s\n", j + 1, strArr[j]);
            intArr[j] = Integer.parseInt(strArr[j]);
        }

        System.out.print("Dimmi l'elemento da cercare: ");
        int j = in.nextInt();
        int p = elemPositionInArray(intArr, j);
        System.out.printf("L'elemento si trova in posizione %d\n", p);

        System.out.print("L'array senza duplicati è: ");
        int[] arrayDaStampare = removeDuplicates(intArr);
        for(int i = 0; i < arrayDaStampare.length; i++){
            System.out.print(arrayDaStampare[i] + "|");
        }
    }

    /*
    Scrivere un metodo java che accetta in ingresso un array di int e un numero,
    restituendo posizione di quel numero nell'array o -1 se il numero non è presente nell'array.

    Esempio:
    - se intArray == {1,2,3,4} ==>  elemPositionInArray(intArray, 3) == 2
    - se intArray == {1,2,3,4} ==>  elemPositionInArray(intArray, 7) == -1
     */

    public static int elemPositionInArray(int[] intArray, int elem){
        int result = -1;

        int i;
        for (i = 0; i < intArray.length; i++){
            if(intArray[i] == elem){
                result = i + 1; //indice di array parte da 0
                break;
            }
        }

        /*
        alternativa con Do-While

        int i = 0;
        do{
            if(intArray[i] == elem){
                result = i + 1; //indice di array parte da 0
                break;
            }
            i++;
        }while(i < intArray.length);
        */
        return result;
    }


    /*
   Scrivere un metodo java che accetta in ingresso un array di int e costriuisce una copia che non contiene gli
   eventuali elementi duplicati.

   Esempio:
   - se intArray == {1,2,2,3,3,4} ==>  removeDuplicates(intArray) == {1,2,3,4}
   - se intArray == {1,2,3,4} ==>  removeDuplicates(intArray) == {1,2,3,4}
    */
    public static int[] removeDuplicates(int[] arrayWithDuplicates) {
        int numDuplicati = 0;
        boolean[] isDuplicate = new boolean[arrayWithDuplicates.length]; // è inizializzato a false per tutto

        //cerco il numero di duplicati
        for(int i = 0; i < arrayWithDuplicates.length; i++){
            for(int j = 0; j != i; j++){
                if(arrayWithDuplicates[j]==arrayWithDuplicates[i]){
                    isDuplicate[i] = true;
                    numDuplicati++;
                }
            }
        }

        //creo l'array risultato con tante posizioni quanti i numeri univoci
        int[] arrayWithoutDuplicates = new int[arrayWithDuplicates.length - numDuplicati];
        int z = 0; //indice ultimo elemento messo in array risultato

        for(int i = 0; i < isDuplicate.length; i++){
            if(isDuplicate[i] == false) {
                arrayWithoutDuplicates[z] = arrayWithDuplicates[i];
                z++;
            }
        }

        return arrayWithoutDuplicates;
    }
}
