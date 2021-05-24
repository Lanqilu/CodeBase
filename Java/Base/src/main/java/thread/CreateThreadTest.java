package thread;

/**
 * @Date : 2020/2/13  21:38
 * @Author: Halo
 * @File : CreateThreadTest
 * @Version : v1.0
 * @Description: 创建两个线程一个遍历偶数一个遍历奇数
 **/
public class CreateThreadTest {
    public static void main(String[] args) {
        evenThread t1 = new evenThread();
        oddThread t2 = new oddThread();
        t1.start();
        t2.start();

        //简便方式:匿名子类
        new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    if (i % 2 == 0) {
                        System.out.println(Thread.currentThread().getName() + "：i = " + i);
                    }
                }
            }
        }.start();
    }
}

//遍历偶数
class evenThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + "：i = " + i);
            }
        }
    }
}

//遍历奇数
class oddThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 != 0) {
                System.out.println(Thread.currentThread().getName() + "：i = " + i);
            }
        }
    }
}

