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

    @Override
    public String prettyPrint(){
        String result;
        if(isStreetLegal){
            result = super.prettyPrint() + String.format(" e posso essere guidata in strada \n");
        }
        else
            result = super.prettyPrint() + String.format(" e non posso essere guidata in strada \n");

        return result;
    }
}
