
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import top.whl.config.Config01;
import top.whl.pojo.User;

/**
 * @Date: 2020年06月12日  11:55
 * @Description:
 **/
public class Text0 {
    @Test
    public void text1(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config01.class);
        User getUser = context.getBean("user", User.class);
        System.out.println("getUser.getName() = " + getUser.getName());
    }
}
