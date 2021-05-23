# -*- coding: utf-8 -*-
"""
@author lanqilu
@date Created in 2020/07/24  13:24
@file 递归.py
@description 
"""


def countdown(i):
    print(i)
    # 基线条件:使函数不再调用自己，从而避免形成无限循环
    if i <= 0:
        return
    # 递归条件:函数调用自己
    else:
        countdown(i - 1)


if __name__ == '__main__':
    countdown(10)
