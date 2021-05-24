import java.util.Scanner;

/**
 * @Date : 2020/2/10  20:11
 * @Author: Halo
 * @File : CircleArea
 * @Version : v1.0
 * @Description: 计算圆面积
 **/
public class CircleArea {
    public static void main(String[] args) {
        //实例化
        Circle circle = new Circle();
        //输入半径
        Scanner scanner = new Scanner(System.in);
        circle.r = scanner.nextDouble();
        //调用方法
        double area = circle.area();
        //打印结果
        System.out.println("area = " + area);

    }

}

class Circle {
    double r;

    //计算面积

    public double area() {
        double area = Math.PI * r * r;
        return area;
    }
}
