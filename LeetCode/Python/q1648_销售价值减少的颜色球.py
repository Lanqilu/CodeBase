def maxProfit1(inventory, orders):
    i = 0
    result = 0
    # 数组元素只有一个时
    if len(inventory) == 1:
        while orders > 0:
            orders = orders - 1
            result = result + inventory[0]
            inventory[0] = inventory[0] - 1
        return result % 1000000007
    # 数组元素有多个时
    while orders > 0 and i < len(inventory):
        if inventory[i] < inventory[i + 1]:
            inventory = sorted(inventory, reverse=True)
        result += inventory[i]
        inventory[i] = inventory[i] - 1
        orders = orders - 1
    return result % 1000000007


def maxProfit(inventory, orders):
    inventory = sorted(inventory, reverse=True)
    res = 0
    i = 0
    mod = 1e9+7
    while orders > 0:
        # 找到第二多元素的索引
        while i < len(inventory) and inventory[i] >= inventory[0]:
            i = i + 1
        # 将第二多元素赋值到 nextEle
        nextEle = 0
        if i < len(inventory):
            nextEle = inventory[i]
        # 具有相同个数的元素有多少个
        bucks = i
        # 当前最多元素与第二多元素个数之差
        delta = inventory[0] - nextEle
        # 最多可以一次性销售多少次
        rem = bucks * delta
        # 一次性销售次数大于卖的个数
        if rem > orders:
            dec = orders // bucks
            a1 = inventory[0] - dec + 1
            an = inventory[0]
            res = res + ((((a1 + an) * dec) // 2) * bucks)
            res = res + ((inventory[0] - dec) * (orders % bucks))
        # 一次性销售次数小于卖的个数
        else:
            # 可以卖出的最低价格
            a1 = nextEle + 1
            # 可以卖出的最高价格
            an = inventory[0]
            # 等差数列求和
            res = res + ((((a1 + an) * delta) // 2) * bucks)
            inventory[0] = nextEle
        # orders 减去一次性买入个数
        orders = orders - rem
        # 先取模防止溢出
        res = res % mod
    return int(res)


if __name__ == '__main__':
    # print(maxProfit([2, 5], 4))  # 14
    # print(maxProfit([3, 5], 6))  # 19
    print(maxProfit([2, 8, 4, 10, 6], 20))  # 110
    # print(maxProfit([10], 10))  # 55
    # print(maxProfit([1000000000], 1000000000))  # 21
    # print(maxProfit([773160767], 252264991))  # 70267492
