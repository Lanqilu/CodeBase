# 求阶乘
a = 1
x = 1
sum = 1
n = int(input("请输入非负整数n="))
while n < 0:
    n = int(input("请输入非负整数n="))
for i in range(1, n + 1):
    a *= i
print("for循环n!=", a)
while x <= n:
    sum *= x
    x += 1
print('while循环n!=', sum)


# 求阶乘的递归做法
def factorial(x):
    if x == 1:
        return 1
    else:
        return x * factorial(x - 1)


if __name__ == '__main__':
    print("递归n!="+str(factorial(6)))
