package templates;

import java.util.ArrayList;

/**
 * @Date : 2020/2/10  16:19
 * @Author: Halo
 * @File : List
 * @Version : v1.0
 * @Description: ArrayList遍历有关模板
 **/
public class List {
    public static void main(String[] args) {
        //list.for
        ArrayList list = new ArrayList();
        list.add(123);
        list.add(456);
        list.add(789);
        for (Object o : list) {

        }
        //list.fori
        for (int i = 0; i < list.size(); i++) {

        }
        //list.forr 逆序遍历
        for (int i = list.size() - 1; i >= 0; i--) {

        }
    }
}
