//
// Created by 88524 on 2021/3/31.
//
#include <vector>
#include <iostream>
#include <numeric>

using namespace std;

class Solution {
public:
    static int candy(vector<int> &ratings) {
        int nums = ratings.size();
        if (nums < 2) {
            return nums;
        }

        // 初始化数组
        vector<int> candies(nums, 1);
        // 从左遍历
        for (int i = 0; i < nums - 1; i++) {
            if (ratings[i + 1] > ratings[i]) {
                candies[i + 1] = candies[i] + 1;
            }
        }
        // 从右遍历
        for (int i = nums - 1; i >= 1; i--) {
            if (ratings[i - 1] > ratings[i] && candies[i - 1] <= candies[i]) {
                candies[i - 1] = candies[i] + 1;
            }
        }

        return accumulate(candies.begin(), candies.end(), 0);
    }

    int candy2(vector<int> &ratings) {
        int n = ratings.size();
        vector<int> left(n);
        for (int i = 0; i < n; i++) {
            if (i > 0 && ratings[i] > ratings[i - 1]) {
                left[i] = left[i - 1] + 1;
            } else {
                left[i] = 1;
            }
        }
        int right = 0, ret = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (i < n - 1 && ratings[i] > ratings[i + 1]) {
                right++;
            } else {
                right = 1;
            }
            ret += max(left[i], right);
        }
        return ret;
    }
};

int main() {
    vector<int> children = {1, 0, 2};
    int result = Solution::candy(children);
    cout << result << endl;
    return 0;
}