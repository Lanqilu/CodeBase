import random

a = random.randint(0, 100)
b = random.randint(0, 100)
c = a
d = b
print('整数a=', a, '整数b=', b)
# 辗转相除法求最大公约数
while (b % a != 0):
    a, b = b % a, a
print('最大公约数=', a)
print('最小公倍数=', c * d / a)
