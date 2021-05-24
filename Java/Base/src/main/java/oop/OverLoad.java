package oop;

/**
 * @Date : 2020/2/13  19:09
 * @Author: Halo
 * @File : OverLoad
 * @Version : v1.0
 * @Description: 方法的重载
 **/

// 同一类，方法名相同
// 参数列表不同

public class OverLoad {
    public static void main(String[] args) {

        OverLoad test = new OverLoad();
        test.getSum(1,2);
    }

    public void getSum(int i, int j) {
        System.out.println(i + j);
        System.out.println("a");
    }

    public void getSum(double i,double j){
        System.out.println(i + j);
        System.out.println("b");
    }

    public void getSum(int i, String j) {
        System.out.println(i + j);
        System.out.println("c");
    }

    public void getSum(String i, int j) {
        System.out.println(i + j);
        System.out.println("d");
    }

}
