package ires.corso.partthree.VehicleRepo.Menu;

public class MenuLeaf extends MenuItem{


    private Runnable _runAction;

    public MenuLeaf(String ID, String title, Runnable action){
        super(ID, title);
        _runAction = action;
    }

    @Override
    protected void select() {
        _runAction.run();
    }


}
