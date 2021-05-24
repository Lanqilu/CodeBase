
import org.junit.jupiter.api.Test;
import simpleresponsibility.Course;
import simpleresponsibility.LiveCourse;
import simpleresponsibility.ReplayCourse;

/**
 * @author Halo
 * @date Created in 2020/07/30  13:44
 * @description
 */
public class TestCourse {
    @Test
    public void CourseTest1(){
        Course course = new Course();
        course.study("直播课");
        course.study("录播课");
    }

    @Test
    public void CourseTest2() {
        LiveCourse liveCourse = new LiveCourse();
        liveCourse.study("直播课");
        ReplayCourse replayCourse = new ReplayCourse();
        replayCourse.study("录播课");
    }
}
