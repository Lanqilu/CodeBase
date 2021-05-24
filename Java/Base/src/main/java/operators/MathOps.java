package operators;

import java.util.Random;

/**
 * @Date : 2020/1/31  16:29
 * @Author: Halo
 * @File : MathOps
 * @Description: Java的基本算术运算符
 **/

//数学运算
public class MathOps {
    public static void main(String[] args) {
//        创建一个随机数
        Random rand = new Random(47);//写右边快捷键Ctrl+Alt+V
        int i, j, k;
//        变量j赋值
        j = rand.nextInt(100) + 1;
        System.out.println("j:" + j);
//        变量k赋值
        k = rand.nextInt(100) + 1;
        System.out.println("k:" + k);

        i = j + k;
        System.out.println("j + k:" + i);

        i = j - k;
        System.out.println("j - k : " + i);

        i = k / j;
        System.out.println("k / j : " + i);

        i = k * j;
        System.out.println("k * j : " + i);

        i = k % j;
        System.out.println("k % j : " + i);

        j %= k;
        System.out.println("j %= k : " + j);

        // 浮点运算测试
        float u, v, w; // Applies to doubles, too
//        变量v赋值
        v = rand.nextFloat();
        System.out.println("v : " + v);
//        变量w赋值
        w = rand.nextFloat();
        System.out.println("w : " + w);

        u = v + w;
        System.out.println("v + w : " + u);

        u = v - w;
        System.out.println("v - w : " + u);

        u = v * w;
        System.out.println("v * w : " + u);

        u = v / w;
        System.out.println("v / w : " + u);

        // 下面的操作同样适用于 char, byte, short, int, long, and double:
        u += v;
        System.out.println("u += v : " + u);

        u -= v;
        System.out.println("u -= v : " + u);

        u *= v;
        System.out.println("u *= v : " + u);

        u /= v;
        System.out.println("u /= v : " + u);
    }
}


