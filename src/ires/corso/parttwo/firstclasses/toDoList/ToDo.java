package ires.corso.parttwo.firstclasses.toDoList;

import java.io.Serializable;
import java.time.LocalDate;

public class ToDo implements Serializable {

    private enum Priorities {ALTA, MEDIA, BASSA};

    private enum States {DA_FARE, IN_ESECUZIONE, COMPLETATA, ANNULLATA};
    // classe principale
    private static Long countID; // todo IL CONTATORE STATIC NON VIENE SERIALIZZATO, DA CAPIRE COME GIRARCI ATTORNO (es. variabile non static in ToDoRepository)
    private final Long entityID;
    private String title;
    private String description;
    private final LocalDate dateOfCreation;
    private LocalDate dateOfExpiration;
    private Priorities priority;
    private States state;



    // ...costruttore con ID incrementale...
    public ToDo(){
        entityID = setID();
        title = null;
        description = null;
        dateOfCreation = LocalDate.now();
        dateOfExpiration = null;
        priority = Priorities.ALTA;
        state = States.DA_FARE;
    }

    public ToDo(String t, String d, LocalDate date, Priorities p, States s){
        entityID = setID();
        title = t;
        description = d;
        dateOfCreation = LocalDate.now();
        dateOfExpiration = date;
        priority = p;
        state = s;
    }

    private ToDo(Long id){
        entityID = id;
        title = getTitle();
        description = getDescription();
        dateOfCreation = getDateOfCreation();
        dateOfExpiration = getDateOfExpiration();
        priority = getPriority();
        state = getState();
    }

    //metodo interno per prendere il minor ID libero e poi incrementare.
    //migliorabile con un controllo sul minor ID non utilizzato (es. ID 2 libero, ma ID dal 3 al 6 usati)
    private Long setID(){
        return countID++;
    }

    public static Long getCountID() {
        return countID;
    }

    public Long getEntityID() {
        return entityID;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public LocalDate getDateOfCreation() {
        return dateOfCreation;
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

    public void setDateOfExpiration(LocalDate dateOfExpiration) {
        this.dateOfExpiration = dateOfExpiration;
    }

    public void setPriority(Integer i) {
        //todo faccio un if che collega numeri a valori del enum
        this.priority = priority;
    }

    public void setState(States state) {
        this.state = state;
    }

    /* fabbrica una copia esatta del To-Do (compreso l'ID)
            pensavo di creare un costruttore "volante" qui dentro che mi permettesse di riassegnare l'ID*/
    public ToDo cloneForUpdate() {

        /*@Override
        public ToDo(){
            entityID = getEntityID();
            title = getTitle();
            description = getDescription();
            dateOfCreation = getDateOfCreation();
            dateOfExpiration = getDateOfExpiration();
            priority = getPriority();
            state = getState();
        }
         */
        Long id = getEntityID();
        ToDo copiedToDo = new ToDo(id); //uso un costruttore PRIVATO per ID che crea una copia, ID compreso. todo da rivedere, poco elegante
        return copiedToDo;
    }

    public String prettyPrint(){
        String s = String.format(" ID: %d \n TITOLO: %s \n DESCRIZIONE: %s \n CREATO IL: %s \n CON SCADENZA IL: %s \n CON PRIORITà: %s \n CON STATO: %s",
                getEntityID(), getTitle(), getDescription(), getDateOfCreation().toString(), getDateOfExpiration().toString(), getPriority().toString(),
                getState().toString());
        return s;
    }
}
