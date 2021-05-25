# -*- coding: utf-8 -*-
"""
@Date    : 2019/12/24 下午 9:00
@Author  : long
@File    : q0001_两数之和.py
"""

"""
题目
给定一个整数数组 nums 和一个目标值 target，
请你在该数组中找出和为目标值的那 两个整数，
返回他们的数组下标。

你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。

示例:
给定 nums = [2, 7, 11, 15], target = 9
因为 nums[0] + nums[1] = 2 + 7 = 9
所以返回 [0, 1]
"""


class Solution:
    @staticmethod
    def twoSum(nums: "List[int]", target: "int") -> "List[int]":
        # 暴力法 遍历每个元素,并查找是否存在一个值与target-x相等的目标元素
        lens = len(nums)
        j = -1
        for i in range(lens):
            if (target - nums[i]) in nums:
                if (nums.count(target - nums[i]) == 1) & (
                        target - nums[i] == nums[i]):  # 如果num2=num1,且nums中只出现了一次，说明找到是num1本身。
                    continue
                else:
                    j = nums.index(target - nums[i], i + 1)  # index(x,i+1)是从num1后的序列后找num2
                    break
        if j > 0:
            return [i, j]
        else:
            return []


if __name__ == '__main__':
    s = Solution()
    a = s.twoSum([1, 2, 3, 4, 5, 6], 5)
    print(a)
