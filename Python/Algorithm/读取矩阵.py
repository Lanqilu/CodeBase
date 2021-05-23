# -*- coding: utf-8 -*-
"""
@author lanqilu
@date Created in 2020/09/18  18:52
@file 01-读取矩阵.py
@description 读取三个矩阵A、B、C，并测试是否AB=C
"""
from sys import stdin


def readInt():
    return int(stdin.readline())


def readArray(typ):
    return list(map(typ, stdin.readline().split()))


def readMatrix(n):
    m = []
    for _ in range(n):
        row = readArray(int)
        assert len(row) == n
        m.append(row)
    return m


def mult(m, v):
    n = len(m)
    return [sum(m[i][j] * v[j] for j in range(n)) for i in range(n)]


def freivalds(a, b, c):
    n = len(a)
    x = [readInt(0, 1000000) for j in range(n)]
    return mult(a, mult(b, x)) == mult(c, x)


if __name__ == '__main__':
    n = readInt()
    a = readMatrix(n)
    b = readMatrix(n)
    c = readMatrix(n)
    print(freivalds(a, b, c))
