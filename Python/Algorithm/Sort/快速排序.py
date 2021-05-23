# -*- coding: utf-8 -*-
"""
@author lanqilu
@date Created in 2020/07/28  14:03
@file 快速排序.py
@description 
"""


def quickSort(array):
    less = []
    greater = []
    if len(array) < 2:
        return array
    else:
        # 递归条件
        pivot = array[0]
        # 由所有小于基准值的元素组成的子数组
        # less = [i for i in array[1:] if i <= pivot]
        for i in array[1::]:
            if i <= pivot:
                less.append(i)
        # 由所有大于基准值的元素组成的子数组
        # greater = [i for i in array[1:] if i > pivot]
        for i in array[1::]:
            if i > pivot:
                greater.append(i)

    return quickSort(less) + [pivot] + quickSort(greater)


print(quickSort([10, 5, 2, 3]))
