import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import top.whl.pojo2.Role;

/**
 * @author Halo
 * @date Created in 2020/07/31  13:23
 * @description 构造器注入测试
 */
public class Pojo2Test {
    @Test
    public void construct(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("constructor.xml");
        Role role = (Role) context.getBean("constructorRole");
        System.out.println(role);
    }

    @Test
    public void setter(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("setter.xml");
        Role role = (Role) context.getBean("setterRole");
        System.out.println(role);
    }
}
