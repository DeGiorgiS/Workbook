package ires.corso.parttwo.firstclasses;

public class Speaker {

    private int volume; //livello volume da 0 a 100 (dovrei controllare i valori)
    private String type; //tipo (es. Stereo, mono, dolby,...)
    private boolean isOn; //accceso o spento

    //costruttori
    public Speaker (int volume, String type){
        this.volume = volume;
        this.type = type;
        isOn = false;
    }

    public Speaker (int volume, String type, boolean isOn){
        this.volume = volume;
        this.type = type;
        this.isOn = isOn;
    }

    //getter e setter

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        if(volume < 0 || volume >100)
            System.out.println("Inserisci un numero tra 0 e 100 di livello volume");
        else
            this.volume = volume;
    }

    public String getType(){
        return type;
    }

    public void setType(String type){
        this.type = type;
    }

    public boolean getIsOn(){
        return isOn;
    }

    public void setIsOn(boolean isOn){
        this.isOn = isOn;
    }

    //metodo prettyPrint
    public void prettyPrint(){
        if(isOn == true)
            System.out.printf("Sono un altoparlante di tipo %s a volume %d su 100 e sono acceso\n", type, volume);
        else
            System.out.printf("Sono un altoparlante di tipo %s a volume %d su 100 e sono spento\n", type, volume);
    }
}
