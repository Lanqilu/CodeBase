package operators;

/**
 * @Date : 2020/2/6  17:38
 * @Author: Halo
 * @File : CompareTest
 * @Description: 比较运算符: ==
 **/
public class CompareTest {
    public static void main(String[] args) {
        int i = 10;
        int j = 20;
        System.out.println(i == j);//false
        System.out.println(j = i);//10

        boolean a = false;
        boolean b = true;
        System.out.println(a == b);//false
        System.out.println(a = b);//true
    }
}
