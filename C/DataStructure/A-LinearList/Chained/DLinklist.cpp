// 双链表
#include <cstdlib>
#include <iostream>
using namespace std;

typedef struct DNode {
    int data;                    // 数据域
    struct DNode *prior, *next;  // 前驱指针和后继指针
} DNode, *DLinklist;

// 双链表的插入
bool InertNextDNode(DNode *p, DNode *s) {
    if (p == nullptr || s == nullptr) {
        return false;
    }
    s->next = p->next;  // 将结点*s指向到结点*p之后的结点
    if (p->next != nullptr) {
        p->next->prior = s;  // 将*p结点的后一个结点的前驱指针指向s结点
    }
    s->prior = p;  // 将s结点的前驱指针指向p结点
    p->next = s;   // 将p结点的后驱指针指向s结点
}

// 双链表的删除操作
bool DeleteNextDNode(DNode *p) {
    if (p == nullptr) {
        return false;
    }
    DNode *q = p->next;  // 找到p的后继结点q
    if (q == nullptr) {
        return false;  // p没有后继结点
    }
    p->next =
        q->next;  // p结点绕过q结点直接指向q结点的后一个结点，相当于删除q结点
    if (q->next != nullptr) {
        q->next->prior = p;  // 将q结点的后一个结点的前驱指针指向p结点
    }
    free(q);
    return true;
}

/** 遍历并输出
 * @param p 双向链表
 * @param rule 遍历规则，1：后向遍历；2：前向遍历
 */

void PrintList(DNode *p, int rule) {
    if (rule == 1) {
        while (p != nullptr) {
            cout << p->data << " -> ";
            p = p->next;
        }
    } else if (rule == 2) {
        // 前向遍历
        while (p != nullptr) {
            cout << p->data << " <- ";
            p = p->prior;
        }
    }
    cout << endl;
}

int main() { return 0; }