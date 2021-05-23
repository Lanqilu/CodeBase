# 题目链接：https://pintia.cn/problem-sets/994805260223102976/problems/994805325918486528

# 22ms 2920KB

i = int(input())

def callatz(i):
    j = 0
    while i != 1:
        if i % 2 == 1:
            i = (3*i+1)/2
        else:
            i = i/2
        j += 1
        # print(i)
    return j


print(int(callatz(i)))
