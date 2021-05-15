fruit = ["apple", "pear", "orange", "banana"]

# 全部替换为大写
for i in range(len(fruit)):
    fruit[i] = fruit[i].upper()

print(fruit)

# 使用列表表达式全部替换为小写
fruit = [x.lower() for x in fruit]

print(fruit)

# 过滤首字母为 a 的字符串
filtered_friut = []
for f in fruit:
    if f.startswith("a"):
        filtered_friut.append(f)

print(filtered_friut)

# 使用列表表达式改写
filtered_friut2 = [x for x in fruit if x.startswith("b")]
print(filtered_friut2)
