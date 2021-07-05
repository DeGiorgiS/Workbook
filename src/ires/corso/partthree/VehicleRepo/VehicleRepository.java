package ires.corso.partthree.VehicleRepo;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class VehicleRepository implements Serializable {

    private static VehicleRepository _repository; //unica istanza del repo
    private static boolean _init = false; //flag se ho già inizializzato il file dove serializzare o meno
    private static String _fileName; //nome del file per la serializzazione

    //costruttore privato per obbligare ad avere una sola istanza del repository possibile
    private VehicleRepository(){}

    //inizializzazione con inserimento del nome del file con cui serializzare il repo
    public static boolean initialization(String fileName){
        if(!_init){
            Path p = Paths.get(fileName);
            _fileName = p.toString();
            _init = true;
        }
        return _init;
    }

    //restituisce l'unica istanza del repository
    public static VehicleRepository getRepo() throws Exception{
        if(!_init){
            throw new Exception("REPO NON ANCORA INIZIALIZZATO!!!");
        }
        if(_repository == null) {
            if(!Files.exists(Paths.get(_fileName)))
                _repository = new VehicleRepository();
            else
                inputFromFile();
        }

        return _repository;
    }

    //CARATTERISTICA DI RESTITUIRE UNA LISTA DI VEICOLI PER "SOTTO-CLASSE"
    private Map<String, Vehicle> vehicleMap= new HashMap<>();  //MAP con K:targa V:oggetto Vehicle

    //riempie la lista di elementi messi "a mano"
    public void vehicleListSetter(){
        Car c1 = new Car("AB123CD", 4);
        Truck t1 = new Truck("QW456ER", 2000d);
        Truck t2 = new Truck("QW489ER", 3000d);
        Motorbike b1 = new Motorbike("AS789DF", true);
        Motorbike b2 = new Motorbike("AS712DF", true);
        Motorbike b3 = new Motorbike("AS745DF", false);
        vehicleMap.put(c1.getPlate(), c1);
        vehicleMap.put(t1.getPlate(), t1);
        vehicleMap.put(t2.getPlate(), t2);
        vehicleMap.put(b1.getPlate(), b1);
        vehicleMap.put(b2.getPlate(), b2);
        vehicleMap.put(b3.getPlate(), b3);
    }

    //filtro la lista per cosa sia una Car, faccio il cast alla classe Car e poi la aggiungo alla lista (fatto con lambda)
    public List<Car> getCarList(){
        List<Car> carList = new ArrayList<>();

        vehicleMap.values().stream().filter(v -> v instanceof Car).map(i -> (Car) i).forEach(c -> carList.add(c));

        return carList;
    }

    //filtro la lista per cosa sia un Truck, faccio il cast alla classe Truck e poi la aggiungo alla lista (fatto con ciclo for)
    public List<Truck> getTruckList(){
        List<Truck> truckList = new ArrayList<>();

        for (Vehicle v:
             vehicleMap.values()) {
            if(v instanceof Truck){
                truckList.add((Truck) v);
            }
        }

        return truckList;
    }

    //filtro la lista per cosa sia una Motorbike, faccio il cast alla classe Motorbike e poi la aggiungo alla lista (fatto con lambda)
    public List<Motorbike> getMotorbikeList(){
        List<Motorbike> motorbikeList = new ArrayList<>();

        vehicleMap.values().stream().filter(v -> v instanceof Motorbike).map(i -> (Motorbike) i)
                .forEach(c -> motorbikeList.add(c));

        return motorbikeList;
    }

    //creo una List dai valori della mappa "completa"
    public List<Vehicle> getVehicleList(){
        List<Vehicle> vehicleList = new ArrayList<>();
        vehicleList.addAll(vehicleMap.values());
        return vehicleList;
    }

    //metodo per aggiungere elementi alla mappa del repo
    public void add(Vehicle v){
        vehicleMap.put(v.getPlate(), v);
    }

    //metodo per rimuovere elementi dalla mappa del repo
    public void remove(Vehicle v){
        vehicleMap.remove(v.getPlate(), v);
    }

    //metodo per "swappare" v1 con v2 nel repo
    public void update(Vehicle v1, Vehicle v2){
        if(v1.getPlate().equals(v2.getPlate())){
            vehicleMap.replace(v1.getPlate(),v1 , v2);
        }
        else
            System.out.println("LE TARGHE NON COMBACIANO!! Swap non possibile.");
    }

    //serializzazione
    public void outputToFile(){
        try(FileOutputStream file = new FileOutputStream(_fileName);
            ObjectOutputStream out = new ObjectOutputStream(file)){
            out.writeObject(this);
            System.out.println("Il repo è stato serializzato");
        }
        catch (IOException ioe){
            System.out.println("IOException in serializzazione");
        }
    }

    //deserializzazione
    public static void inputFromFile(){
        try(FileInputStream file = new FileInputStream(_fileName);
        ObjectInputStream in = new ObjectInputStream(file)){
            _repository = (VehicleRepository) in.readObject();
        }
        catch (IOException ioe){
            System.out.println("IOException in deserializzazione");
        }
        catch (ClassNotFoundException cnfe){
            System.out.println("ClassNotFoundException in deserializzazione");
        }
    }
}
