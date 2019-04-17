package data;

import dto.Curriculum;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CurriculumData {

    private List<Curriculum> curriculumList = new ArrayList<>();

    public CurriculumData() {
        fillCurriculum();
    }

    public void fillCurriculum() {

        curriculumList.add(new Curriculum(1, "J2EE Developer",
                                                new CourseData().getCourseListForJava2EE()));

        curriculumList.add(new Curriculum(2, "JavaScript Developer",
                                                new CourseData().getCourseListForJavaScript()));

        curriculumList.add(new Curriculum(3, "Java Developer",
                                                new CourseData().getCourseListForJavaDeveloper()));
    }

    public List<Curriculum> getCurriculumList() {
        return curriculumList;
    }
}
