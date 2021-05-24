package reflection;


import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Date : 2020/2/22  21:47
 * @Author: Halo
 * @File : Reflect
 * @Version : v1.0
 * @Description: 反射
 **/

public class Reflect {

    //0. 获取Class的三种方式
    @Test
    public void classTest() throws Exception {

        //1. Class.forName("全类名")
        Class aClass = Class.forName("reflection.Person");
        System.out.println(aClass);

        System.out.println();
        //2. 类名.class
        Class bClass = Person.class;
        System.out.println(bClass);

        System.out.println();
        //3. 对象.getClass()
        Person p = new Person();
        Class cClass = p.getClass();
        System.out.println(cClass);

        //比较三个对象
        System.out.println(aClass == bClass);//true
        System.out.println(aClass == cClass);//true




    }


    //1. 获取成员变量
    @Test
    public void fieldTest() throws Exception {
        //0. 获取Class对象
        Class personClass = Person.class;

        //1.1 getFields()获取public修饰的成员变量
        Field[] fields = personClass.getFields();
        for (Field field : fields) {
            System.out.println(field);
        }

        System.out.println();
        //1.2 getField()获取指定名称的public修饰的成员变量
        Field studentA = personClass.getField("studentA");

        //获取成员变量的值
        Person person = new Person();
        Object value = studentA.get(person);
        System.out.println("studentAValue = " + value);
        //设置成员变量的值
        studentA.set(person, 1);
        System.out.println(person);

        System.out.println();
        //1.3 getDeclaredFields()获取所有的成员变量，不考虑修饰符
        Field[] declaredFields = personClass.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            System.out.println(declaredField);
        }

        System.out.println();
        //1.4 getDeclaredField()获取指定名称的成员变量,无论是否私有
        Field declaredField = personClass.getDeclaredField("studentD");
        //忽略访问权限修饰符的安全检查
        declaredField.setAccessible(true);//暴力反射
        Object value2 = declaredField.get(person);
        System.out.println("value2 = " + value2);

    }

    //2. 获取构造方法
    @Test
    public void constructorTest() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class personClass = Person.class;

        //2.1 getConstructor()获取构造方法
        Constructor constructor = personClass.getConstructor(String.class, int.class);
        System.out.println(constructor);
        //newInstance()创建对象
        Object personA = constructor.newInstance("小明", 18);
        System.out.println("personA = " + personA);

        //空参简化创建对象
        Object personB = personClass.newInstance();
        System.out.println("personB = " + personB);

        //同获取成员变量
//        personClass.getDeclaredConstructor()
//        personClass.getDeclaredConstructors()
//        constructor.setAccessible();
    }

    //3. 获取成员方法
    @Test
    public void methodTest() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class personClass = Person.class;

        //3.1 获取指定名称的方法
        Method eat = personClass.getMethod("eat");

        Person personC = new Person();
        //执行方法
        eat.invoke(personC);

        System.out.println();
        //3.2 获取带参方法
        Method eat_food = personClass.getMethod("eat",String.class);
        eat_food.invoke(personC,"西瓜🍉");

        System.out.println();
        //3.3 获取所有public修饰的方法包括父类
        Method[] methods = personClass.getMethods();

        for (Method method : methods) {
            System.out.println(method);
            String name = method.getName();
            System.out.println(name);

        }

        System.out.println();
        //3.4 获取所有的方法
        Method[] method = personClass.getDeclaredMethods();
        for (Method method1 : method) {
            method1.setAccessible(true);
            System.out.println(method1);
        }

    }

    //4. 获取类名
    @Test
    public void classNameTest() {
        Class personClass = Person.class;

        String name = personClass.getName();
        System.out.println(name);
    }




}
