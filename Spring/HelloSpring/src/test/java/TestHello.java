import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import top.whl.pojo.Hello;

/**
 * @Date: 2020年06月09日  19:37
 * @Description:
 **/
public class TestHello {
    public static void main(String[] args) {
        //获取Spring的上下文对象
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        //对象在Spring中管理，使用直接取
        Hello hello = (Hello) context.getBean("hello");
        System.out.println("hello.toString() = " + hello.toString());
    }
}
