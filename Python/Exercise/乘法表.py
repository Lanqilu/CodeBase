# 以不同方式打印九九乘法表
for i in range(1, 10):
    s = ''
    for j in range(1, 10):
        s += str.format("{0:2}*{1:1}={2:<2}", i, j, i * j)
    print(s)
for i in range(1, 10):
    s = ''
    for j in range(1, i + 1):
        s += str.format("{0:2}*{1:1}={2:<2}", i, j, i * j)
    print(s)
for i in range(1, 10):
    s = ''
    for j in range(i, 10):
        s += str.format("{0:2}*{1:1}={2:<2}", i, j, i * j)
    print(format(s, ">63"))
