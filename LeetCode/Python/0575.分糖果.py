# -*- coding: utf-8 -*-
"""
@author lanqilu
@date Created in 2020/07/29  16:10
@file 0575.分糖果.py
@description 
"""


def distributeCandies(candies):
    dit = {}
    for i in candies:
        dit[i] = 0
    if len(dit) > len(candies) / 2:
        return int(len(candies) / 2)
    else:
        return len(dit)


print(distributeCandies([1, 1, 2, 3, 4, 5]))
