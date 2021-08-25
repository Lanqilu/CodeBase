package lists;

import java.util.StringJoiner;

/**
 * @author Halo
 * @date Created in 2021/05/25 9:23 PM
 * @description 单链表
 */
public class SinglyLinkedList {

    /**
     * 头结点
     */
    private Node head;

    /**
     * 单链表大小
     */
    private int size;

    /**
     *  初始化单链表
     */
    public SinglyLinkedList() {
        head = null;
        size = 0;
    }

    /**
     * 指定头结点和大小进行初始化
     *
     * @param head 头结点
     * @param size 链表大小
     */
    public SinglyLinkedList(Node head, int size) {
        this.head = head;
        this.size = size;
    }

    /**
     * 在列表的开头插入一个元素
     *
     * @param element 加入的元素
     */
    public void insertHead(int element) {
        insertNth(element, 0);
    }

    /**
     * 在列表的尾部插入一个元素
     *
     * @param element 加入的元素
     */
    public void insert(int element) {
        insertNth(element, size);
    }

    /**
     * 在列表的指定位置插入新节点
     *
     * @param data 待存储在新节点中的数据
     * @param position 要插入新节点的位置
     */
    public void insertNth(int data, int position) {
        checkBounds(position, 0, size);
        Node newNode = new Node(data);
        if (head == null) {
            // 列表为空
            head = newNode;
            size++;
            return;
        } else if (position == 0) {
            // 插入在列表的最前面
            newNode.next = head;
            head = newNode;
            size++;
            return;
        }
        Node cur = head;
        // 遍历到指定结点的前一个结点
        for (int i = 0; i < position - 1; ++i) {
            cur = cur.next;
        }
        // 让新结点的指针指向当前结点的下一个结点
        newNode.next = cur.next;
        // 让当前结点指向新结点
        cur.next = newNode;
        size++;
    }

    /** 删除头结点 */
    public void deleteHead() {
        deleteNth(0);
    }

    /** 删除队尾元素 */
    public void delete() {
        deleteNth(size - 1);
    }

    /** 删除指定位置元素 */
    public void deleteNth(int position) {
        checkBounds(position, 0, size - 1);
        if (position == 0) {
            Node destroy = head;
            head = head.next;
            destroy = null; /* clear to let GC do its work */
            size--;
            return;
        }
        Node cur = head;
        for (int i = 0; i < position - 1; ++i) {
            cur = cur.next;
        }

        Node destroy = cur.next;
        cur.next = cur.next.next;
        destroy = null; // clear to let GC do its work

        size--;
    }

    /**
     * 用于检查是否越界
     * @param position 待检查的位置
     * @param low 左边界
     * @param high 右边界
     * @throws IndexOutOfBoundsException if {@code position} not in range {@code low} to {@code high}
     */
    public void checkBounds(int position, int low, int high) {
        if (position > high || position < low) {
            throw new IndexOutOfBoundsException(position + "");
        }
    }

    /** 清除列表中的所有节点 */
    public void clear() {
        Node cur = head;
        while (cur != null) {
            Node prev = cur;
            cur = cur.next;
            prev = null; // clear to let GC do its work
        }
        head = null;
        size = 0;
    }

    /**
     * 检查列表是否为空
     *
     * @return {@code true} if list is empty, otherwise {@code false}.
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 返回链表的大小。
     *
     * @return the size of the list.
     */
    public int size() {
        return size;
    }

    /**
     * 获得头结点
     *
     * @return head of the list.
     */
    public Node getHead() {
        return head;
    }

    /**
     * 计算链表大小
     *
     * @return count of the list
     */
    public int count() {
        int count = 0;
        Node cur = head;
        while (cur != null) {
            cur = cur.next;
            count++;
        }
        return count;
    }

    /**
     * 测试值键是否出现在链表中
     *
     * @param key the value to be searched.
     * @return {@code true} if key is present in the list, otherwise {@code false}.
     */
    public boolean search(int key) {
        Node cur = head;
        while (cur != null) {
            if (cur.value == key) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    /**
     * 返回指定位置元素的值
     *
     * @param index given index of element
     * @return element at special index.
     */
    public int getNth(int index) {
        checkBounds(index, 0, size - 1);
        Node cur = head;
        for (int i = 0; i < index; ++i) {
            cur = cur.next;
        }
        return cur.value;
    }

    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner("->");
        Node cur = head;
        while (cur != null) {
            joiner.add(cur.value + "");
            cur = cur.next;
        }
        return joiner.toString();
    }
}

/**
 * 单链表的结点。由一个数据域和一个指向它后面的节点的指针组成
 */
class Node {
    /** 数据域 */
    int value;

    /** 指向下一个结点的指针域 */
    Node next;

    Node() {}

    /**
     * 构造方法
     *
     * @param value 需要放入结点的值
     */
    Node(int value) {
        this(value, null);
    }

    /**
     * 构造方法
     *
     * @param value 需要放入结点的值
     * @param next 对下一个节点的引用
     */
    Node(int value, Node next) {
        this.value = value;
        this.next = next;
    }
}