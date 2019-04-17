package dto;

public class Course {

    private int id;
    private String title;
    private int durationOfHours;

    public Course(int id, String title, int durationOfHours) {
        this.id = id;
        this.title = title;
        this.durationOfHours = durationOfHours;
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

    public int getDurationOfHours() {
        return durationOfHours;
    }

    public void setDurationOfHours(int durationOfHours) {
        this.durationOfHours = durationOfHours;
    }
}
