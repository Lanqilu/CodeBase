package control;

/**
 * @Date : 2020/1/31  17:15
 * @Author: Halo
 * @File : WhileTest
 * @Description: 演示 while 循环 | do-while 语句至少会执行一次
 **/
public class WhileTest {
    static boolean condition() {
        boolean result = Math.random() < 0.99;
        System.out.print(result + ",");
        return result;
    }

    public static void main(String[] args) {
        while (condition()) {
            System.out.println("Inside 'while'");
        }
        System.out.println("Exited 'while");
    }
}
