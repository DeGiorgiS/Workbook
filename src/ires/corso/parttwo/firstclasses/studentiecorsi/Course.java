package ires.corso.parttwo.firstclasses.studentiecorsi;

import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeSet;

public class Course {

    private final String title;
    private final String description;
    private final String area;
    private HashSet<Assignment> homework = new HashSet<>();

    public Course(String title, String description, String area) {
        this.title = title;
        this.description = description;
        this.area = area;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getArea() {
        return area;
    }

    public void addAssignment(Assignment a){
        homework.add(a);
    }

    public Iterator<Assignment> getAssignmentIterator() {
        return homework.iterator();
    }
}
