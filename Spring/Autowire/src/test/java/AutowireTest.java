
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import top.whl.pojo.Person;

/**
 * @Date: 2020年06月12日  00:01
 * @Description:
 **/
public class AutowireTest {
    @Test
    public void text1() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Person person = context.getBean("person", Person.class);
        person.getCat().shout();
        person.getDog().shout();
    }

    @Test
    public void text2() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Person person = context.getBean("person2", Person.class);
        person.getCat().shout();
        person.getDog().shout();
        System.out.println("person.getName() = " + person.getName());
    }

    @Test
    public void text3() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Person person = context.getBean("person3", Person.class);
        person.getCat().shout();
        person.getDog().shout();
        System.out.println("person.getName() = " + person.getName());
    }

    @Test
    public void text4() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Person person = context.getBean("person", Person.class);
        person.getCat().shout();
        person.getDog().shout();
        System.out.println("person.getName() = " + person.getName());
    }


}
