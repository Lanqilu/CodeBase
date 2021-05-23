# 使用牛顿迭代法开方
EPSILON = 1e-15  # 容差
a = float(input("请输入正实数t="))
t = a
while abs(t - a / t) > (EPSILON * t):
    t = (a / t + t) / 2.0
print('根号t=', t)
