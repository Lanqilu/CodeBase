# 暴力
def countNegatives(grid):
    sum = 0
    for i in range(len(grid)):
        for j in range(len(grid[i])):
            if grid[i][j] < 0:
                sum += 1
    print(sum)
    return sum


# 二分查找
def countNegatives2(grid):
    sum = 0
    for item in grid:
        l = 0
        r = len(item) - 1
        pos = -1
        while l <= r:
            mid = l + ((r - l) >> 1)
            if item[mid] < 0:
                pos = mid
                r = mid - 1
            else:
                l = mid + 1
        if ~pos:
            sum += len(item) - pos
    print(sum)
    return sum


# 倒序遍历
def countNegatives3(grid):
    sum = 0
    i = -1
    while -i <= len(grid):
        if grid[i][0] >= 0:
            for j in range(-1, -len(grid[i]) - 1, -1):
                if grid[i][j] >= 0:
                    sum += -(j + 1)
                    break
        else:
            sum += len(grid[i])
        i -= 1
    print(sum)
    return sum


# countNegatives([[4,3,2,-1],[3,2,1,-1],[1,1,-1,-2],[-1,-1,-2,-3]])
countNegatives3([[3, -1, -3, -3, -3], [2, -2, -3, -3, -3], [1, -2, -3, -3, -3], [0, -3, -3, -3, -3]])
