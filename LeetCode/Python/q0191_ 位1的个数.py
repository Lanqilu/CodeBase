# @author Halo
# @date Created in 2021/05/30 8:36 PM

def hammingWeight(n):
    # bin() 返回一个整数 int 或者长整数 long int 的二进制表示。
    # print(bin(n))
    return bin(n).count('1')


if __name__ == '__main__':
    print(hammingWeight(0b0010101010101))
