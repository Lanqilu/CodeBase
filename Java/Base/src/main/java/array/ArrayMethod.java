package array;

import java.util.Arrays;

/**
 * @Date : 2020/2/10  18:12
 * @Author: Halo
 * @File : ArrayMethod
 * @Version : v1.0
 * @Description: 数组有关方法
 **/
public class ArrayMethod {
    public static void main(String[] args) {
        //equals 判断两数组是否相等
        int[] arr1 = {1, 2, 3, 4};
        int[] arr2 = {1, 3, 2, 4};
        boolean isEquals = Arrays.equals(arr1, arr2);
        System.out.println("isEquals = " + isEquals);

        //toString 输出数组信息
        System.out.println("Arrays.toString(arr1) = " + Arrays.toString(arr1));

        //fill 填充数组
        Arrays.fill(arr1, 10);
        System.out.println("Arrays.toString(arr1) = " + Arrays.toString(arr1));

        //sort 排序
        System.out.println("Arrays.toString(arr2) = " + Arrays.toString(arr2));
        Arrays.sort(arr2);
        System.out.println("Arrays.toString(arr2) = " + Arrays.toString(arr2));

        //binarySearch 二分查找
        int[] arr3 = {34, 357, 357, 875, -234, 765, 54};
        Arrays.sort(arr3);
        System.out.println("Arrays.toString(arr3) = " + Arrays.toString(arr3));
        int index = Arrays.binarySearch(arr3, 875);
        System.out.println("index = " + index);
        index = Arrays.binarySearch(arr3, 0);
        System.out.println("index = " + index);

    }
}
