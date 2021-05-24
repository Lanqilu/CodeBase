import java.util.Scanner;

/**
 * @Date 2020/1/15 - 下午 4:13
 * @Author : Halo
 * @File : ProgramStructure
 **/
public class AddThreeIntegers {  // 类定义

    public void run(){
        Scanner sysin = new Scanner(System.in);
        System.out.println("This program adds three integers.");
        System.out.print("1st integer:");
        int n1 = sysin.nextInt();  // 变量
        System.out.println("This program adds three integers.");
        System.out.print("2nd integer:");
        int n2 = sysin.nextInt();
        System.out.println("This program adds three integers.");
        System.out.print("3rd integer:");
        int n3 = sysin.nextInt();
        int sum = n1+n2+n3;
        System.out.println("The sum is "+sum);
    }

// Main program

    public static void main(String[] args) {
        new AddThreeIntegers().run();
    }
}
