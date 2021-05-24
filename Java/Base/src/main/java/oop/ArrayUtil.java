package oop;

/**
 * @Date : 2020/2/13  18:49
 * @Author:
 * @File : ArrayUtil
 * @Version : v1.0
 * @Description: 自定义数组工具类
 **/
public class ArrayUtil {

    //求数组的最大值
    public int getMax(int[] arr){
        int maxValue = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (maxValue < arr[i]) {
                maxValue = arr[i];
            }
        }
        return maxValue;
    }

    //求最小值
    public int getMin(int[] arr){
        int minValue = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (minValue > arr[i]) {
                minValue = arr[i];
            }
        }
        return minValue;
    }

    //求平均值
    public int getAvg(int[] arr){
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        int avgValue = sum / arr.length;
        return avgValue;
    }

    //反转数组
    public void reverse(int[] arr){
    }
    //复制数组
    public int[] copy(int[] arr){
        return null;
    }



    //遍历数组
    public void print(int[] arr){
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            if (i == arr.length - 1) {
                System.out.println(arr[i] + "]");
            }
            else {
                System.out.print(arr[i] + ",");

            }
        }

    }


    //数组排序
    public void sort(int[] arr){
    }

    //查找指定数组
    public int getIndex(int[] arr,int dest){
        return 0;
    }
}
