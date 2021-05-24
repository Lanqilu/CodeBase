/**
 * @Date 2020/1/15 - 下午 5:30
 * @Author : Halo
 * @File : Sum
**/

// 计算前N个自然数的和
public class Sum {

    int n = 100;

    public void method1(){  // 公式法
        int sum = (int) ((n+1)*n*0.5);
        System.out.println(sum);
    }

    public void method2(){  // for循环
        int sum = 0;
        for(int i= 1; i<=n; i++){ //初始条件; 循环检测条件; 循环后更新计数器
            sum = sum +i;
        }
        System.out.println(sum);
    }

    public void  method3(){  // while循环
        int sum = 0;
        int i= 1;
        while (i<=n){
            sum = sum +i;
            i++;
        }
        System.out.println(sum);

    }

//    public static void main(String[] args) {
//        var S = new Sum();
//        S.method1();
//        S.method2();
//        S.method3();
//    }
}
