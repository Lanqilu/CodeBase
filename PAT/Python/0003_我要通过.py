# 题目链接：https://pintia.cn/problem-sets/994805260223102976/problems/994805323154440192

# 网上解法：https://blog.csdn.net/he_yang_/article/details/91798477
def check(string: str):
    a = ["P", "A", "T"]
    if string.count("P") != 1 or string.count("T") != 1:
        return False
    if string.index("T") < string.index("P"):
        return False
    if string.count("A") < 1:
        return False
    for i in string:
        if i not in a:
            return False
    s_lst = string.split("P")
    s_lst = s_lst[0:1]+s_lst[1].split("T")
    if len(s_lst[0])*len(s_lst[1]) == len(s_lst[2]) and len(s_lst[1]) != 0:
        return True
    else:
        return False


def main():
    lst = []
    n = int(input())
    for i in range(n):
        lst.append(input().strip())
    for s in lst:
        if check(s):
            print("YES")
        else:
            print("NO")


if __name__ == '__main__':
    main()



# # 读取第一行输入
# count = input()
# for line in input:
#     print(line)

# #实现回车换行，而不是结束
# # endstr="end"#重新定义结束符
# # str1=""
# # for line in iter(input,endstr):#每行接收的东西
# #     str1+= line+"\n"#换行
# # print(str1)

# listStr = str1.split('\n')
# print(listStr)
