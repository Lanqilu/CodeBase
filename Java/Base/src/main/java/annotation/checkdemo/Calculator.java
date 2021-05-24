package annotation.checkdemo;

/**
 * @Date: 2020年02月23日  12:22
 * @Description: 计算类, 被检测类
 **/
public class Calculator {
    @Check
    public void add() {
        System.out.println("1+1=" + (1 + 1));
        String str = null;
        str.toString();
    }

    @Check
    public void div() {
        System.out.println("1/0" + (1 / 0));
    }
}
