name = "Halo"
age = 18

print("Hi, I'm %s. I'm %d" % (name, age))
print("Hi, I'm {}. I'm {}" .format(name, age))
# 括号更换对应索引
print("Hi, I'm {0}. I'm {0}. I'm {1}." .format(name, age))
# 3.6 版本 f-string 括号内可以替换为表达式
print(f"Hi, I'm {name}. I'm {age+1}")
