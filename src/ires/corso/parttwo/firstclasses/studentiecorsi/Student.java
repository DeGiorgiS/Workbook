package ires.corso.parttwo.firstclasses.studentiecorsi;


public class Student {

    protected final String name;
    protected final String surname;
    protected final String studID;

    private int totalSumScores;
    private int numberOfAssignmentsDone;

    public Student(String name, String surname, String studID) {
        this.name = name;
        this.surname = surname;
        this.studID = studID;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getStudID() {
        return studID;
    }

    public int getTotalSumScores() {
        return totalSumScores;
    }

    public int getNumberOfAssignmentsDone() {
        return numberOfAssignmentsDone;
    }

    public void addAssignmentDone(){
        numberOfAssignmentsDone ++;
    }

    public void addScore(int score){
        totalSumScores += score;
    }
}
