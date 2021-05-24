package thread;

/**
 * @Date : 2020/2/13  21:09
 * @Author: Halo
 * @File : ThreadTest
 * @Version : v1.0
 * @Description: 多线程创建
 **/

/*  1. 创建一个继承与Thread类的子类
    2. 重写Thread类的run()方法
    3. 创建Thread类的子类的对象
    4. 通过此对象调用start()*/

public class CreateThread {

    public static void main(String[] args) {
        //3.创建Thread类的子类的对象
        MyThread t1 = new MyThread();
        //通过此对象调用start()
        t1.start();//线程开始执行或调用当前线程的run()方法
//        t1.run();//直接调用run()方法是单线程

        //获取当前线程的名字
        System.out.println("Thread.currentThread().getName() = " + Thread.currentThread().getName());

        System.out.println("hello");//hello先输出

        //再创建线程
//        t1.start();//报错:IllegalThreadStateException
        //重新创建一个线程对象
        MyThread t2 = new MyThread();
        t2.start();
    }
}

//1.创建一个继承与Thread类的子类
class MyThread extends Thread {
    //2.重写Thread类的run()方法
    //将此线程的操作声明在run()中

    @Override// run+Enter快捷方式
    public void run() {
        //获取当前线程的名字
        System.out.println("Thread.currentThread().getName() = " + Thread.currentThread().getName());
        for (int i = 0; i < 50; i++) {
            if (i % 2 == 0) {
                System.out.println("i = " + i);
            }
        }
    }
}
