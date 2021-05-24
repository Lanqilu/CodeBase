import dependenceinversion.*;
import org.junit.jupiter.api.Test;


/**
 * @author Halo
 * @date Created in 2020/07/30  13:18
 * @description Tom测试类
 */
public class TestTom {
    @Test
    public void TomTest1() {
        Tom tom = new Tom();
        tom.studyJavaCourse();
        tom.studyPythonCourse();
    }

    @Test
    public void TomTest2(){
        //依赖注入
        Tom tom = new Tom();
        tom.study(new JavaCourse());
        tom.study(new PythonCourse());
    }

    @Test
    public void TomConstructorTest(){
        //构造器注入
        TomConstructor tomConstructor = new TomConstructor(new JavaCourse());
        tomConstructor.study();
    }

    @Test
    public void TomSetterTest(){
        //Setter注入
        TomSetter tomSetter = new TomSetter();
        tomSetter.setCourse(new JavaCourse());
        tomSetter.study();
        tomSetter.setCourse(new PythonCourse());
        tomSetter.study();
    }


}
