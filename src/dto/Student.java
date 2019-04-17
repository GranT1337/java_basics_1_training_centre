package dto;

import java.time.LocalDate;
import java.util.List;

public class Student {

    private int id;
    private String name;
    private List<Integer> marks;
    private Curriculum curriculum;
    private LocalDate startDate;

    public Student(int id, String name, List<Integer> marks, Curriculum curriculum, LocalDate startDate) {
        this.id = id;
        this.name = name;
        this.marks = marks;
        this.curriculum = curriculum;
        this.startDate = startDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Integer> getMarks() {
        return marks;
    }

    public void setMarks(List<Integer> marks) {
        this.marks = marks;
    }

    public Curriculum getCurriculum() {
        return curriculum;
    }

    public void setCurriculum(Curriculum curriculum) {
        this.curriculum = curriculum;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }
}
