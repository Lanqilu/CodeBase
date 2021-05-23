# 从输入年份(1-2999)开始输出至3000年之前的闰年
x = int(input("请输入年份(1-2999):"))
while x <= 3000:
    if (x % 4 == 0 and x % 100 != 0) or x % 400 == 0:
        print(str.format("{0: < 4}", x), end="\n")
    x += 1
