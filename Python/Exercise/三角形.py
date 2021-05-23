# 计算三角形边长及面积
import math

a = float(input("请输入三角形a边长="))
b = float(input("请输入三角形b边长="))
c = float(input("请输入三角形c边长="))
if not a <= 0 and b > 0 and 0 < c < a + b and b + c > a and a + c > b:
    long = a + b + c
    h = long / 2
    s = math.sqrt(h * (h - a) * (h - b) * (h - c))
    print('三角形边长为：', long)
    print('三角形面积为：', str.format("{0:2.1f}", s))
else:
    print('无法构成三角形')
