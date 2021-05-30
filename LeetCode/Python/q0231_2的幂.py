# 2021年5月30日
# https://halo123.top/2021/05/30/LeetCode/%E4%BD%8D%E8%BF%90%E7%AE%97
def isPowerOfTwo(n):
    return n > 0 and n & (n - 1) == 0


if __name__ == '__main__':
    print(isPowerOfTwo(8))
    print(isPowerOfTwo(19))
