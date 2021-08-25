package lists;

/**
 * @author Halo
 * @date Created in 2021/05/25 10:43 PM
 * @description
 */
public class DoublyLinkedListTest {
    /**
     * Main Method
     *
     * @param args Command line arguments
     */
    public static void main(String args[]) {
        DoublyLinkedList myList = new DoublyLinkedList();
        myList.insertHead(13);
        myList.insertHead(7);
        myList.insertHead(10);
        myList.display(); // <-- 10(head) <--> 7 <--> 13(tail) -->

        myList.insertTail(11);
        myList.display(); // <-- 10(head) <--> 7 <--> 13 <--> 11(tail) -->

        myList.deleteTail();
        myList.display(); // <-- 10(head) <--> 7 <--> 13(tail) -->

        myList.delete(7);
        myList.display(); // <-- 10(head) <--> 13(tail) -->

        myList.insertOrdered(23);
        myList.insertOrdered(67);
        myList.insertOrdered(3);
        myList.display(); // <-- 3(head) <--> 10 <--> 13 <--> 23 <--> 67(tail) -->
        myList.insertElementByIndex(5, 1);
        myList.display(); // <-- 3(head) <--> 5 <--> 10 <--> 13 <--> 23 <--> 67(tail) -->
        myList.clearList();
        myList.display();
        myList.insertHead(20);
        myList.display();
    }
}
