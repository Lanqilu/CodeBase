package reflection;

import java.lang.reflect.Method;

/**
 * @Date: 2020年02月23日  12:03
 * @Description: 使用注解达到与Demo同样的效果
 **/

//不能改变该类的任何代码的前提下，可以帮我们创建任意类的对象，并且执行其中任意方法

@Pro(className = "reflection.Person",methodName = "eat")
public class ReflectDemo2 {

    public static void main(String[] args) throws Exception {

        //1. 解析注解
        //1.1 获取该类的字节码文件对象
        Class<ReflectDemo2> reflectDemo2Class = ReflectDemo2.class;

        //1.2 获取注解对象
        //其实就是在内存中生成了一个该注解接口的子类实现对像
        Pro annotation = reflectDemo2Class.getAnnotation(Pro.class);

        //1.3 调用注解对象中定义的抽象方法，获取返回值
        String className = annotation.className();
        String methodName = annotation.methodName();
        System.out.println("className = " + className);
        System.out.println("methodName = " + methodName);



        //3. 加载类
        Class cls = Class.forName(className);
        //4. 创建对象
        Object obj = cls.newInstance();
        //5. 获取方法对象
        Method method = cls.getMethod(methodName);
        //6. 执行方法
        method.invoke(obj);
    }
}
