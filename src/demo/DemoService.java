package demo;

import data.CourseData;
import data.CurriculumData;
import data.StudentData;
import service.ConsoleOutputShowService;


public class DemoService {
    public void execute() {

        ConsoleOutputShowService consoleOutputShowService = new ConsoleOutputShowService();

        System.out.println("4.a.СОРТИРОВКА ПО СРЕДНЕМУ БАЛЛУ");
        System.out.println("=================================================");
        consoleOutputShowService.showListStudentsByAVGMarks();
        System.out.println("=================================================");


        System.out.println("4.b. СОРТИРОВКА ПО ВРЕМЕНИ ДО ОКОНЧАНИЯ ОБУЧЕНИЯ");
        System.out.println("=================================================");
        consoleOutputShowService.showListStudentsByDaysRemaining();
        System.out.println("=================================================");

        System.out.println("5. Список студентов, у которых есть вероятность, что не будут отчислены");
        System.out.println("=================================================");
        consoleOutputShowService.showListStudentsWhoWillNotBeExpelled();
        System.out.println("=================================================");
    }
}
