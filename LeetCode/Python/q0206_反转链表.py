# -*- coding: utf-8 -*-
"""
@author lanqilu
@date Created in 2020/07/29  16:54
@file q0206_反转链表.py
@description 
"""


class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None


def create_list(l: list):
    dummy = ListNode(-1)
    p = dummy
    for i in l:
        n = ListNode(i)
        p.next = n
        p = n
    return dummy.next


class Solution:
    def reverseList(self, head: ListNode) -> ListNode:
        pre = None
        cur = head
        while cur:
            temp = cur.next
            cur.next = pre
            pre = cur
            cur = temp
        return pre


if __name__ == '__main__':
    inp = [1, 2, 3, 4, 5]
    inp_list = create_list(inp)
    sol = Solution()
    rev = sol.reverseList(inp_list)
    print(rev)
