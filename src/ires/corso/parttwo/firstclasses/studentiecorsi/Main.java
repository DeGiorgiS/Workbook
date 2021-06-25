package ires.corso.parttwo.firstclasses.studentiecorsi;

// ArrayList
// Set
// Map

// 1. Studenti e corsi
//
//    Creare le seguenti classi:
//    - Student (nome, cognome, codiceStudente, tutti String)
//    - Course (titolo, descrizione, settore)
//    - Assignment (titolo, descrizione)
//
//    Create anche i dati sdi almeno:
//    - 3 studenti
//    - 3 corsi
//    - un corso ha 2 o + assignment, ciascun studente esegue tutti gli assignment ricevendo un voto da 1 a 10
//
//    Caricate tutti i dati in un'unica collection, organizzata in modo da poter contenere tutti i voti presi
//    da ciascuno studente.
//
//    Calcolate con questa struttura:
//    - la media dei voti di ciascun studente in ciascun corso (come è andato ciascun studente in un corso?)
//    - la media dei voti di tutti gli studenti in ciascun assignment (quanto è difficile per gli studenti
//      un certo assignment?)

import java.util.*;


//POSSO TOGLIERE IL LINKEDCOURSE DALLE PROPERTIES DELL'ASSIGNMENT???
public class Main {

    public static void main(String[] args){
        // creo gli studenti
        Map<String, Student> theStudents = new HashMap<String, Student>();
        theStudents.put("id1", new Student("Mario", "Rossi", "id1"));
        theStudents.put("id2", new Student("Jure", "Verul", "id2"));
        theStudents.put("id3", new Student("Marco", "Caco", "id3"));

        // creo i corsi
        Map<String, Course> theCourses = new HashMap<String, Course>();
        theCourses.put("Analisi 1", new Course("Analisi 1", "Primo corso di matematica", "STEM"));
        theCourses.put("Basi di filosofia", new Course("Basi di filosofia", "Primo corso di filosofia",
                "Umanistica"));
        theCourses.put("Sopravvivenza", new Course("Sopravvivenza", "Come vivere",
                "Scuola della vita"));

        // aggiungo i compiti, almeno 2 per corso
        Assignment equazioni1 = new Assignment("Equazioni 1",
                "Primo esercizio sulle equazioni");
        theCourses.get("Analisi 1").addAssignment(equazioni1);

        Assignment equazioni2 = new Assignment("Equazioni 2", "Secondo esercizio sulle equazioni");
        theCourses.get("Analisi 1").addAssignment(equazioni2);

        Assignment platone = new Assignment("Platone", "Descrivi il pensiero di Platone");
        theCourses.get("Basi di filosofia").addAssignment(platone);

        Assignment kant = new Assignment("Kant", "Descrivi il pensiero di Kant");
        theCourses.get("Basi di filosofia").addAssignment(kant);

        Assignment strada = new Assignment("La strada", "Diventa il re della strada");
        theCourses.get("Sopravvivenza").addAssignment(strada);

        Assignment rispetto = new Assignment("Il rispetto", "Guadagna il rispetto");
        theCourses.get("Sopravvivenza").addAssignment(rispetto);

        // compiti svolti e voto assegnato
        /* usando il Random
        Iterator<Course> itrCourses = theCourses.values().iterator();
        while(itrCourses.hasNext()){
            Course selectedCourse = itrCourses.next();
            Iterator<Assignment> itrAssign = selectedCourse.getAssignmentIterator();
            while(itrAssign.hasNext()){
                Assignment selectedAssignment = itrAssign.next();
                for(Student st : theStudents.values()){
                    selectedAssignment.addResult(st, Random.ints(1,11));
                }
            }
        }
        */
        //compiti di Analisi 1 (aggiungo voto ad assignment e studente)
        Iterator<Assignment> itrAssign = theCourses.get("Analisi 1").getAssignmentIterator();
        Assignment selectedAssignment = itrAssign.next();
        selectedAssignment.addResult(theStudents.get("id1"), 7);
        selectedAssignment.addResult(theStudents.get("id2"), 6);
        selectedAssignment.addResult(theStudents.get("id3"), 10);
        selectedAssignment = itrAssign.next();
        selectedAssignment.addResult(theStudents.get("id1"), 8);
        selectedAssignment.addResult(theStudents.get("id2"), 4);
        selectedAssignment.addResult(theStudents.get("id3"), 8);

        //compiti di filosofia
        itrAssign = theCourses.get("Basi di filosofia").getAssignmentIterator();
        selectedAssignment = itrAssign.next();
        selectedAssignment.addResult(theStudents.get("id1"), 6);
        selectedAssignment.addResult(theStudents.get("id2"), 8);
        selectedAssignment.addResult(theStudents.get("id3"), 6);
        selectedAssignment = itrAssign.next();
        selectedAssignment.addResult(theStudents.get("id1"), 8);
        selectedAssignment.addResult(theStudents.get("id2"), 9);
        selectedAssignment.addResult(theStudents.get("id3"), 7);

        //compiti di vita
        itrAssign = theCourses.get("Sopravvivenza").getAssignmentIterator();
        selectedAssignment = itrAssign.next();
        selectedAssignment.addResult(theStudents.get("id1"), 4);
        selectedAssignment.addResult(theStudents.get("id2"), 10);
        selectedAssignment.addResult(theStudents.get("id3"), 9);
        selectedAssignment = itrAssign.next();
        selectedAssignment.addResult(theStudents.get("id1"), 5);
        selectedAssignment.addResult(theStudents.get("id2"), 9);
        selectedAssignment.addResult(theStudents.get("id3"), 6);

        //calcolo media voti di ogni studente
        double meanStudent = 0;
        for (Student st:
             theStudents.values()) {
            meanStudent = (double) st.getTotalSumScores() / st.getNumberOfAssignmentsDone();
            System.out.printf("La media dei voti dello studente %s %s è " + meanStudent + "\n", st.getSurname(),
                    st.getName());
        }


        //calcolo media voti di ciascun assignment
        System.out.println();
        double meanScoreAssignment = 0;
        int numScoresPerAssignment = 0;

        Iterator<Course> itrCourses = theCourses.values().iterator();  //riutilizzo il Iterator<Course>
        while(itrCourses.hasNext()){
            Course selectedCourse = itrCourses.next();
            itrAssign = selectedCourse.getAssignmentIterator();  //riutilizzo il Iterator<Assignment>
            while(itrAssign.hasNext()){
                meanScoreAssignment = 0;
                numScoresPerAssignment = 0;  //resetto le due variabili per il calcolo della media
                selectedAssignment = itrAssign.next();  //riutilizzo la variabile Assignment
                for(Student st : theStudents.values()){
                    meanScoreAssignment += selectedAssignment.getScore(st);
                    numScoresPerAssignment ++;
                }
                meanScoreAssignment = meanScoreAssignment / numScoresPerAssignment;
                System.out.printf("La media dei voti per il compito %s è " + meanScoreAssignment + "\n",
                        selectedAssignment.getTitle());
            }

        }
    }
}
