/**
 * @Date : 2020/2/13  19:30
 * @Author: Halo
 * @File : Test
 * @Version : v1.0
 * @Description:
 **/
public class Test {
    public static void main(String[] args) {
        int a = 10;
        int b = 20;
        //需要在method方法被调用之后，仅打印出a=100 b=200
        method(a,b);
        System.out.println("a = " + a);
        System.out.println("b = " + b);
    }

    //方法一
    public static void method(int a, int b){

        System.out.println("a = 100 b = 200");
        System.exit(0);
    }

    //方法二
//    public static void method(){
//
//    }
}
