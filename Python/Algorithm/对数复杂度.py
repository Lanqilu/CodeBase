# -*- coding: utf-8 -*-
"""
@author lanqilu
@date Created in 2020/07/28  15:19
@file 对数复杂度.py
@description 
"""


def intToStr(i):
    """假设i是非负整数返回一个表示i的十进制字符串"""
    digits = '0123456789'
    if i == 0:
        return '0'
    result = ''
    while i > 0:
        result = digits[i % 10] + result
        i = i // 10
    return result


def addDigits(n):
    """假设n是非负整数返回n中每个数字之和"""
    string_rep = intToStr(n)
    val = 0
    for c in string_rep:
        val += int(c)
    return val


print(type(intToStr(567)))
print(addDigits(123))
