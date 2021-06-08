package ires.corso.partone;

/*
Scrivere un programma Java che esegua le seguenti operazioni:
1. chiede all'utente per che tipo di forma geometrica desidera calcolare l'area
2. le figure da trattare sono: Quadrato, Triangolo, Trapezio
3. per la figura prescelta, chiede i dati necessari al calcolo dell'area
4. calcola l'area utilizzando l'apposita formula
5. stampa il risultato

Utilizzare per le parti di codice speficiche di una figura, 3 classi, implemendando i relativi metodi come Static
Per l'input utilizzare la classe scanner, per discriminare tra le classi da chiamare usate un'istruzione Switch.
 */

import java.util.Scanner;
import ires.corso.partone.geometic.Quadrato;
import ires.corso.partone.geometic.Trapezio;
import ires.corso.partone.geometic.Triangolo;

public class ShapeTest {

    public static void main(String[] args){

        Scanner in = new Scanner(System.in);
        System.out.println("Inserire la forma prescelta (tra Quadrato, Triangolo, Trapezio -case sensitive-)");
        String shape = in.nextLine();

        switch(shape){
            case "Quadrato":
                double aQuad = Quadrato.computeArea(Quadrato.paramethers());
                System.out.println("L'area del quadrato inserito è: " + aQuad);
                break;
            case "Triangolo":
                double aTria = Triangolo.computeArea(Triangolo.paramethers());
                System.out.println("L'area del triangolo inserito è: " + aTria);
                break;
            case "Trapezio":
                double aTrap = Trapezio.computeArea(Trapezio.paramethers());
                System.out.println("L'area del trapezio inserito è: " + aTrap);
                break;
        }

    }
}
