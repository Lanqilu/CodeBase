
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import top.whl.pojo.User;

/**
 * @Date: 2020年06月12日  11:16
 * @Description:
 **/
public class Test0 {
    @Test
    public void text1(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        User user = context.getBean("user", User.class);
        System.out.println("user.name = " + user.name);

    }
}
