//
// Created by 88524 on 2021/3/10.
//

#include <cstdlib>

struct ListNode {
    int val;
    ListNode *next;

    ListNode() : val(0), next(nullptr) {}

    ListNode(int x) : val(x), next(nullptr) {}

    ListNode(int x, ListNode *next) : val(x), next(next) {}
};

class Solution {
public:
    // 将链表闭合成环,在找到点切开该环
    ListNode *rotateRight(ListNode *head, int k) {
        // 在没有或者只有一个节点或k为0的情况下,无须处理直接返回链表.
        if (!head || !head->next || k == 0) {
            return head;
        }
        ListNode *p = head;
        ListNode *q = nullptr;
        ListNode *node = head;

        // 统计链表长度
        int len = 1;
        // 遍历链表
        while (p->next) {
            p = p->next;
            len++;
        }

        // 如果k是链表长度的倍数,无需处理链表直接返回
        if (k % len == 0) {
            return head;
        }

        p->next = head;

    }
};

int main(){
}