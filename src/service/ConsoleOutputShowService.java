package service;

import data.StudentData;
import dto.Student;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ConsoleOutputShowService {

    private StudentService studentService = new StudentService();
    private StudentData studentData = new StudentData();


    private void showToConsole(Student student) {
        System.out.println(student.getName() + " - До окончания обучения по программе "
                + student.getCurriculum().getTitle() + " осталось "
                + studentService.getRemainingDaysByStudent(student) + " дн. "
                + studentService.getRemainingHoursByStudent(student) + " ч."
                + " Средний балл " + studentService.getAVGMarksByStudent(student) + ".");

        studentStatus(student);
        System.out.println();
    }

    public void showListStudentsByAVGMarks() {
        List<Student> sortedStudent = studentData.getListStudents().stream()
                                                 .sorted(Comparator.comparing(studentService::getAVGMarksByStudent)
                                                 .reversed())
                                                 .collect(Collectors.toList());

        for (Student student : sortedStudent) {
            showToConsole(student);
        }
    }


    public void showListStudentsByDaysRemaining() {
        List<Student> sortedStudent = studentData.getListStudents().stream()
                                            .sorted(Comparator.comparing(studentService::getRemainingAllHoursByStudent)
                                            .reversed())
                                            .collect(Collectors.toList());
        for (Student student : sortedStudent) {
            showToConsole(student);
        }
    }

    public void showListStudentsWhoWillNotBeExpelled() {
        for (Student student : studentData.getListStudents()) {
            int remainingDays = studentService.getRemainingDaysByStudent(student);
            int remainingHours = studentService.getRemainingHoursByStudent(student);
            int studentStatus = studentService.studentOpportunityToStudyFuther(student);

            if (!(remainingDays == 0 & remainingHours == 0)) {
                if (studentStatus == 1 || studentStatus == 2) {
                    showToConsole(student);
                }
            }
        }
    }

    private void studentStatus(Student student) {

        int remainingDays = studentService.getRemainingDaysByStudent(student);
        int remainingHours = studentService.getRemainingHoursByStudent(student);
        double marksAVG = studentService.getAVGMarksByStudent(student);

        if (remainingDays == 0 & remainingHours == 0) {
            if (marksAVG < 4.5) {
                System.out.println("Студент исключен");
            } else {
                System.out.println("Студент успешно завершил обучение");
            }
        } else {
            int studentStatus = studentService.studentOpportunityToStudyFuther(student);
            if (studentStatus == 2) {
                System.out.println("Студент 100% успешно завершит курсы");
            }
            if (studentStatus == 0) {
                System.out.println("Необходимо отчислить");
            }
            if (studentStatus == 1 & marksAVG >= 4.5) {
                System.out.println("Студент имеет отличный средний балл, но нужно стараться дальше");
            }
            if (studentStatus == 1 & marksAVG < 4.5) {
                System.out.println("Студент имеет низкий средний балл, нужно поднапрячься! Ещё есть возможность!");
            }
        }
    }
}
