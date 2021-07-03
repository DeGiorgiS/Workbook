package ires.corso.parttwo.firstclasses.toDoList;

import java.io.Serializable;
import java.time.LocalDate;

public class ToDo implements Serializable, Cloneable {

    protected enum Priorities {ALTA, MEDIA, BASSA};
    protected enum States {DA_FARE, IN_ESECUZIONE, COMPLETATA, ANNULLATA};

    // priorities
    private final Long ENTITY_ID;
    private String title;
    private String description;
    private final LocalDate DATE_OF_CREATION;
    private LocalDate dateOfExpiration;
    private Priorities priority;
    private States state;



    //costruttore di default
    public ToDo() throws Exception{
        ENTITY_ID = ToDoRepository.getToDoRepository().getNewId();
        title = null;
        description = null;
        DATE_OF_CREATION = LocalDate.now();
        dateOfExpiration = null;
        priority = Priorities.ALTA;
        state = States.DA_FARE;
    }

    public ToDo(String t, String d, LocalDate date, Priorities p, States s) throws Exception{
        ENTITY_ID = ToDoRepository.getToDoRepository().getNewId();
        title = t;
        description = d;
        DATE_OF_CREATION = LocalDate.now();
        dateOfExpiration = date;
        priority = p;
        state = s;
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

    //stringa più comprensibile
    public String prettyPrint(){
        String s = String.format(" ID: %d \n TITOLO: %s \n DESCRIZIONE: %s \n CREATO IL: %s \n CON SCADENZA IL: %s \n CON PRIORITà: %s \n CON STATO: %s",
                getEntityID(), getTitle(), getDescription(), getDateOfCreation().toString(), getDateOfExpiration().toString(), getPriority().toString(),
                getState().toString());
        return s;
    }
}
