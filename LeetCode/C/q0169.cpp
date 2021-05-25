//
// Created by 88524 on 2021/3/9.
//
#include <iostream>
#include <vector>
#include <unordered_map>

using namespace std;

// 时间复杂度为 O(n)、空间复杂度为 O(1) 的算法解决此问题。
// 遇到相同数+1,否则-1.如果到0则跟换

class Solution {
public:
    // Boyer-Moore 投票算法
    // 如果我们把众数记为 +1+1，把其他数记为 -1−1，将它们全部加起来，显然和大于 0，从结果本身我们可以看出众数比其他数多。
    static int majorityElement1(vector<int> &nums) {
        int cnt = 0;
        int temp;
        temp = nums[0];

        for (auto item = nums.begin() + 1; item < nums.end(); item++) {
            // 如果计数cnt为0并且temp等于下一个值时,计数++
            if (cnt == 0 && *item == temp) {
                cnt++;
            } else{
                // cnt为0并且temp不等于下一个值时交换temp和*item
                if (cnt == 0) {
                    temp = *item;
                    continue;
                }
                // 两者相等cnt++,否则--
                if (*item == temp) {
                    cnt ++;
                } else {
                    cnt --;
                }
            }
        }
        return temp;
    }

    // Boyer-Moore 投票算法
    static int majorityElement2(vector<int> &nums){
        int candidate = -1;
        int count = 0;
        for (int num : nums) {
            if (num == candidate)
                count++;
            else if (--count < 0) {
                candidate = num;
                count = 1;
            }
        }
        return candidate;
    }

    // 哈希表
    static int majorityElement3(vector<int>& nums) {
        unordered_map<int, int> counts;
        int majority = 0, cnt = 0;
        for (int num: nums) {
            ++counts[num];
            if (counts[num] > cnt) {
                majority = num;
                cnt = counts[num];
            }
        }
        return majority;
    }
};

int main() {
    vector<int> v{1, 2, 3, 1, 1, 1,2};
    cout << Solution::majorityElement1(v) << endl;
    cout << Solution::majorityElement2(v) << endl;
    cout << Solution::majorityElement3(v) << endl;
    return 0;
}