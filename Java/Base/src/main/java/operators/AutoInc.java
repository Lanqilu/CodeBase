package operators;

/**
 * @Date : 2020/1/31  16:54
 * @Author: Halo
 * @File : AutoInc
 * @Description: 演示 ++ 和 -- 运算符
 **/
public class AutoInc {
    public static void main(String[] args) {
        int i = 1;
        System.out.println("i:" + i);

//        对于前缀形式，我们将在执行递增/减操作后获取值；
        System.out.println("++i: " + ++i); // 前递增
//        使用后缀形式，我们将在执行递增/减操作之前获取值
        System.out.println("i++: " + i++); // 后递增
        System.out.println("i: " + i);

        System.out.println("--i: " + --i); // 前递减
        System.out.println("i--: " + i--); // 后递减
        System.out.println("i: " + i);
    }
}
