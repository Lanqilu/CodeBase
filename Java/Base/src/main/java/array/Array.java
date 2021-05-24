package array;

/**
 * @Date : 2020/2/9  15:42
 * @Author: Halo
 * @Version : v1.0
 * @Description: 一维数组的使用
 **/

/*
 * 一、数组的概述
 * 1.数组的理解：数组(Array)，是多个相同类型数据按一定顺序排列的集合，并使用一个名字命名，
 * 并通过编号的方式对这些数据进行统一管理。
 *
 * 2.数组相关的概念：
 * >数组名
 * >元素
 * >索引
 * >数组的长度：元素的个数
 *
 * 3.数组的特点：
 * 1）数组是有序排列的
 * 2）数组属于引用数据类型的变量。数组的元素，既可以是基本数据类型，也可以是引用数据类型
 * 3）创建数组对象会在内存中开辟一整块连续的空间
 * 4）数组的长度一旦确定，就不能修改。
 *
 * 4. 数组的分类：
 *   ① 按照维数：一维数组、二维数组、。。。
 *   ② 按照数组元素的类型：基本数据类型元素的数组、引用数据类型元素的数组
 *
 * 5. 一维数组的使用
 *   ① 一维数组的声明和初始化
 *   ② 如何调用数组的指定位置的元素
 *   ③ 如何获取数组的长度
 *   ④ 如何遍历数组
 *   ⑤ 数组元素的默认初始化值 ：见ArrayTest1.java
 *   ⑥ 数组的内存解析 ：见ArrayTest1.java
 */

public class Array {
    public static void main(String[] args) {

        //1. 一维数组的声明和初始化
        int[] ids;//声明
        //1.1 静态初始化:数组的初始化和数组元素的赋值操作同时进行
        ids = new int[]{1001, 1002, 1003, 1004};
        //1.2动态初始化:数组的初始化和数组元素的赋值操作分开进行
        String[] names = new String[5];
        //也是正确的写法：
        int[] array = {1, 2, 3, 4, 5};//类型推断
        //总结：数组一旦初始化完成，其长度就确定了。

        //2.如何调用数组的指定位置的元素:通过索引的方式调用。
        //数组的角标（或索引）从0开始的，到数组的长度-1结束。
        names[0] = "小明";
        names[1] = "李华";
        names[2] = "小红";
        names[3] = "小王";
        names[4] = "小张";
//		names[5] = "小丽";

        //3.获取数组的长度
        System.out.println(names.length);
        System.out.println(ids.length);

        //4.遍历数组
        for (int i = 0; i < names.length; i++) {
            System.out.println(names[i]);
        }
        //5.数组元素的默认初始化值
//		数组元素是整型：0
//		数组元素是浮点型：0.0
//		数组元素是char型：0或'\u0000'，而非'0'
//		数组元素是boolean型：false
//		数组元素是引用数据类型：null
        int[] arr = new int[4];
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
        System.out.println("**********");

        short[] arr1 = new short[4];
        for (int i = 0; i < arr1.length; i++) {
            System.out.println(arr1[i]);
        }
        System.out.println("**********");
        float[] arr2 = new float[5];
        for (int i = 0; i < arr2.length; i++) {
            System.out.println(arr2[i]);
        }

        System.out.println("**********");
        char[] arr3 = new char[4];
        for (int i = 0; i < arr3.length; i++) {
            System.out.println("----" + arr3[i] + "****");
        }

        System.out.println("**********");
        boolean[] arr4 = new boolean[5];
        System.out.println(arr4[0]);

        System.out.println("**********");
        String[] arr5 = new String[5];
        System.out.println(arr5[0]);
    }
}

