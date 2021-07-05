package ires.corso.partthree.VehicleRepo;

public class Motorbike extends Vehicle{

    private boolean isStreetLegal;

    public Motorbike(String licencePlate, boolean isStreetLegal){
        super(licencePlate);
        this.isStreetLegal = isStreetLegal;
    }

    public boolean isStreetLegal() {
        return isStreetLegal;
    }

    public void setStreetLegal(boolean streetLegal) {
        isStreetLegal = streetLegal;
    }
}
