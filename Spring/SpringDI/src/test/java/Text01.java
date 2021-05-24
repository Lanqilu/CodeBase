import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import top.whl.pojo.Student;
import top.whl.pojo.User;

/**
 * @Date: 2020年06月11日  22:24
 * @Description:
 **/
public class Text01 {
    public static void main(String[] args) {
        //CPX
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Student student = (Student) context.getBean("student");
        System.out.println("student.toString() = " + student.toString());
    }
    @Test
    public void test02(){

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("user.xml");
        User user = context.getBean("user", User.class);
        System.out.println("user = " + user);
    }

    @Test
    public void test03(){

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("user.xml");
        User user2 = context.getBean("user2", User.class);
        System.out.println("user2 = " + user2);
    }

    @Test
    public void test04(){

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("user.xml");
        User user2 = context.getBean("singleton", User.class);
        User user3 = context.getBean("singleton", User.class);
        System.out.println(user3==user2);//true
    }

    @Test
    public void test05(){

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("user.xml");
        User user2 = context.getBean("prototype", User.class);
        User user3 = context.getBean("prototype", User.class);
        System.out.println(user3==user2);//false
    }
}
