import com.halo.service.UserService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Halo
 * @date Created in 2020/11/04  16:56
 * @description
 */
public class AOPTest {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        // 动态代理接口 不是实现类
        UserService userService = context.getBean("userService", UserService.class);
        userService.add();
        userService.delete();
        userService.select();
        userService.update();
    }
}

