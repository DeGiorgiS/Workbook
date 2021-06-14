package ires.corso.parttwo.firstclasses.geometric;

public class Quadrato extends MasterShape{

    //info di base
    private int l; //lato
    private String shape = "quadrato"; //tipo di forma geometrica

    public Quadrato(int l){
        this.l = l;
    }

    @Override
    public double computeArea(){
        return l*l;
    }

    @Override
    public double computePerimeter(){
        return l*4;
    }

   @Override
   public String getShape(){
        return shape;
   }

   //getter + setter
   public int getLato(){
        return l;
   }

   public void setLato(int l){
        this.l = l;
   }
}
