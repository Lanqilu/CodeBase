# 计算复利
import math

captial = float(input("本金"))
rate = float(input("年利率"))
date = float(input("存款年数"))
amount = captial * ((1 + rate) ** date)
print(str.format("本金利率和为:{0:2.2f}", amount))


def getValue(captial, rate, value):
    value = captial * ((1 + rate) ** date)
    return value


total = getValue(1000, 0.05, 5)
print(str.format("{0:2.2f}", amount))
