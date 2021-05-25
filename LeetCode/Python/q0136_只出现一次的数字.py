# -*- coding: utf-8 -*-
"""
@Date    : 2019/12/24 下午 9:29
@Author  : long
@File    : q0136_只出现一次的数字.py
"""

"""
给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
说明:你的算法应该具有线性时间复杂度。你可以不使用额外空间来实现吗？

示例 1:         示例 2:
输入: [2,2,1]   输入: [4,1,2,1,2]
输出: 1         输出: 4
"""

"""
1.遍历nums中的每一个元素
2.如果某个nums中的数字是新出现的，则将它添加到列表中
3.如果某个数字已经在列表中，删除它
"""


class Solution:
    @staticmethod
    def singleNumber1(nums: "List[int]") -> "int":  # 使用列表操作
        no_duplicate_list = []
        for i in nums:
            if i not in no_duplicate_list:
                no_duplicate_list.append(i)
            else:
                no_duplicate_list.remove(i)
        return no_duplicate_list.pop()

    @staticmethod
    def singleNumber2(nums: "List[int]") -> "int":  # 哈希表
        hash_table = {}
        for i in nums:
            try:
                hash_table.pop(i)
            except:
                hash_table[i] = 1
        return hash_table.popitem()[0]


if __name__ == '__main__':
    a = Solution.singleNumber1([2, 2, 1, 1, 3, 3, 5, 4, 4])
    b = Solution.singleNumber2([2, 2, 1, 1, 3, 3, 5, 4, 4])
    print(a)
    print(b)

