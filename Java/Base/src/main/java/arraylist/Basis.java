package arraylist;

import java.util.ArrayList;

/**
 * @Date : 2020/2/10  17:42
 * @Author: Halo
 * @File : Basis
 * @Version : v1.0
 * @Description: ArrayList基础操作
 **/
public class Basis {
    public static void main(String[] args) {
        //创建
        ArrayList<Integer> ints = new ArrayList<Integer>();
        //添加
        ints.add(2);
        ints.add(3);
        ints.add(4);
        ints.add(5);
        ints.add(6);
        ints.add(0, 1);
        //遍历
        for (int i = 0; i < ints.size(); i++) {
            System.out.printf("ints.get(%d) = %d", i, ints.get(i));
            System.out.println();

        }
        //返回元素数量
        System.out.println("ints.size = " + ints.size());
        //返回指定索引对应元素
        System.out.println("ints.get(1) = " + ints.get(1));
        //


    }
}
