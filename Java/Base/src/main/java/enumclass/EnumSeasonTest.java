package enumclass;

/**
 * @Date : 2020/2/20  15:31
 * @Author: Halo
 * @File : EnumSeasonTest
 * @Version : v1.0
 * @Description: 使用enum定义枚举类
 **/

/*
 * 三、Enum类中的常用方法：
 *    values()方法：返回枚举类型的对象数组。该方法可以很方便地遍历所有的枚举值。
 *    valueOf(String str)：可以把一个字符串转为对应的枚举类对象。要求字符串必须是枚举类对象的“名字”。
 *                         如不是，会有运行时异常：IllegalArgumentException。
 *    toString()：返回当前枚举类对象常量的名称
 *
 * 四、使用enum关键字定义的枚举类实现接口的情况
 *   情况一：实现接口，在enum类中实现抽象方法
 *   情况二：让枚举类的对象分别实现接口中的抽象方法
 * */

public class EnumSeasonTest {
    public static void main(String[] args) {
        EnumSeason summer = EnumSeason.SUMMER;
        //toString():返回枚举类对象的名称
        System.out.println("summer = " + summer.toString());

        System.out.println("*******");
        //定义的枚举类默认继承于java.lang.Enum类
        System.out.println("EnumSeason.class.getSuperclass() = " + EnumSeason.class.getSuperclass());

        //values()方法：返回枚举类型的对象数组。该方法可以很方便地遍历所有的枚举值。
        System.out.println("*******");
        EnumSeason[] values = EnumSeason.values();
        for (int i = 0; i < values.length; i++) {
            System.out.println(values[i]);
        }

        System.out.println("*******");
        //valueOf(String objName):返回枚举类中对象名是objName的对象。
        EnumSeason winter = EnumSeason.valueOf("WINTER");
        //如果没有objName的枚举类对象，则抛异常：IllegalArgumentException
//        Season1 winter = Season1.valueOf("WINTER1");
        System.out.println(winter);

        System.out.println("*******");
        summer.show();
        winter.show();
    }
}

//使用enum关键字枚举类
enum EnumSeason implements Info {
    //1.提供当前枚举类的对象，多个对象之间用","隔开，末尾对象";"结束
//    SPRING("春天", "春暖花开"),
//    SUMMER("夏天", "夏日炎炎"),
//    AUTUMN("秋天", "秋高气爽"),
//    WINTER("冬天", "冰天雪地");
    //让枚举类的对象分别实现接口中的抽象方法
    SPRING("春天", "春暖花开") {
        @Override
        public void show() {
            System.out.println("1");
        }
    },
    SUMMER("夏天", "夏日炎炎") {
        @Override
        public void show() {
            System.out.println("2");
        }
    },
    AUTUMN("秋天", "秋高气爽") {
        @Override
        public void show() {
            System.out.println("3");
        }
    },
    WINTER("冬天", "冰天雪地") {
        @Override
        public void show() {
            System.out.println("4");
        }
    };


    //2.声明Season对象的属性:private final修饰
    private final String seasonName;
    private final String seasonDesc;

    //3.私有化类的构造器，给对象属性赋值
    EnumSeason(String seasonName, String seasonDesc) {
        this.seasonName = seasonName;
        this.seasonDesc = seasonDesc;
    }

    public String getSeasonName() {
        return seasonName;
    }

    public String getSeasonDesc() {
        return seasonDesc;
    }

//    //实现接口，在enum类中实现抽象方法
//    @Override
//    public void show() {
//        System.out.println("这是一个季节");
//    }
}

interface Info {
    void show();
}
