package operators;

/**
 * @Date : 2020/1/31  16:59
 * @Author: Halo
 * @File : EqualsMethod
 * @Description: equals() 方法
 **/
class Value{
    int i;
}

public class EqualsMethod {
    public static void main(String[] args) {
        Value v1 = new Value();
        Value v2 = new Value();
        v1.i = v2.i = 100;
        System.out.println(v1.equals(v2));//false
//        原因:equals()的默认行为是比较对象的引用而非具体内容。

    }
}
