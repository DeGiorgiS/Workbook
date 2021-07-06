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

    @Override
    public String prettyPrint(){
        String result = super.prettyPrint() + String.format(" e %f kg di capacità di carico \n", this.getCargoSpace());
        return result;
    }
}
