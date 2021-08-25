package lists;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Halo
 * @date Created in 2021/05/25 10:15 PM
 * @description
 */
public class SinglyLinkedListTest {

    SinglyLinkedList list;

    @BeforeEach
    public void setUp(){
        this.list = new SinglyLinkedList();
        list.insertHead(5);
        list.insertHead(7);
        list.insertHead(10);
        list.insert(3);
        list.insertNth(1, 4);
    }

    @Test
    void baseTest(){
        System.out.println("list.isEmpty() = " + list.isEmpty());
        System.out.println("(list.size() == 5 && list.count() == 5) = " + (list.size() == 5 && list.count() == 5));
        System.out.println("list.toString().equals(\"10->7->5->3->1\") = " + list.toString().equals("10->7->5->3->1"));
    }

    /**
     * 测试查找函数
     */
    @Test
    void searchTest(){
        System.out.println("list.toString() = " + list.toString());
        System.out.println("list.search(10) = " + list.search(10));
        System.out.println("list.search(5) = " + list.search(5));
        System.out.println("list.search(1) = " + list.search(1));
        System.out.println("!list.search(100) = " + !list.search(100));
    }

    /**
     * 测试Get函数
     */
    @Test
    void getTest(){
        System.out.println("list.toString() = " + list.toString());
        System.out.println("list.getNth(0) == 10 = " + (list.getNth(0) == 10));
        System.out.println("(list.getNth(2) == 5) = " + (list.getNth(2) == 5));
        System.out.println("(list.getNth(4) == 1) = " + (list.getNth(4) == 1));
    }

    /**
     * 测试Delete函数
     */
    @Test
    void deleteTest(){
        list.deleteHead();
        list.deleteNth(1);
        list.delete();
        System.out.println("list.toString() = " + list.toString());
        System.out.println("list.toString().equals(\"7->3\") = " + list.toString().equals("7->3"));

        System.out.println("list.size() = " + list.size());
        System.out.println("(list.size() == list.count()) = " + (list.size() == list.count()));

        list.clear();
        System.out.println("list.toString() = " + list.toString());
        System.out.println("list.isEmpty() = " + list.isEmpty());

        try {
            list.delete();
        } catch (Exception e) {
            System.out.println("e = " + e);
        }
    }
}
