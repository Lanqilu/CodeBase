# -*- coding: utf-8 -*-
"""
@author lanqilu
@date Created in 2020/07/24  11:44
@file 二分查找.py
@description 二分查找的一个前提是输入序列为有序序列
"""


def binary_search(nums: "List[int]", target: "int") -> "List[int]":
    # low和high用于跟踪要在其中查找的列表部分
    low = 0
    high = len(nums) - 1
    # 不断将范围缩小直至只有一个元素
    while low <= high:
        # 检查中间元素
        mid = (low + high)
        guess = nums[mid]
        if guess == target:
            return mid
        if guess > target:
            high = mid - 1
        else:
            low = mid + 1
    return None


if __name__ == '__main__':
    my_list = [1, 3, 5, 7, 9]

    print(binary_search(my_list, 3))
    # 1
    print(binary_search(my_list, -1))
    # None
