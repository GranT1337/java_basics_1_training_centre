package data;


import dto.Student;
import service.StudentService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

public class StudentData {

    private List<Student> listStudents = new ArrayList<>();
    private StudentService studentService = new StudentService();

    public StudentData() {
        fillStudents();
    }

    private void fillStudents() {
        listStudents.add(new Student(1, "Ostanin Kirill", createMarks(3),
                            studentService.getCurriculumListById(1), LocalDate.now().minusDays(3)));

        listStudents.add(new Student(2, "Miroliubov Vyacheslav", createMarks(8),
                            studentService.getCurriculumListById(2), LocalDate.now().minusDays(8)));

        listStudents.add(new Student(3, "Sozonov Anton", createMarks(6),
                            studentService.getCurriculumListById(3), LocalDate.now().minusDays(6)));

        listStudents.add(new Student(4, "Popov Viktor", createMarks(8),
                            studentService.getCurriculumListById(3), LocalDate.now().minusDays(8)));

        listStudents.add(new Student(5, "Mezrin Egor", createMarks(7),
                            studentService.getCurriculumListById(2), LocalDate.now().minusDays(7)));

        listStudents.add(new Student(6, "Gavrilov Maksim", createMarks(7),
                            studentService.getCurriculumListById(1), LocalDate.now().minusDays(7)));
    }

    private List<Integer> createMarks(int quantity) {
        List<Integer> marks = new ArrayList<>();

        for (int i = 0; i < quantity; i++) {
            marks.add(ThreadLocalRandom.current().nextInt(3, 6));
        }
        return marks;
    }

    public List<Student> getListStudents() {
        return listStudents;
    }

}
