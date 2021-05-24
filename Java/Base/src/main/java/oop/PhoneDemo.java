package oop;

/**
 * @Date : 2020/2/13  18:01
 * @Author: Halo
 * @File : PhoneDemo
 * @Version : v1.0
 * @Description: 匿名对象
 **/
public class PhoneDemo {
    public static void main(String[] args) {
        Phone p = new Phone();
        p.sendEmail();
        p.watchVideo();

        System.out.println("**********");
        //匿名对象(一次性)
        new Phone().price=1999;
        new Phone().showPrice();

        System.out.println("**********");
        //匿名对象的使用
        Mall mall = new Mall();
        mall.showInfo(new Phone());
    }
}

class Mall{
    public void showInfo(Phone phone){
        phone.sendEmail();
        phone.watchVideo();
    }
}
class Phone {
    double price;

    public void sendEmail() {
        System.out.println("发送邮件");
    }

    public void watchVideo() {
        System.out.println("看视频");
    }

    public void showPrice() {
        System.out.println("手机价格为" + price);
    }

}
