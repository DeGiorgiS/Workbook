package ires.corso.partthree.VehicleRepo;

import java.util.Scanner;

public class VehicleManager {

    private static VehicleRepository repo;

    private VehicleManager(){}

    private static void repoGetter(){
        try {
            repo = VehicleRepository.getRepo();
        }
        catch (Exception e){
            VehicleRepoTester.printer("ECCEZIONE NEL RECUPERO DEL REPO NEL VEHICLE MANAGER");
        }
    }

    public static void createNewVehicle(){}

    public static void removeVehicle(){
        repoGetter();
        VehicleRepoTester.printer("Indica la targa del veicolo da rimuovere");
        Scanner in = new Scanner(System.in);

        String answer = in.nextLine();
        if(repo.exists(answer)){
            VehicleRepoTester.printer("Stai eliminando il seguente veicolo: ");
            VehicleRepoTester.printer(repo.getVehicle(answer).prettyPrint());
            if(confirm()){
                repo.remove(repo.getVehicle(answer));
            }
        }
        else
            VehicleRepoTester.printer("Targa non presente nel database");

    }

    public static void updateVehicle(){}

    private static boolean confirm(){
        VehicleRepoTester.printer("Confermi? (S per confermare, altro tasto per annullare)\n");
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        if (input.equalsIgnoreCase("s")){
            return true;
        }
        else
            return false;
    }
}
