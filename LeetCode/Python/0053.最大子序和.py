# -*- coding: utf-8 -*-
"""
@Date    : 2019/12/24 下午 9:45
@Author  : long
@File    : 0053.最大子序和.py
"""

"""
给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。

示例:
输入: [-2,1,-3,4,-1,2,1,-5,4],
输出: 6
解释: 连续子数组 [4,-1,2,1] 的和最大,为6

进阶:
如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
"""


class Solution:
    @staticmethod
    def maxSubArray(nums: "List[int]") -> "int":
        n = len(nums)
        max_sum = nums[0]
        for i in range(1, n):
            if nums[i - 1] > 0:
                nums[i] += nums[i - 1]
            max_sum = max(nums[i], max_sum)

        return max_sum


if __name__ == '__main__':
    a = Solution.maxSubArray([-2, 1, -3, 4, -1, 2, 1, -5, 4])
    print(a)
