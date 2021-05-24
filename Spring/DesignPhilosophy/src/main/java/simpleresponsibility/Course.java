package simpleresponsibility;

/**
 * @author Halo
 * @date Created in 2020/07/30  13:41
 * @description 没有进行单一原则
 */
public class Course {
    public void study(String courseName) {
        if ("直播课".equals(courseName)) {
            System.out.println(courseName + "不能快进");
        }
        else {
            System.out.println(courseName+"可以反复回看");
        }
    }
}
