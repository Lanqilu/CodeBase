# 经典的汉诺塔问题，用递归解决
def haoni(n, a, b, c):
    if n == 1:
        print(a, '->', c)
    else:
        haoni(n - 1, a, c, b)
        haoni(1, a, b, c)
        haoni(n - 1, b, a, c)


x = int(input('请输入环数：'))
haoni(x, 'A', "B", 'C')
