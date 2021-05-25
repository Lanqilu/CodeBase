#include <vector>
#include <iostream>
#include <numeric>

using namespace std;

/**
 * AddTwoNumbers
 */
class Solution {
public:
    static bool canPlaceFlowers(vector<int> &flowerbed, int n) {
        // 当n为0时无论什么情况都为true
        if (n == 0) {
            return true;
        }
        int nums = flowerbed.size();
        // 在只有1个位置时，除了n=0情况下，只有n为1且位置为空才为true
        if (nums == 1) {
            if (n == 1 && flowerbed[0] == 0) {
                return true;
            } else {
                return false;
            }
        }

        // 用于统计未加入花时的，花数目
        int before = accumulate(flowerbed.begin(), flowerbed.end(), 0);

        // 将[0,0,...]情况下时变成[1,0,...]
        if (flowerbed[0] == 0 && flowerbed[1] == 0) {
            flowerbed[0] = 1;
        }

        // 将[...,0,0,0,...]情况变成[...,0,1,0,...]
        for (int i = 1; i < flowerbed.size() - 1; ++i) {
            if (flowerbed[i] == 0 && flowerbed[i - 1] == 0 && flowerbed[i + 1] == 0) {
                flowerbed[i] = 1;
            }
        }

        // 将[...,0,0]情况变成[...,0,1]
        if (flowerbed[flowerbed.size() - 1] == 0 && flowerbed[flowerbed.size() - 2] == 0) {
            flowerbed[flowerbed.size() - 1] = 1;
        }

        //统计加入花后的所有花的数目
        int after = accumulate(flowerbed.begin(), flowerbed.end(), 0);
        // 当n小于,可以插入花的最大数目时返回true
        if ((after - before) >= n) {
            return true;
        } else {
            return false;
        }
    }


    bool canPlaceFlowers2(vector<int>& flowerbed, int n) {
        int count = 0;
        int m = flowerbed.size();
        int prev = -1;
        for (int i = 0; i < m; ++i) {
            if (flowerbed[i] == 1) {
                if (prev < 0) {
                    count += i / 2;
                } else {
                    count += (i - prev - 2) / 2;
                }
                prev = i;
            }
        }
        if (prev < 0) {
            count += (m + 1) / 2;
        } else {
            count += (m - prev - 1) / 2;
        }
        return count >= n;
    }

};

int main() {
    vector<int> test = {1, 0, 0, 0, 1};
    vector<int> test2 = {0, 0, 0, 0, 0};
    vector<int> test3 = {0};
    vector<int> test4 = {1};
    vector<int> test5 = {0, 0};
    bool result = Solution::canPlaceFlowers(test4, 0);
    cout << result << endl;
    return 0;
}