package operators;

/**
 * @Date 2020/1/15 - 下午 4:53
 * @Author : Halo
 * @File : Operation
 **/
public class Operation {  // 运算
    public void arithmetic(){
        int i = (100 + 200) * (99 - 88); // 3300
        int n = 7 * (5 + (i - 9)); // 23072
        System.out.println(i);
        System.out.println(n);
    }

    public void increment_decrement(){  // 自增;自减
        int n = 3300;
        n++; // 3301, 相当于 n = n + 1;
        System.out.println(n);
        n--; // 3300, 相当于 n = n - 1;
        System.out.println(n);
        int y = 100 + (++n); // 不要这么写
        System.out.println(y);
    }

    public void shift_operation(){  // 移位运算
        int n = 7;       // 00000000 00000000 00000000 00000111 = 7
        int a = n << 1;  // 00000000 00000000 00000000 00001110 = 14
        int b = n << 2;  // 00000000 00000000 00000000 00011100 = 28
        int c = n << 28; // 01110000 00000000 00000000 00000000 = 1879048192
        int d = n << 29; // 11100000 00000000 00000000 00000000 = -536870912

        int m = -536870912;
        int e = m >> 1;  // 11110000 00000000 00000000 00000000 = -268435456
        int f = m >> 2;  // 10111000 00000000 00000000 00000000 = -134217728
        int g = m >> 28; // 11111111 11111111 11111111 11111110 = -2
        int h = m >> 29; // 11111111 11111111 11111111 11111111 = -1
//        int n = -536870912;
//        int a = n >>> 1;  // 01110000 00000000 00000000 00000000 = 1879048192
//        int b = n >>> 2;  // 00111000 00000000 00000000 00000000 = 939524096
//        int c = n >>> 29; // 00000000 00000000 00000000 00000111 = 7
//        int d = n >>> 31; // 00000000 00000000 00000000 00000001 = 1
    }


//    public static void main(String[] args) {
//        var op = new Operation();
//        op.arithmetic();
//        op.increment_decrement();
//    }
}
