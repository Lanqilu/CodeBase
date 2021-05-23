a = {"ross": "123456", "xiaoming": "acb123"}
b = {"lilei": "111111", "zhangsan": "123456"}

# 合并操作
c = {}
for k in a:
    c[k] = a[k]
for k in b:
    c[k] = b[k]

print(f"合并后的字典:{c}")

# 简化操作 解包
d = {**a, **b}
print(f"合并后的字典:{d}")
