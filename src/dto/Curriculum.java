package dto;

import java.util.List;

public class Curriculum {

    private int id;
    private String title;
    private List<Course> courseList;

    public Curriculum() {

    }

    public Curriculum(int id, String title, List<Course> courseList) {
        this.id = id;
        this.title = title;
        this.courseList = courseList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Course> getCourseList() {
        return courseList;
    }

    public void setCourseList(List<Course> courseList) {
        this.courseList = courseList;
    }
}
