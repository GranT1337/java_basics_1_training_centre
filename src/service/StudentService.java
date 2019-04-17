package service;

import data.CurriculumData;
import dto.Course;
import dto.Curriculum;
import dto.Student;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;


import static java.time.temporal.ChronoUnit.DAYS;

public class StudentService {

    private CurriculumData curriculumData = new CurriculumData();

    // Сколько осталось полных дней обучаться
    public int getRemainingDaysByStudent(Student student) {
        int remainingDays = (int)((getCurriculumDurationHours(student.getCurriculum())/8) -
                                    DAYS.between(student.getStartDate(), LocalDate.now()));
        return remainingDays < 0 ? 0 : remainingDays;
    }

    // Сколько осталось обучаться часов в одном дне, если количество полных часов не делится на 8
    public int getRemainingHoursByStudent(Student student) {
        if (getRemainingDaysByStudent(student) == 0 &&
                getCurriculumDurationDays(student.getCurriculum()) == getRemainingDaysByStudent(student)) {
            return 0;
        } else {
            return  getCurriculumDurationHours(student.getCurriculum())%8;
        }
    }

    // Вывод количества часов, сколько занимают все курсы
    private int getCurriculumDurationHours(Curriculum curriculum) {
        int curriculumDuration = 0;

        for (Course course : curriculum.getCourseList()) {
            curriculumDuration += course.getDurationOfHours();
        }

        return curriculumDuration;
    }

    // Вывод количества полных дней, сколько занимают все курсы
    public int getCurriculumDurationDays(Curriculum curriculum) {
        return (int) Math.ceil(getCurriculumDurationHours(curriculum) / 8.0);
    }

    // Сколько всего часов осталось обучаться
    public int getRemainingAllHoursByStudent(Student student) {
        return  getCurriculumDurationHours(student.getCurriculum()) -
                (int)(DAYS.between(student.getStartDate(), LocalDate.now()) * 8) ;
    }


    public double getAVGMarksByStudent(Student student) {
        double value = student.getMarks().stream()
                                         .mapToDouble(a -> a)
                                         .average()
                                         .orElse(0);
        return new BigDecimal(value).setScale(1, RoundingMode.HALF_UP).doubleValue();
    }


    public int studentOpportunityToStudyFuther (Student student) {
        double marksAVG = getAVGMarksByStudent(student);
        int curriculumDurationDays = getCurriculumDurationDays(student.getCurriculum());

        int remainingDays = getRemainingDaysByStudent(student);
        int remainingHours = getRemainingHoursByStudent(student);

        if (remainingHours > 0) {
            remainingDays = remainingDays + 1;
        }

        //если он будет получать все пятерки
        double BestPossibleScore =
                (marksAVG * (curriculumDurationDays - remainingDays) + 5 * remainingDays) / curriculumDurationDays;
        //если он будет получать все единицы
        double WorstPossibleScore =
                (marksAVG * (curriculumDurationDays - remainingDays) + remainingDays) / curriculumDurationDays;
        if (WorstPossibleScore >= 4.5) {
            return 2;
        }
        if (BestPossibleScore < 4.5) {
            return 0;
        }
        return 1;
    }


    public Curriculum getCurriculumListById(int id) {
        return curriculumData.getCurriculumList().stream().filter(x -> x.getId() == id).findFirst().orElse(null);
    }
}
