package ires.corso.partthree.VehicleRepo;

import ires.corso.partthree.VehicleRepo.Menu.MenuBranch;
import ires.corso.partthree.VehicleRepo.Menu.MenuLeaf;

import java.util.Arrays;
import java.util.Scanner;

public class VehicleRepoTester {

    public static void main(String[] args){
        //inizializzo e lo salvo istanzio nel main con deserializzazione se possibile
        VehicleRepository.initialization("VehicleRepo.ser");
        VehicleRepository repo = null;
        try {
            repo = VehicleRepository.getRepo();
        }
        catch(Exception ex){
            printer("Eccezione nel RECUPERO del repo");
        }

        if (repo != null) {
            //mio metodo di test che riempie la lista con elementi preimpostati
            //repo.vehicleListSetter();

            MenuBranch menu = menuBuilder();
            menu.select();

            /*
            //test metodi di lista per sotto-classe
            System.out.println(repo.getCarList().toString());
            System.out.println(repo.getTruckList().toString());
            System.out.println(repo.getMotorbikeList().toString());

            //test metodo per lista completa di Vehicle
            System.out.println(repo.getVehicleList().toString());

            //test aggiunta veicolo da console
            vehicleBuilder(repo);

            //todo ancora da mettere -> test per REMOVE, UPDATE*/

            //serializzazione
            repo.outputToFile();
        }
        else
            printer("IL REPO HA PUNTATORE NULLO, CONTROLLA PERCHé!");
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

    public static MenuBranch menuBuilder(){
        //visualizzazione delle liste per tipo
        MenuLeaf carFilter = new MenuLeaf("1", "Visualizza solamente le automobili",
                VehicleList::printCarList);
        MenuLeaf truckFilter = new MenuLeaf("2", "Visualizza solamente i camion",
                VehicleList::printTruckList);
        MenuLeaf motorbikeFilter = new MenuLeaf("3", "Visualizza solamente le moto",
                VehicleList::printMotorbikeList);
        MenuLeaf vehicleFilter = new MenuLeaf("4", "Visualizza tutti i veicoli", VehicleList::printVehicleList);
        MenuBranch listMenu = new MenuBranch("1", "Visualizza per tipo",
                Arrays.asList(carFilter, truckFilter, motorbikeFilter, vehicleFilter));

        //uso di metodi aggiunri, rimuovi, modifica
        MenuLeaf adding = new MenuLeaf("1", "Aggiungi", VehicleManager::removeVehicle); //todo da cambiare con metodo corretto
        MenuLeaf removing = new MenuLeaf("2", "Rimuovi", VehicleManager::removeVehicle);
        MenuLeaf updating = new MenuLeaf("3", "Aggiorna", VehicleManager::removeVehicle); //todo da cambiare con metodo corretto
        MenuBranch manipulationMenu = new MenuBranch("2", "Aggiungi, rimuovi, modifica",
                Arrays.asList(adding, removing, updating));

        MenuBranch mainMenu = new MenuBranch("0", "Main Menu", Arrays.asList(listMenu, manipulationMenu));
        //MenuLeaf exit = menuBuilder().exitItem();

        return mainMenu;
    }

    public static void printer(String s){
        System.out.print(s);
    }
}
