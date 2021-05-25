#include <vector>
#include <iostream>

using namespace std;

class Solution {
public:
    static bool searchMatrix(vector<vector<int>> &matrix, int target) {
        int m = matrix.size();
        if (m == 0) {
            return false;
        }
        int n = matrix[0].size();
        int i = 0;
        int j = n - 1;
        while (i < m && j >= 0) {
            if (matrix[i][j] == target) {
                return true;
            } else if (matrix[i][j] > target) {
                j--;
            } else {
                i++;
            }
        }
        return false;
    }
};

int main() {
    vector<vector<int>> test = {{1,  4,  7,  11, 15},
                                {2,  5,  8,  12, 19},
                                {3,  6,  9,  16, 22},
                                {10, 13, 14, 17, 24},
                                {18, 21, 23, 26, 30}};
    vector<vector<int>> test2 = {{-5}};
    bool result = Solution::searchMatrix(test2, -5);
    cout << result << endl;
}