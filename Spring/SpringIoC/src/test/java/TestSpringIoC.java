import org.springframework.context.support.ClassPathXmlApplicationContext;
import top.whl.service.UserServiceImpl;

/**
 * @Date: 2020年06月09日  20:08
 * @Description:
 **/
public class TestSpringIoC {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

        UserServiceImpl userServiceImpl = (UserServiceImpl) context.getBean("UserServiceImpl");

        userServiceImpl.getUser();
    }
}
