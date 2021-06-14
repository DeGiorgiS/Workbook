package ires.corso.parttwo.firstclasses.geometric;

public class MasterShape {

    //calcolo dell'area, overridato dalle varie classi figlie
    public double computeArea(){
        return 0;
    }

    //calcolo del perimetro, overridato dalle varie classi figlie
    public double computePerimeter(){
        return 0;
    }

    //nome della forma geometrica, overridato dalle varie classi figlie
    public String getShape(){
        return null;
    }
}
