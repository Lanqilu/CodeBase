package dependenceinversion;

/**
 * @author Halo
 * @date Created in 2020/07/30  13:14
 * @description
 */
public class Tom {


    public void studyJavaCourse() {
        System.out.println("Tom在学习Java课程");
    }
    public void studyPythonCourse() {
        System.out.println("Tom在学习Python课程");
    }

    public void study(ICourse course) {
        course.study();
    }
}
