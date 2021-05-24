package control;

/**
 * @Date : 2020/1/31  17:13
 * @Author: Halo
 * @File : IfElse
 * @Description: if-else 语句
 **/
// control/IfElse.java
public class IfElse {
    static int result = 0;

    static void test(int testval, int target) {
        if (testval > target) {
            result = +1;
        }
        else if (testval < target) // [1]
        {
            result = -1;
        }
        else {
            result = 0; // Match
        }
    }

    public static void main(String[] args) {
        test(10, 5);
        System.out.println(result);//1
        test(5, 10);
        System.out.println(result);//-1
        test(5, 5);
        System.out.println(result);//0
    }
}

