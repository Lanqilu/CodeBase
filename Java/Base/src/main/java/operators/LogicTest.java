package operators;

/**
 * @Date : 2020/2/6  19:04
 * @Author: Halo
 * @File : LogicTest
 * @Description: 逻辑运算符练习
 **/
public class LogicTest {
    public static void main(String[] args) {
        //练习1
        int x1 = 1;
        int y1 = 1;
        if (x1++ == 2 & ++y1 == 2) {
            x1 = 3;
        }
        System.out.println("x:" + x1 + '\t' + "y:" + y1);//x:2	y:2

        //练习2
        int x2 = 1;
        int y2 = 1;
        if (x2++ == 2 && ++y2 == 2) {
            x2 = 3;
        }
        System.out.println("x:" + x2 + '\t' + "y:" + y2);//x:2	y:1

        //练习3
        int x3 = 1;
        int y3 = 1;
        if (x3++ == 1 | ++y3 == 1) {
            x3 = 3;
        }
        System.out.println("x:" + x3 + '\t' + "y:" + y3);//x:3	y:2

        //练习4
        int x4 = 1;
        int y4 = 1;
        if (x4++ == 1 || ++y4 == 1) {
            x4 = 3;
        }
        System.out.println("x:" + x4 + '\t' + "y:" + y4);//x:3	y:1

        //练习5
        boolean x5 = true;
        boolean y5 = false;
        short z = 42;
        if ((z++ == 42) && (y5 = true)) {
            z++;
        }
        if ((x5 == false) || (++z == 45)) {
            z++;
        }
        System.out.println("z:" + z);

    }

}
