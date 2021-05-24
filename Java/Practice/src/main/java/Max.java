import java.util.Scanner;

/**
 * @Date 2020/1/19 - 下午 5:15
 * @Author : Halo
 * @File : Max
 **/

// 要求
// 用户输入一系列值，使用一常量作为终止，输出这些值中的最大值
public class Max {
    public int quit=0;

    public void in(){
        Scanner input = new Scanner(System.in);
        System.out.println("用户输入一系列值，使用一常量作为终止，输出这些值中的最大值");
        System.out.println("输入"+quit+"结束程序");
        int max = 0;
        int i = input.nextInt();
        while(i!=quit){
            if(i>max){
                max = i;
            }
            i = input.nextInt();
        }
        System.out.println("最大的数是:"+max);

    }

    public static void main(String[] args) {
        new Max().in();
    }

}
