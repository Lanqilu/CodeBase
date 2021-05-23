# 题目链接：https://pintia.cn/problem-sets/994805260223102976/problems/994805318855278592

# 21ms 2944KB
number =  int(input())

hundred = int(number/100)
ten = int(number%100/10)
unit = int(number%100%10)

for i in range(hundred):
    print('B',end='')
for i in range(ten):
    print('S',end='')
for i in range(1,unit+1):
    print(str(i),end='')