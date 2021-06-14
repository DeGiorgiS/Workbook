package ires.corso.parttwo.firstclasses.geometric;

import java.util.Scanner;

public class Trapezio extends MasterShape{

    //info di base
    private int h; //altezza
    private int bmaj; //base maggiore
    private int bmin; //base minore
    private String shape = "trapezio"; //tipo di forma geometrica

    public Trapezio(int h, int bmaj, int bmin){
        this.h = h;
        this.bmaj = bmaj;
        this.bmin = bmin;
    }

    @Override
    public double computeArea(){
        return (bmaj + bmin) * h / 2;
    }

    @Override
    public double computePerimeter(){
        System.out.println("Che tipo di trapezio vuoi? (rettangolo, isoscele, scaleno) -CASE SENSITIVE!!-");
        Scanner in = new Scanner(System.in);
        String tipo = in.nextLine();

        //valori inizializzati per intercettare errori "alla meglio" (lati non possono essere negativi)
        int bOne = -1;
        int bTwo = -1;
        double lOne = -1;
        double lTwo = -1;

        if(tipo == "rettangolo"){
            bOne = bmaj;
            bTwo = bmin;
            lOne = h;
            lTwo = Math.sqrt(h^2 + (bmaj-bmin)^2);
            this.shape = "trapezio rettangolo";
        }
        else if(tipo == "isoscele"){
            bOne = bmaj;
            bTwo = bmin;
            lOne = Math.sqrt(h^2 + ((bmaj - bmin)/2)^2);
            lTwo = lOne;
            this.shape = "trapezio isoscele";
        }
        else if(tipo == "scaleno"){
            System.out.println("Ho bisogno delle informazioni sui lati obliqui, inserisci rispettivamente il primo " +
                    "e poi il secondo");
            bOne = bmaj;
            bTwo = bmin;
            System.out.println("lato uno: ");
            lOne = in.nextInt();
            System.out.println("lato due: ");
            lTwo = in.nextInt();
            this.shape = "trapezio scaleno";
        }
        else{
            System.out.println("Tipo di trapezio non riconosciuto. ERRORE");
        }

        return bOne + bTwo + lOne + lTwo;
    }

    @Override
    public String getShape(){
        return shape;
    }

    //getter + setter
    public int getHeight(){
        return h;
    }

    public int getBmaj(){
        return bmaj;
    }

    public int getBmin(){
        return bmin;
    }

    public void setHeight(int h){
        this.h = h;
    }

    public void setBmaj(int b){
        this.bmaj = b;
    }

    public void setBmin(int b){
        this.bmin = b;
    }
}
