# 题目链接：https://pintia.cn/problem-sets/994805260223102976/problems/994805320306507776
# 2020年5月24日


# 网上的做法：https://blog.csdn.net/weixin_43912972/article/details/103940785

times = eval(input()) # 输入要检验的次数
numbers = input()    # 输入检测的数字
number_list = numbers.split() # 将输入的数字字符串拆分开
number_set = set()  # 定义一个空的集合，用来存放“关键数”
i = 0 # 计数器
while i < times:
    num = int(number_list[i])
    if num in number_set: # 如果这个数已经在“关键字”集合中， 那么直接跳过本次循环
        i += 1 # ！！！！！！！一定要注意在continue之前加上i += 1
        continue
    # 对数字进行“砍”的操作
    while num != 1:
        if num % 2 == 0:
            num /= 2
        else:
            num = (3 * num + 1) / 2
        # 如果砍过的数字不在集合中，就需要将砍过之后的数字加到集合中
        if num in number_set:
            break
        else:
            number_set.add(num)
    i += 1
key_list = [] # 定义一个列表用来存放“关键数字”
for i in number_list:
    if int(i) not in number_set:
        key_list.append(int(i)) # 注意要将字符串类型转为int类型，如果字符串类型进行排序操作的话就会出问题，比如降序排列的时候，"11"会被排到"8"的后面
key_list.sort(reverse = True)
for i in range(len(key_list)):
    if i != len(key_list)-1:
        print(key_list[i], end=" ")
    else:
        print(key_list[i])


# TODO:对关键数的处理



# # 我的做法，未完成
# # 输入
# lst = []
# n = int(input())
# for i in range(1):
#     lst.append(input().strip())
# lst = lst[0].split(' ')

# # print(lst)
# # 处理
# def judge(list:lst):
#     lstInt=[]
#     # 将字符串转化成整数
#     for i in lst:
#         lstInt.append(int(i))
#     # print(lstInt)

#     # 对列表进行排序
#     orderLst = sorted(lstInt)
#     orderLst = orderLst[::-1]
#     return orderLst

# # 获取关键数
# def callatz(orderLst):
#     print(orderLst)
#     for i in orderLst:
#         while i != 1:
#             if i % 2 == 1:
#                 i = (3*i+1)/2
#             else:
#                 i = i/2
#             if int(i) in orderLst:
#                 # print(i)
#                 orderLst.remove(i)
#     return orderLst

# orderLst = judge(lst)

# key = callatz(orderLst)


# #输出
# for k in range(len(key)):
#     print(key[k],end=' ' if k!=len(key)-1 else '')