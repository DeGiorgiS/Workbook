package ires.corso.parttwo.firstclasses.studentiecorsi;

import java.util.HashMap;
import java.util.TreeMap;

public class Assignment {

    private final String title;
    private final String description;
    private HashMap<Student, Integer> studentsScores = new HashMap<>(); //K: studente, V: voto dello studente


    public Assignment(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    /*  aggiunge un punteggio ad uno specifico studente per un compito, aggiornandovi anche le relative properties
    interne allo Student  */
    public void addResult(Student stud, Integer score){
        studentsScores.put(stud, score);
        stud.addAssignmentDone();
        stud.addScore(score);
    }

    public Integer getScore(Student stud){
        return studentsScores.get(stud);
    }
}
