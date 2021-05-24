package operators;

/**
 * @Date : 2020/1/30  18:51
 * @Author: Halo
 * @File : Precedence
 **/

public class Precedence {
    public static void main(String[] args) {
        int x = 1, y = 2, z = 3;
        int a = x + y - 2/2 + z;           // 先运算除法
        int b = x + (y - 2)/(2 + z);       // 先运算括号内
        System.out.println("a = " + a);
        System.out.println("b = " + b);
    }
}

/*
Output:
a = 5
b = 1
*/
