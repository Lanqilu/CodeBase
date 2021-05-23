# 题目链接：https://pintia.cn/problem-sets/994805260223102976/problems/994805324509200384

# 21ms 2944KB
i = input()


def write(i):
    sum = 0
    for j in i:
        sum += int(j)
    return sum


def change(sum):
    str1 = ''
    for j in sum:
        j = int(j)
        if j == 1:
            str1 += 'yi '
        elif j == 2:
            str1 += 'er '
        elif j == 3:
            str1 += 'san '
        elif j == 4:
            str1 += 'si '
        elif j == 5:
            str1 += 'wu '
        elif j == 6:
            str1 += 'liu '
        elif j == 7:
            str1 += 'qi '
        elif j == 8:
            str1 += 'ba '
        elif j == 9:
            str1 += 'jiu '
        else:
            str1 += 'ling '
    print(str1.strip())


sum = str(write(i))
change(sum)
