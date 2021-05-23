# -*- coding: utf-8 -*-
"""
@author lanqilu
@date Created in 2020/07/29  14:59
@file 散列表.py
@description 字典
"""

voted = {}


def check_voter(name):
    if voted.get(name):
        print(name + "\t\tkick them out!")
    else:
        voted[name] = True
        print(name + "\t\tlet them vote!")


check_voter("tom")
check_voter("tim")
check_voter("tom")
