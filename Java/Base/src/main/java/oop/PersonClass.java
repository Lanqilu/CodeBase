package oop;

/**
 * @Date : 2020/2/10  18:52
 * @Author: Halo
 * @File : PersonClass
 * @Version : v1.0
 * @Description: 类和对象的使用
 **/
public class PersonClass {
    public static void main(String[] args) {
        //类的实例化(创建类的对象)
        Person p1 = new Person();
        //调用对象属性
        p1.name = "TOM";
        p1.age = 18;
        p1.isMale = true;
        //调用对象方法
        p1.eat();
        p1.sleep();
        p1.talk("英语");

        //创建另一个对象
        Person p2 = new Person();
        System.out.println("p2.name = " + p2.name);//null
        p2.name = "Jerry";
        p2.talk("中文");

        Person p3 = p1;//内存地址赋值拍p3
        System.out.println("p3.name = " + p3.name);
    }

}

class Person {
    //属性(成员变量)
    String name;
    int age = 1;
    boolean isMale;

    //方法
    public void eat() {
        String food = "饭";//局部变量
        System.out.println("人可以吃" + food);
    }

    public void sleep() {
        System.out.println("人可以睡觉");
    }

    public void talk(String language) { //language形参(局部变量)
        System.out.println(name + "会" + language);
    }
}
