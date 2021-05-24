package queue;

import java.util.Scanner;

/**
 * @Date : 2020/2/1  18:05
 * @Author: Halo
 * @File : ArrayQueue
 * @Description: 数组模拟队列
 **/
public class ArrayQueueDemo {
    public static void main(String[] args) {
        //测试
        //创建队列
        ArrayQueue queue = new ArrayQueue(3);
        char key = ' ';//接收用户输入
        Scanner scanner = new Scanner(System.in);
        // 创建循环
        boolean loop = true;
        while (loop) {
            System.out.println("s(show)：显示队列");
            System.out.println("e(exit)：退出程序");
            System.out.println("a(add)：添加数据到队列");
            System.out.println("g(get)：从队列取出数据");
            System.out.println("h(head)：查看队列头部数据");
            key = scanner.next().charAt(0);//接收一个字符
            switch (key){
                case 's':
                    queue.showQueue();
                    break;
                case 'a'://添加数据到队列
                    System.out.print("请输入一个数:");
                    int value = scanner.nextInt();
                    queue.addQueue(value);
                    break;
                case 'g'://队列取出数据
                    try{
                        int res = queue.getQueue();
                        System.out.printf("取出的数据是%d\n",res);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try{
                        int res = queue.headQueue();
                        System.out.printf("队列头的数据是:%d\n",res);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e':
                    scanner.close();
                    loop = false;
                    break;
                default:
                    break;
            }
        }
        System.out.println("程序退出");

    }
}


//编写一个数组模拟队列
class ArrayQueue {
    private int maxSize;//数组的最大容量
    private int front;//指向队列头
    private int rear;//指向队列尾部
    private int[] arr;//模拟队列的数组

    //创建队列的构造器
    public ArrayQueue(int arrMaxSize) {
        maxSize = arrMaxSize;
        arr = new int[maxSize];
        this.front = -1;//队列头的前一个位置
        rear = -1;//包含队列尾，队列的最后一个数据
    }

    //判断队列是否满
    public boolean isFull() {
        return rear == maxSize - 1;
    }

    //判断队列是否为空
    public boolean isEmpty() {
        return rear == front;
    }

    //数据进队列
    public void addQueue(int n) {
        //判断队列是否满
        if (isFull()) {
            System.out.println("队列已满");
            return;
        }

        rear++;//rear后移
        arr[rear] = n;
    }

    //数据出队列
    public int getQueue() {
        //判断队列是否为空
        if (isEmpty()) {
            throw new RuntimeException("队列为空");
        }

        front++;
        return arr[front];
    }

    //显示队列的所有数据
    public void showQueue() {
        //遍历
        if (isEmpty()) {
            System.out.println("队列为空");
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.printf("arr[%d]=%d\n", i, arr[i]);
        }
    }

    //显示队列的头数据
    public int headQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空");
        }
        return arr[front + 1];

    }

    //存在问题
    //不是环形队列，只能使用一次
}
