package ires.corso.partthree.VehicleRepo;

public class Truck extends Vehicle{

    private Double cargoSpace;

    public Truck(String licencePlate, Double cargoSpace){
        super(licencePlate);
        this.cargoSpace = cargoSpace;
    }

    public Double getCargoSpace() {
        return cargoSpace;
    }

    public void setCargoSpace(Double cargoSpace) {
        this.cargoSpace = cargoSpace;
    }
}
