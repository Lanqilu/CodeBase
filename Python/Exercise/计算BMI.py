# 计算BMI并判断
h, w = eval(input("请输入身高(m)和体重(kg),逗号隔开:"))
bmi = w / (h * h)
print("BMI是{:.1f}".format(bmi))
if bmi < 18.5:
    print("低于正常体重")
elif bmi < 25:
    print("体重正常")
elif bmi < 30:
    print("超重")
elif bmi < 35:
    print("一类肥胖")
elif bmi < 40:
    print("二类肥胖")
elif bmi >= 40:
    print("三类肥胖")
