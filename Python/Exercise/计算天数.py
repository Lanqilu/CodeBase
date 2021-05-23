# 求输入日期在该年中是第几天
import datetime

print(datetime.datetime.today().year)  # 返回当前年份值
dtstr = input('Enter the datetime:(例如:20000907):')
dt = datetime.datetime.strptime(dtstr, "%Y%m%d")
another_dtstr = dtstr[:4] + "0101"
another_dt = datetime.datetime.strptime(another_dtstr, "%Y%m%d")
print(int((dt - another_dt).days) + 1)
