package ires.corso.partthree.VehicleRepo.Menu;

public abstract class MenuItem {

    private final String _ID;
    private final String _title ;

    protected MenuItem(String ID, String title){
        _ID = ID;
        _title = title;
    }

    protected abstract void select();

    public String getID() {
        return _ID;
    }

    public String getTitle() {
        return _title;
    }

    @Override
    public String toString(){
        return getID() + ". " + getTitle();
    }
}
