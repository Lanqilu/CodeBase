#include <vector>
#include <iostream>

using namespace std;

class Solution {
public:
    static void rotate(vector<vector<int>> &matrix) {
        int temp = 0, n = matrix.size() - 1;
        for (int i = 0; i <= n / 2; ++i) {
            for (int j = i; j < n - i; ++j) {
                temp = matrix[j][n - i];
                matrix[j][n - i] = matrix[i][j];
                matrix[i][j] = matrix[n - j][i];
                matrix[n - j][i] = matrix[n - i][n - j];
                matrix[n - i][n - j] = temp;
            }
        }
    }
};

int main() {
    vector<vector<int>> test = {{1,  2,  3,  4},
                                {5,  6,  7,  8},
                                {9,  10, 11, 12},
                                {13, 14, 15, 16}};
    Solution::rotate(test);
    for (auto &elements : test) {
        for (int element : elements) {
            cout << element << " ";
        }
        cout << endl;
    }
}