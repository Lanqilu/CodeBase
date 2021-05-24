package reflection;

/**
 * @Date : 2020/2/22  21:43
 * @Author: Halo
 * @File : Person
 * @Version : v1.0
 * @Description: 被测试类
 **/
public class Person {
    public String name;
    public int age;


    public int studentA;
    protected String studentB;
    int studentC;
    private int studentD;

    public Person() {

    }

    private void read() {
        System.out.println("读书");
    }

    public void eat() {
        System.out.println("吃饭");
    }

    public void eat(String food) {
        System.out.println("吃" + food);
    }

    private void watch() {
        System.out.println("看电视");
    }


    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", studentA=" + studentA +
                ", studentB='" + studentB + '\'' +
                ", studentC=" + studentC +
                ", studentD=" + studentD +
                '}';
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
