package templates;

/**
 * @Date : 2020/2/10  16:19
 * @Author: Halo
 * @File : Array
 * @Version : v1.0
 * @Description: 数组遍历有关模板
 **/
public class Array {
    public static void main(String[] args) {

        //fori
        int[] arr = {1, 2, 3, 5, 76, 7};
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
        //iter
        for (int i : arr) {
            System.out.println(i);
        }
        //itar
        for (int i = 0; i < arr.length; i++) {
            int i1 = arr[i];

        }

    }
}
