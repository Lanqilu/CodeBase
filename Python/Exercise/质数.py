# 判断一个数是否是质数
import math

for m in range(2, 101):
    k = int(math.sqrt(m))
    for i in range(2, k + 2):
        if m % i == 0:
            break
    if i == k + 1:
        print(m, "是质数")
