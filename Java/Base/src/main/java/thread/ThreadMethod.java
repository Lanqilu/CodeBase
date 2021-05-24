package thread;

/**
 * @Date : 2020/2/13  21:50
 * @Author: Halo
 * @File : ThreadMethod
 * @Version : v1.0
 * @Description: Thread中常用方法
 **/

/*
* getPriority() 获取线程优先级
* setPriority() 改变线程优先级
*   MAX_PRIORITY --> 10
*   MIN_PRIORITY --> 1
*   NORM_PRIORITY --> 5
* setName()     设置线程名
* sleep()       睡眠指定时间
* join()        阻塞
* isAlive()     查看线程状态
* yield()       释放当前CPU的使用权
* */

public class ThreadMethod {
    public static void main(String[] args) {
        thread t1 = new thread("0");
        t1.setName("A");//设置线程名
        t1.start();

        System.out.println("t1.isAlive() = " + t1.isAlive());

        //主线程命名
        Thread.currentThread().setName("主线程");
        //获取线程名称
        System.out.println("Thread.currentThread().getName() = " + Thread.currentThread().getName());
        //获取线程优先级
        System.out.println("Thread.currentThread().getPriority() = " + Thread.currentThread().getPriority());
        //改变线程优先级
        Thread.currentThread().setPriority(Thread.MAX_PRIORITY);
        System.out.println("Thread.currentThread().getPriority() = " + Thread.currentThread().getPriority());

        for (int i = 0; i < 100; i++) {
//            try {
//                //睡眠指定时间
//                Thread.currentThread().sleep(1000);
//            }
//            catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            if (i % 2 == 0) {

                System.out.println(Thread.currentThread().getName() + "：i = " + i);
            }
            if (i == 20) {
                try {
                    //阻塞直到其他线程完成
                    t1.join();
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println("t1.isAlive() = " + t1.isAlive());
    }
}

class thread extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 != 0) {
                System.out.println(Thread.currentThread().getName() + "：i = " + i);
            }
            if (i % 10 == 0) {
                //释放当前CPU的使用权
                Thread.currentThread().yield();
            }
        }
    }

    //通过构造器对线程命名
    public thread(String name) {
        super(name);
    }
}

