package string;

/**
 * @Date : 2020/2/19  18:59
 * @Author: Halo
 * @File : test
 * @Version : v1.0
 * @Description: 一道题
 **/
public class Test {
    String str = new String("good");
    char[] ch = { 't', 'e', 's', 't' };

    public void change(String str, char ch[]) {
        str = "test ok";
        ch[0] = 'b';
    }
    public static void main(String[] args) {
        Test ex = new Test();
        ex.change(ex.str, ex.ch);
        System.out.println(ex.str);//good
        System.out.println(ex.ch);//best
    }
}
