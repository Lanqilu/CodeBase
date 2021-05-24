import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import top.whl.pojo.Blender;
import top.whl.pojo.JuiceMaker;
import top.whl.pojo2.JuiceMaker2;
import top.whl.pojo3.JuiceMaker3;
import top.whl.service.UserServiceImpl;

/**
 * @author Halo
 * @date Created in 2020/07/31  11:18
 * @description
 */
public class JuiceMakerTest {
    @Test
    public void test01() {
        Blender blender = new Blender();
        String mix = blender.mix("农夫山泉", "西瓜", "白糖");
        System.out.println(mix);
    }

    @Test
    public void test02() {
        JuiceMaker juiceMaker = new JuiceMaker();
        String water = "农夫山泉";
        String fruit = "西瓜";
        String sugar = "白糖";
        juiceMaker.setWater(water);
        juiceMaker.setFruit(fruit);
        juiceMaker.setSugar(sugar);
        System.out.println(juiceMaker.makeJuice());
    }

    @Test
    public void test03() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        JuiceMaker2 juiceMaker2 = (JuiceMaker2) context.getBean("juiceMaker2");
        System.out.println(juiceMaker2.makeJuice());
    }

    @Test
    public void test04(){
        // 测试Spring Bean的生命周期
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("lifecycle.xml");
        JuiceMaker3 juiceMaker3 = (JuiceMaker3) context.getBean("juiceMaker3");
        System.out.println(juiceMaker3.makeJuice());
        context.close();
    }
}
