package variable;

/**
 * @Date 2020/1/15 - 下午 4:29
 * @Author : Halo
 * @File : variable.Variable
 **/


public class Variable {  // 变量
    public void definition(){   // 定义变量
        int x = 100; // 定义int类型变量x，并赋予初始值100
        System.out.println(x); // 打印该变量的值
    }

    public void reassign(){  // 变量重新赋值
        int x = 100; // 定义int类型变量x，并赋予初始值100
        System.out.println(x); // 打印该变量的值，观察是否为100
        x = 200; // 重新赋值为200
        System.out.println(x); // 打印该变量的值，观察是否为200
    }

    public void Assignment_between_variables(){
        int n = 100; // 定义变量n，同时赋值为100
        System.out.println("定义变量n，同时赋值为100");
        System.out.println("n = " + n); // 打印n的值

        n = 200; // 变量n赋值为200
        System.out.println("变量n赋值为200");
        System.out.println("n = " + n); // 打印n的值

        int x = n; // 变量x赋值为n（n的值为200，因此赋值后x的值也是200）
        System.out.println("变量x赋值为n");
        System.out.println("x = " + x); // 打印x的值

        x = x + 100; // 变量x赋值为x+100（x的值为200，因此赋值后x的值是200+100=300）
        System.out.println("变量x赋值为x+100（x的值为200，因此赋值后x的值是200+100=300）");
        System.out.println("x = " + x); // 打印x的值
        System.out.println("n = " + n); // 再次打印n的值，n应该是200还是300？
    }


    public void integer(){  // 整数
        int i = 2147483647;  // 最大
        int i2 = -2147483648;
        int i3 = 2_000_000_000; // 加下划线更容易识别
        int i4 = 0xff0000; // 十六进制表示的16711680
        int i5 = 0b1000000000; // 二进制表示的512
        long l = 9000000000000000000L; // long型的结尾需要加L
    }

    public void float_(){  // 浮点数
        float f1 = 3.14f;
        float f2 = 3.14e38f; // 最大,科学计数法表示的3.14x10^38
        double d = 1.79e308; // 最大
        double d2 = -1.79e308;
        double d3 = 4.9e-324; // 科学计数法表示的4.9x10^-324
    }

    public void bool(){  // 布尔
        boolean b1 = true;
        boolean b2 = false;
        boolean isGreater = 5 > 3; // 计算结果为true
        int age = 12;
        boolean isAdult = age >= 18; // 计算结果为false
    }

    public void string(){  // 字符串
        char a = 'A'; //注意char类型使用单引号'
        char zh = '1';
        System.out.println(a);
        System.out.println(zh);
    }

    public void constant(){  //常量
// 常量在定义时进行初始化后就不可再次赋值，再次赋值会导致编译错误。
        final double PI = 3.14; // PI是一个常量
        double r = 5.0;
        double area = PI * r * r;
    }


    // Main Program
//    public static void main(String[] args) {
//        var va = new variable.Variable();  // var关键字
//        System.out.println("定义变量 Integer");
//        va.definition();
//        System.out.println("重新赋值 Reassign");
//        va.reassign();
//        System.out.println("变量间赋值 Assignment_between_variables");
//        va.Assignment_between_variables();
//    }
}
