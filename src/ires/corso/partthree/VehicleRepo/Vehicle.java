package ires.corso.partthree.VehicleRepo;

import java.io.Serializable;

public class Vehicle implements Serializable {
    private String licencePlate;

    public Vehicle(String licencePlate){
        this.licencePlate = licencePlate;
    }

    public String getPlate() {
        return licencePlate;
    }

    public void setPlate(String licencePlate) {
        this.licencePlate = licencePlate;
    }

    public String prettyPrint(){
        return String.format("Sono un %s con targa %s\n", this.getClass(), this.getPlate());
    }
}
