#include <vector>
#include <iostream>
#include <cstdlib>

using namespace std;

class Solution {
public:
    static vector<int> findDisappearedNumbers(vector<int> &nums) {

        // 创建桶
        vector<int> bucket(nums.size() + 1, 0);
        for (int num : nums) {
            bucket[num] = 1;
        }

        vector<int> result;
        for (int i = 1; i < bucket.size(); ++i) {
            if (bucket[i] == 0) {
                result.push_back(i);
            }
        }
        return result;
    }

    static vector<int> findDisappearedNumbers2(vector<int> &nums) {
        vector<int> result;
        int pos;
        for (const int &num:nums) {
            // 获取坐标
            pos = abs(num) - 1;
            // 使对应坐标的值变成负值，用于标记
            if (nums[pos] > 0) {
                nums[pos] = -nums[pos];
            }
        }
        for (int i = 0; i < nums.size(); ++i) {
            if (nums[i] > 0) {
                result.push_back(i + 1);
            }
        }
        return result;
    }
};

int main() {
    vector<int> test = {4, 3, 2, 7, 8, 2, 3, 1};
    vector<int> test2 = {1, 1};
    vector<int> result = Solution::findDisappearedNumbers(test2);
    for (int i = 0; i < result.size(); ++i) {
        cout << result[i] << " ";
    }
    return 0;
}