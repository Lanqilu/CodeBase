package operators;

/**
 * @Date : 2020/1/31  16:56
 * @Author: Halo
 * @File : Equivalence
 * @Description: 测试对象等价
 **/
public class Equivalence {

    public static void main(String[] args) {
        Integer n1 = 47;
        Integer n2 = 47;
        System.out.println(n1 == n2);//true
        System.out.println(n1 != n2);//false
        System.out.println(n1.equals(n2));

    }
}
