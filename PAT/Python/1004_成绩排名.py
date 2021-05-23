# 题目链接：https://pintia.cn/problem-sets/994805260223102976/problems/994805321640296448

# 28ms 3072KB
lst = []
n = int(input())
for i in range(n):
    lst.append(input().strip())

maxIndex = 0
minIndex = 0
maxScore = int(lst[maxIndex].split(' ')[2])
minScore = int(lst[minIndex].split(' ')[2])

for j in range(1, n):
    if int(lst[j].split(' ')[2]) > maxScore:
        maxScore = int(lst[j].split(' ')[2])
        maxIndex = j
    if int(lst[j].split(' ')[2]) < minScore:
        minScore = int(lst[j].split(' ')[2])
        minIndex = j

print(lst[maxIndex].split(' ')[0]+" "+lst[maxIndex].split(' ')[1])
print(lst[minIndex].split(' ')[0]+" "+lst[minIndex].split(' ')[1])
