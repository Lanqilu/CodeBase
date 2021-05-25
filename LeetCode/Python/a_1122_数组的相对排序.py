# 暴力
def relativeSortArray(arr1, arr2):
    for j in arr1:
        for i in range(-1, -len(arr2), -1):
            if j == arr2[i]:
                arr2.insert(i, j)
        arr2.append(j)
    print(arr2)


relativeSortArray([7, 9, 2, 19], [2, 9])
