package operators;

/**
 * @Date : 2020/1/30  18:57
 * @Author: Halo
 * @File : Assignment
 * @Description: 对象赋值实际上操作的是它的引用
 **/

class Tank {
    int level;
}

public class Assignment {

    public static void main(String[] args) {
        Tank t1 = new Tank();
        Tank t2 = new Tank();
        t1.level = 9;
        t2.level = 47;
        System.out.println("1: t1.level: " + t1.level +
                ", t2.level: " + t2.level);

        //t1 原始对象的引用在 t2 赋值给其时丢失，它引用的对象会在垃圾回收时被清理
        t1 = t2; //t1 和 t2 此时指向的是堆中同一个对象,这种现象通常称为别名（aliasing）

//        t1.level = t2.level; //不想出现这里的别名引起混淆的话，你可以这么做

        System.out.println("2: t1.level: " + t1.level +
                ", t2.level: " + t2.level);
        t1.level = 27;
        System.out.println("3: t1.level: " + t1.level +
                ", t2.level: " + t2.level);
    }
}
