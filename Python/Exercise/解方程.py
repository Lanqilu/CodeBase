# auther lanqilu
from math import *

a = float(input("a="))
b = float(input("b="))
c = float(input("c="))
print(str.format('此方程为{}x^2+{}x+{}=0', int(a), int(b), int(c)))
delate = b * b - 4 * a * c
if a == 0 and b == 0:
    print("此方程无解！")
elif a == 0 and b != 0:
    x = -c / b
    print('有一个实根x=', x)
elif delate < 0:
    print(str.format('有两个共轭复根：{0}+{1}i和{0}-{1}i',
                     (-(b / (2 * a))), (sqrt(4 * a * c - b * b)) / (2 * a)))
elif delate == 0:
    x1 = -b / (2 * a)
    print('有两个相等实根：', x1)
elif delate > 0:
    x1 = (-b + sqrt(b * b - 4 * a * c)) / (2 * a)
    x2 = (-b - sqrt(b * b - 4 * a * c)) / (2 * a)
    print("有两个不等实根：", x1, '和', x2)
