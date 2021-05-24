package dependenceinversion;

/**
 * @author Halo
 * @date Created in 2020/07/30  13:31
 * @description 构造器方式注入
 */
public class TomConstructor {
    private ICourse course;

    public TomConstructor(ICourse course) {
        this.course = course;
    }

    public void study(){
        course.study();
    }
}
