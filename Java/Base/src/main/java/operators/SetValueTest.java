package operators;

/**
 * @Date : 2020/2/6  17:06
 * @Author: Halo
 * @File : SetValue
 * @Description: 赋值运算符(=, + =, - =, * =, / =, % =)
 **/
public class SetValueTest {
    public static void main(String[] args) {
        //赋值的方式一
        int i1 = 10;
        int i2 = 20;
        //赋值的方式二：连续赋值
        int j2, j3;
        j2 = j3 = 10;
        //赋值的方式三
        int i3 = 10, i4 = 10;

        //+= , -= , *= , /= , %= (不会改变数据类型)
        int num1 = 10;
        num1 += 2;//num1 = num1 + 2
        System.out.println(num1);//12

        //特殊情况
        short s1 = 10;
//        s1 = s1 +2;//编译失败
        s1 += 2;//不会改变变量本身的数据类型
        System.out.println(s1);//12

        int i = 1;
        i *= 0.1;//
        System.out.println(i);//0
        i++;
        System.out.println(i);//1

        int m = 2;
        int n = 3;
        n *= m++;
        System.out.println(m);//3
        System.out.println(n);//6

        int m2 = 2;
        int n2 = 3;
        n2 *= ++m2;
        System.out.println(n2);//9

        int n3 = 10;
        n3 += (n3++) + (++n3);//n3 = n3 + (n3++) + (++n3)
        System.out.println(n3);//32
    }
}
