package dependenceinversion;

/**
 * @author Halo
 * @date Created in 2020/07/30  13:35
 * @description Setter方法注入
 */
public class TomSetter {
    private ICourse course;

    public void setCourse(ICourse course) {
        this.course = course;
    }

    public void study(){
        course.study();
    }
}
