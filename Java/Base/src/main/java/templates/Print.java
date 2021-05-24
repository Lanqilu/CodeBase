package templates;

import java.util.Arrays;

/**
 * @Date : 2020/2/10  16:02
 * @Author: Halo
 * @File : Template
 * @Version : v1.0
 * @Description: 打印有关模板
 **/
public class Print {
    //prsf
//    private static final

    //psf
//    public static final

    //psfi
//    public static final int

    //psfs
//    public static final String


    //psvm
    public static void main(String[] args) {

        //sout
        System.out.println();
        //soutp 打印形参
        System.out.println("args = " + Arrays.deepToString(args));
        //soutv 打印变量值
        int a = 10;
        System.out.println("a = " + a);//就近选择
        //xxx.soutv
        System.out.println("a = " + a);
        //soutm 打印方法名
        System.out.println("Template.main");

    }


}
