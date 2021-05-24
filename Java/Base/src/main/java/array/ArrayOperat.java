package array;

/**
 * @Date : 2020/2/9  16:51
 * @Author: Halo
 * @File : ArrayMethod
 * @Version : v1.0
 * @Description: 数值型数组中元素的最大值、最小值、平均数、总和
 **/

/*
 * 定义一个int型的一维数组，包含10个元素，分别赋一些随机整数，
 * 然后求出所有元素的最大值，最小值，和值，平均值，并输出出来。
 * 要求：所有随机数都是两位数。
 *
 * [10,99]
 * 公式：(int)(Math.random() * (99 - 10 + 1) + 10)
 */

public class ArrayOperat {
    public static void main(String[] args) {
        int[] arr = new int[10];

        //赋值
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * (99 - 10 + 1) + 10);
        }

        //遍历
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            if (i == arr.length - 1) {
                System.out.println(arr[i] + "]");
            }
            else {
                System.out.print(arr[i] + ",");

            }
        }

        //最大值
        int maxValue = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (maxValue < arr[i]) {
                maxValue = arr[i];
            }
        }
        System.out.println("maxValue =" + maxValue);

        //最小值
        int minValue = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (minValue > arr[i]) {
                minValue = arr[i];
            }
        }
        System.out.println("minValue =" + minValue);

        //求元素的总和
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        System.out.println("sum =" + sum);

        //求平均数
        int avgValue = sum / arr.length;
        System.out.println("avgValue =" + avgValue);

    }
}
