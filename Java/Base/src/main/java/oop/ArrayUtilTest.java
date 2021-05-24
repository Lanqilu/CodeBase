package oop;

/**
 * @Date : 2020/2/13  18:55
 * @Author: Halo
 * @File : ArrayUtilTest
 * @Version : v1.0
 * @Description: 自定义数组工具测试
 **/
public class ArrayUtilTest {
    public static void main(String[] args) {
        ArrayUtil test = new ArrayUtil();
        int[] arr = new int[]{32, 34, 435, 65, 3, 297, 243};
        System.out.println("test.getMax(arr) = " + test.getMax(arr));
        test.print(arr);
    }
}
