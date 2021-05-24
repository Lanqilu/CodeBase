package src.operators;

/**
 * @Date : 2020/1/30  19:10
 * @Author: Halo
 * @File : PassObject
 * @Description: 正在传递的对象可能不是你之前使用的
 **/

//当我们把对象传递给方法时，会发生别名现象。
class Letter {
    char c; //char数据类型可以储存任何字符
}

public class PassObject {
    static void f(Letter y) {
        y.c = 'z';
    }

    public static void main(String[] args) {
        Letter x = new Letter();
        x.c = 'a';
        System.out.println("1: x.c: " + x.c);
        f(x);
        System.out.println("2: x.c: " + x.c);
    }
}

/*
Output:
1: x.c: a
2: x.c: z
*/
