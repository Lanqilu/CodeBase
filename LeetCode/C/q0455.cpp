#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;

class Solution {
   public:
    static int findContentChildren(vector<int>& g, vector<int>& s) {
        // 对胃口值进行升序排序
        sort(g.begin(), g.end());
        // 对饼干进行升序排序
        sort(s.begin(), s.end());
        int child = 0, cookie = 0;
        // 循环遍历，如果其中一个数组长度小于另一个则跳出循环
        while (child < g.size() && cookie < s.size()) {
            if (g[child] <= s[cookie]) {
                // 满足一个孩子
                child++;
            }
            // 无论是否满足都将饼干++
            cookie++;
        }
        // 返回满足的孩子数
        return child;
    }
};

void test1() {
    vector<int> children = {1, 2, 3};
    vector<int> cookies = {1, 1};
    int result = Solution::findContentChildren(children, cookies);
    cout << result << endl;
}
void test2() {
    vector<int> children = {1, 2};
    vector<int> cookies = {1, 2, 3};
    int result = Solution::findContentChildren(children, cookies);
    cout << result << endl;
}

int main() {
    cout << "example 1 " << endl;
    test1();
    cout << "example 2 " << endl;
    test2();
}
