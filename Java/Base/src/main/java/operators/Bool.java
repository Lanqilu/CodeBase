
import java.util.Random;

/**
 * @Date : 2020/1/31  17:03
 * @Author: Halo
 * @File : Bool
 * @Description: 关系运算符和逻辑运算符
 **/


public class Bool {
    public static void main(String[] args) {
        Random rand = new Random(47);
        int i = rand.nextInt(100);
        int j = rand.nextInt(100);
        System.out.println("i = " + i);
        System.out.println("j = " + j);
        System.out.println("i > j is " + (i > j));
        System.out.println("i < j is " + (i < j));
        System.out.println("i >= j is " + (i >= j));
        System.out.println("i <= j is " + (i <= j));
        System.out.println("i == j is " + (i == j));
        System.out.println("i != j is " + (i != j));
        // 将 int 作为布尔处理不是合法的 Java 写法
        //- System.out.println("i && j is " + (i && j));
        //- System.out.println("i || j is " + (i || j));
        //- System.out.println("!i is " + !i);

//        逻辑运算符 &&(AND),||(OR),!(NOT)根据参数的逻辑关系生成布尔值 true 或 false
        System.out.println("(i < 10) && (j < 10) is "
                + ((i < 10) && (j < 10)) );
        System.out.println("(i < 10) || (j < 10) is "
                + ((i < 10) || (j < 10)) );
    }
}
