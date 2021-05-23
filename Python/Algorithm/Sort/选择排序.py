# -*- coding: utf-8 -*-
"""
@author lanqilu
@date Created in 2020/07/24  13:08
@file 选择排序.py
@description O(n×n)
"""


def findSmallest(arr):
    # 储存最小值
    smallest = arr[0]
    # 储存最小值的索引
    smallest_index = 0
    for i in range(1, len(arr)):
        if arr[i] < smallest:
            smallest = arr[i]
            smallest_index = i
    return smallest_index


def selectionSort(arr):
    new_arr = []
    for i in range(len(arr)):
        # 找出最小值并加入到新的数组中
        smallest = findSmallest(arr)
        new_arr.append(arr.pop(smallest))
    return new_arr


if __name__ == '__main__':
    my_list = [5, 3, 6, 2, 10]
    print(selectionSort(my_list))
