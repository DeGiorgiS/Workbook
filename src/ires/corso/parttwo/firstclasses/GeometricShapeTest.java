package ires.corso.parttwo.firstclasses;

import ires.corso.parttwo.firstclasses.geometric.*;
import java.util.Scanner;

public class GeometricShapeTest {
    /*
    riscrivere il test delle forme geometriche in ottica OOP
    1. creare una classe "MasterShape" che sarà la classe parent
    2. all'interno di MasterShape definire il metodo computeArea e il metodo computePerimeter, che NON devono
    ricevere argomenti in input
    3. usate i costruttori speficici delle classi figlie per richiedere al momento della creazione i parametri che
    servono per fare i calcoli in ciascuna forma geometrica
    4. le classi figlie (Trapezio, Triangolo, Quadrato) devono estendere con "extends" la MasterShape e implementare l'
    override dei metodi computeArea e computePerimeter (nota: aggiungere l'annotation @Override)
    5. creare una classe Tester con il metodo main(String[] args), all'interno del quale devo
    - creare 3 forme geometriche diverse come istanze delle classi figlie
    chiedere i dati in input nel metodo main e salvateli nelle proprietà interne di ciascuna classe
    - creare un array di MasterShape che avrà come elementi le istanze create
    - calcolare le aree e stamparle in un unico loop

    nota: metodi computeArea e computePerimeter della MasterShape avranno "return 0;", tanto poi ci farò l'override.
    */

    public static void main(String[] args) {
        // Costruisco le forme geometriche
        Scanner in = new Scanner(System.in);
        System.out.println("Inserisci i dati del quadrato");
        System.out.print("Lato : ");
        int b = in.nextInt(); //variabile temporanea per chiarire meglio il costruttore
        Quadrato q = new Quadrato(b);

        System.out.println("Inserisci i dati del triangolo");
        System.out.print("Altezza : ");
        int h = in.nextInt(); //variabile temporanea per il costruttore
        System.out.print("Base : ");
        b = in.nextInt(); //variabile temporanea per il costruttore
        Triangolo tria = new Triangolo(h, b);

        System.out.println("Inserisci i dati del trapezio");
        System.out.print("Altezza : ");
        h = in.nextInt(); //variabile temporanea per il costruttore
        System.out.print("Base maggiore: ");
        int bMagg = in.nextInt(); //variabile temporanea per il costruttore
        System.out.print("Base minore: ");
        b = in.nextInt(); //variabile temporanea per il costruttore
        Trapezio trap = new Trapezio(h, bMagg, b);

        //array di MasterShape cone le istanze appena create
        MasterShape[] forme = {q, tria, trap};

        for(int i = 0; i < forme.length; i++){
            System.out.println("Ho calcolato l'area di un " +  forme[i].getShape() + ", che è pari a "
                    + forme[i].computeArea());
        }
        //lasciando i metodi computeArea a "protected" in MasterShape, non riuscivo a generalizzare il loop

        for(int i = 0; i < forme.length; i++){
            System.out.println("Perimetro : " + forme[i].computePerimeter() + " di un " + forme[i].getShape());
        }
        //NON MI PRENDE L'UGUAGLIANZA TRA STRINGHE!! (ma tra numeri si) CHIEDERE INFO A LEZIONE
    }
}
