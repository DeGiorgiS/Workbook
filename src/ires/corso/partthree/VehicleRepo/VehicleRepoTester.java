package ires.corso.partthree.VehicleRepo;

import java.util.Scanner;

public class VehicleRepoTester {

    public static void main(String[] args){
        //inizializzo e lo salvo istanzio nel main
        VehicleRepository.initialization("VehicleRepo.ser");
        VehicleRepository repo = null;
        try {
            repo = VehicleRepository.getRepo();
        }
        catch(Exception ex){
            System.out.println("Eccezione nel RECUPERO del repo");
        }

        if (repo != null) {
            //mio metodo di test che riempie la lista con elementi preimpostati
            repo.vehicleListSetter();

            //test metodi di lista per sotto-classe
            System.out.println(repo.getCarList().toString());
            System.out.println(repo.getTruckList().toString());
            System.out.println(repo.getMotorbikeList().toString());

            //test metodo per lista completa di Vehicle
            System.out.println(repo.getVehicleList().toString());

            //test aggiunta veicolo da console
            vehicleBuilder(repo);

            //todo ancora da mettere -> test per REMOVE, UPDATE, SERIALIZZAZIONE
        }
        else
            System.out.println("IL REPO HA PUNTATORE NULLO, CONTROLLA PERCHé!");
    }

    public static void vehicleBuilder(VehicleRepository repo){
        System.out.println("Vuoi costruire una CAR, TRUCK o MOTORBIKE?");
        Scanner in = new Scanner(System.in);
        String answer = in.nextLine();

        if(answer.equalsIgnoreCase("car")){
            System.out.println("Inserisci la targa: ");
            String licencePlate = in.nextLine();
            System.out.println("Inserisci il numero di posti: ");
            Integer seats = in.nextInt();

            Car c = new Car(licencePlate, seats);
            repo.add(c);
            System.out.printf("Ho creato una CAR con targa %s e numero di posti %d e l'ho aggiunta al repo\n", licencePlate, seats);

        } else if(answer.equalsIgnoreCase("truck")){
            System.out.println("Inserisci la targa: ");
            String licencePlate = in.nextLine();
            System.out.println("Inserisci la portata di carico: ");
            Double cargoSpace = in.nextDouble();

            Truck t = new Truck(licencePlate, cargoSpace);
            repo.add(t);
            System.out.printf("Ho creato un TRUCK con targa %s e capacità di carico %d e l'ho aggiunta al repo\n", licencePlate, cargoSpace);

        } else if(answer.equalsIgnoreCase("motorbike")) {
            System.out.println("Inserisci la targa: ");
            String licencePlate = in.nextLine();
            System.out.println("Indica se è possibile guidarla in strada: ");
            boolean streetLegal = in.nextBoolean();

            Motorbike m = new Motorbike(licencePlate, streetLegal);
            repo.add(m);
            System.out.printf("Ho creato una MOTORBIKE con targa %s e legalità di guida in strada %b e l'ho aggiunta al repo\n", licencePlate, streetLegal);

        } else{
            System.out.println("RICHIESTA NON VALIDA, non ho costruito nulla");
        }
    }
}
