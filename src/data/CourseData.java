package data;

import dto.Course;

import java.util.ArrayList;
import java.util.List;

public class CourseData {

    private List<Course> courseListForJava2EE = new ArrayList<>();
    private List<Course> courseListForJavaScript = new ArrayList<>();
    private List<Course> courseListForJavaDeveloper = new ArrayList<>();

    public CourseData() {
        fillCourses();
    }

    public void fillCourses() {

        courseListForJavaScript.add(new Course(1, "HTML", 16));
        courseListForJavaScript.add(new Course(2, "CSS", 15));
        courseListForJavaScript.add(new Course(3, "JavaScript", 16));
        courseListForJavaScript.add(new Course(4, "JQuery", 8));
        courseListForJavaScript.add(new Course(5, "React", 16));

        courseListForJava2EE.add(new Course(6, "Технология Java Servlets", 16));
        courseListForJava2EE.add(new Course(7, "Struts Framework", 24));
        courseListForJava2EE.add(new Course(8, "Spring Framework", 47));
        courseListForJava2EE.add(new Course(9, "Hibernate", 24));

        courseListForJavaDeveloper.add(new Course(10, "Обзор технологий Java", 8));
        courseListForJavaDeveloper.add( new Course(11, "Библиотека JFC/Swing", 16));
        courseListForJavaDeveloper.add(new Course(12, "Технология JDBC", 15));
        courseListForJavaDeveloper.add(new Course(13, "Технология JAX", 52));
        courseListForJavaDeveloper.add(new Course(14, "Библиотеки commons", 40));
    }


    public List<Course> getCourseListForJava2EE() {
        return courseListForJava2EE;
    }

    public List<Course> getCourseListForJavaScript() {
        return courseListForJavaScript;
    }

    public List<Course> getCourseListForJavaDeveloper() {
        return courseListForJavaDeveloper;
    }
}
