/**
 * @Date : 2020/2/10  20:26
 * @Author: Halo
 * @File : Student
 * @Version : v1.0
 * @Description: 类与对象练习
 **/
public class StudentDemo {

    public static void main(String[] args) {

        //声明Students类型数组
        Students[] s = new Students[20];

        for (int i = 0; i < s.length; i++) {
            //给数组元素赋值
            s[i] = new Students();
            //给s赋值
            s[i].id = (i + 1);
            s[i].state = (int) (Math.random() * (6 - 1 + 1) + 1);
            s[i].score = (int) (Math.random() * (100 - 0 + 1));
        }

        //创建StudentDemo对象
        StudentDemo test = new StudentDemo();
        //调用遍历方法
        test.print(s);
        System.out.println("******************");

        //需求打印3年级学生信息
        test.searchState(s,3);
        System.out.println("******************");

        //使用冒泡排序对成绩进行降序并输出
        test.sort(s);
        test.print(s);

    }

    public void print(Students[] s) {
        /**
         * @Description: 遍历数组
         * @Param: [s]
         * @returns: void
         * @E-Mail: lanqilu@foxmail.com
         * @Date: 2020/2/10 下午 9:53
         **/

        for (int i = 0; i < s.length; i++) {
            System.out.println(s[i].info());
        }
    }

    public void searchState(Students[] s, int state) {
        /**
         * @Description: 查找某年级学生信息
         * @Param: [s, state]
         * @returns: void
         * @E-Mail: lanqilu@foxmail.com
         * @Date: 2020/2/10 下午 9:25
         **/
        for (int i = 0; i < s.length; i++) {
            if (s[i].state == state) {
                System.out.println(s[i].info());
            }
        }
        System.out.println();
    }

    public void sort(Students[] s) {
        /**
         * @Description: 冒泡排序对成绩进行降序并输出
         * @Param: [s]
         * @returns: void
         * @E-Mail: lanqilu@foxmail.com
         * @Date: 2020/2/10 下午 9:28
         **/
        for (int i = 0; i < s.length - 1; i++) {
            for (int j = 0; j < s.length - 1 - i; j++) {
                if (s[j].score < s[j + 1].score) {
                    //交换数组元素
                    Students temp = s[j];
                    s[j] = s[j + 1];
                    s[j + 1] = temp;
                }
            }
        }
    }
}


class Students {

    int id;//学号
    int state;//年级
    int score;//成绩

    /*返回学生信息*/
    public String info() {
        /**
         * @Description: 返回学生信息
         * @Param: []
         * @returns: java.lang.String
         * @E-Mail: lanqilu@foxmail.com
         * @Date: 2020/2/10 下午 9:40
         **/

        return "学号:" + id + "\t年级:" + state + "\t成绩:" + score;
    }


}
