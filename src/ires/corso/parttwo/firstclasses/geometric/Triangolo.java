package ires.corso.parttwo.firstclasses.geometric;

import java.util.Scanner;

public class Triangolo extends MasterShape{

    //dati di base
    private int h; //altezza
    private int b; //base
    private String shape = "triangolo"; //tipo di forma geometrica

    public Triangolo(int h, int b){
        this.h = h;
        this.b = b;
    }

    @Override
    public double computeArea(){
        return (b*h)/2;
    }

    @Override
    public double computePerimeter(){
        System.out.println("Che tipo di triangolo vuoi? (equilatero, isoscele, rettangolo, scaleno) -CASE SENSITIVE!!-");
        Scanner in = new Scanner(System.in);
        String tipo = in.nextLine();

        //valori inizializzati per intercettare errori "alla meglio" (lati non possono essere negativi)
        int base = -1;
        double lOne = -1;
        double lTwo = -1;

        if(tipo == "equilatero")
        {
            base = b;
            lOne = b;
            lTwo = b;
            this.shape = "triangolo equilatero";
        }
        else if(tipo == "rettangolo")
        {
            base = b;
            lOne = h;
            lTwo = Math.sqrt(h^2 + b^2);
            this.shape = "triangolo rettangolo";
        }
        else if(tipo == "isoscele")
        {
            base = b;
            lOne = Math.sqrt(h^2 + (b/2)^2);
            lTwo = lOne;
            this.shape = "triangolo isoscele";
        }
        else if(tipo == "scaleno")
        {
            System.out.println("Ho bisogno delle informazioni sui lati obliqui, inserisci rispettivamente il primo " +
                    "e poi il secondo");
            base = b;
            System.out.println("lato uno: ");
            lOne = in.nextInt();
            System.out.println("lato due: ");
            lTwo = in.nextInt();
            this.shape = "triangolo scaleno";
        }
        else{
            System.out.println("Tipo di triangolo non riconosciuto. ERRORE");
        }

        return base + lOne + lTwo;
    }

    @Override
    public String getShape(){
        return shape;
    }

    //getter + setter
    public int getHeight(){
        return h;
    }

    public int getBase(){
        return b;
    }

    public void setHeight(int h){
        this.h = h;
    }

    public void setBase(int b){
        this.b = b;
    }
}
