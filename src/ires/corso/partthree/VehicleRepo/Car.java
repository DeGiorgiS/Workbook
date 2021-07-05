package ires.corso.partthree.VehicleRepo;

public class Car extends Vehicle{

    private Integer seats;

    public Car(String licencePlate, Integer seats){
        super(licencePlate);
        this.seats = seats;
    }

    public Integer getSeats() {
        return seats;
    }

    public void setSeats(Integer seats) {
        this.seats = seats;
    }
}
