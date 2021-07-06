package ires.corso.partthree.VehicleRepo;

import ires.corso.partthree.VehicleRepo.*;

import java.util.ArrayList;
import java.util.List;

public class VehicleList {

    private VehicleList(){}

    private static List<Vehicle> vList;

    private static void listGetter() {
        VehicleRepository repo = null;
        try {
            repo = VehicleRepository.getRepo();
        }
        catch (Exception e){
            VehicleRepoTester.printer("Eccezione in listGetter() di VehicleList");
        }
        vList = repo.getVehicleList();
    }

    public static void printCarList(){
        List<Car> list = getCarList();
        list.forEach(c -> VehicleRepoTester.printer(c.prettyPrint() + "\n"));
    }

    //filtro la lista per cosa sia una Car, faccio il cast alla classe Car e poi la aggiungo alla lista (fatto con lambda)
    private static List<Car> getCarList(){
        List<Car> carList = new ArrayList<>();
        listGetter();

        vList.stream().filter(v -> v instanceof Car).map(i -> (Car) i).forEach(c -> carList.add(c));

        return carList;
    }

    public static void printTruckList(){
        List<Truck> list = getTruckList();
        list.forEach(t -> VehicleRepoTester.printer(t.prettyPrint() + "\n"));
    }

    //filtro la lista per cosa sia un Truck, faccio il cast alla classe Truck e poi la aggiungo alla lista (fatto con ciclo for)
    public static List<Truck> getTruckList(){
        List<Truck> truckList = new ArrayList<>();
        listGetter();

        for (Vehicle v:
                vList) {
            if(v instanceof Truck){
                truckList.add((Truck) v);
            }
        }

        return truckList;
    }

    public static void printMotorbikeList(){
        List<Motorbike> list = getMotorbikeList();
        list.forEach(m -> VehicleRepoTester.printer(m.prettyPrint() + "\n"));
    }

    //filtro la lista per cosa sia una Motorbike, faccio il cast alla classe Motorbike e poi la aggiungo alla lista (fatto con lambda)
    public static List<Motorbike> getMotorbikeList(){
        List<Motorbike> motorbikeList = new ArrayList<>();
        listGetter();

        vList.stream().filter(v -> v instanceof Motorbike).map(i -> (Motorbike) i)
                .forEach(c -> motorbikeList.add(c));

        return motorbikeList;
    }

    public static void printVehicleList(){
        List<Vehicle> list = getVehicleList();
        list.forEach(v -> VehicleRepoTester.printer(v.prettyPrint() + "\n"));
    }

    //creo una List dai valori della mappa "completa"
    public static List<Vehicle> getVehicleList(){
        List<Vehicle> vehicleList = new ArrayList<>();
        listGetter();
        vehicleList.addAll(vList);
        return vehicleList;
    }
}
