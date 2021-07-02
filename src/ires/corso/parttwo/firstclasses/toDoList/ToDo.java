package ires.corso.parttwo.firstclasses.toDoList;

import java.io.Serializable;
import java.time.LocalDate;

public class ToDo implements Serializable, Cloneable {

    protected enum Priorities {ALTA, MEDIA, BASSA};
    protected enum States {DA_FARE, IN_ESECUZIONE, COMPLETATA, ANNULLATA};

    // priorities
    private static Long countID = 0l; // todo IL CONTATORE STATIC NON VIENE SERIALIZZATO, DA CAPIRE COME GIRARCI ATTORNO (es. variabile non static in ToDoRepository)
    private final Long ENTITY_ID;
    private String title;
    private String description;
    private final LocalDate DATE_OF_CREATION;
    private LocalDate dateOfExpiration;
    private Priorities priority;
    private States state;



    // ...costruttore con ID incrementale...
    public ToDo(){
        ENTITY_ID = setID();
        title = null;
        description = null;
        DATE_OF_CREATION = LocalDate.now();
        dateOfExpiration = null;
        priority = Priorities.ALTA;
        state = States.DA_FARE;
    }

    public ToDo(String t, String d, LocalDate date, Priorities p, States s){
        ENTITY_ID = setID();
        title = t;
        description = d;
        DATE_OF_CREATION = LocalDate.now();
        dateOfExpiration = date;
        priority = p;
        state = s;
    }

    //costruttore per TEST di debug, todo da eliminare
    public ToDo(String t, String d, LocalDate date){
        ENTITY_ID = setID();
        title = t;
        description = d;
        DATE_OF_CREATION = LocalDate.now();
        dateOfExpiration = date;
        priority = Priorities.ALTA;
        state = States.DA_FARE;
    }

    //metodo interno per prendere il minor ID libero e poi incrementare.
    //migliorabile con un controllo sul minor ID non utilizzato (es. ID 2 libero, ma ID dal 3 al 6 usati)
    private Long setID(){
        countID++;
        return countID;
    }

    public static Long getCountID() {
        return countID;
    }

    public Long getEntityID() {
        return ENTITY_ID;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public LocalDate getDateOfCreation() {
        return DATE_OF_CREATION;
    }

    public LocalDate getDateOfExpiration() {
        return dateOfExpiration;
    }

    public Priorities getPriority() {
        return priority;
    }

    public States getState() {
        return state;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDateOfExpiration(LocalDate dateOfExpiration) {
        this.dateOfExpiration = dateOfExpiration;
    }

    public void setPriority(Priorities p) {
        this.priority = p;
    }

    public void setState(States state) {
        this.state = state;
    }

    /* fabbrica una copia esatta del To-Do (compreso l'ID)*/
    public ToDo cloneForUpdate() throws CloneNotSupportedException {

        ToDo copiedToDo = null;
        try{
            copiedToDo = (ToDo) clone();
        }
        catch (CloneNotSupportedException cnse){
            System.out.println("ERRORE");
        }
        return copiedToDo;
    }

    public String prettyPrint(){
        String s = String.format(" ID: %d \n TITOLO: %s \n DESCRIZIONE: %s \n CREATO IL: %s \n CON SCADENZA IL: %s \n CON PRIORITà: %s \n CON STATO: %s",
                getEntityID(), getTitle(), getDescription(), getDateOfCreation().toString(), getDateOfExpiration().toString(), getPriority().toString(),
                getState().toString());
        return s;
    }

    public int comparePriority(ToDo t){
        return priority.compareTo(t.getPriority());
    }

    public int compareState(ToDo t){
        return state.compareTo(t.getState());
    }
}
