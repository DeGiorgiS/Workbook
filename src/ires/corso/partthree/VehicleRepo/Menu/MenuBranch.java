package ires.corso.partthree.VehicleRepo.Menu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MenuBranch extends MenuItem{

    private List<MenuItem> _options = new ArrayList<>();
    private boolean _quit = false;

    public MenuBranch(String ID, String title, List<MenuItem> options){
        super(ID, title);
        _options.addAll(options);
    }

    @Override
    public void select() {
        Scanner in = new Scanner(System.in);

        while(!_quit){
            selectionPrinter();

            System.out.println("Seleziona cosa fare!");
            String choice = in.nextLine();

            MenuItem t = null;
            for (MenuItem o:
                 _options) {
                if(choice.equals(o.getID())){
                    t = o;
                    break;
                }
            }

            if (t != null)
                t.select();
            else
                System.out.println("Non ho capito la richiesta, riprova!");
        }
    }

    public MenuLeaf exitItem(){
        return new MenuLeaf("X", "Uscita", () -> _quit = true);
    }

    private void selectionPrinter(){
        System.out.println();
        System.out.println(getTitle());
        System.out.println("--------------------------");
        _options.forEach(o -> System.out.println(o.toString()));
        System.out.println("--------------------------");
    }
}
