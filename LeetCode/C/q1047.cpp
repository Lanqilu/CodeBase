//
// Created by 88524 on 2021/3/9.
// 删除字符串中的所有相邻重复项
//
#include <iostream>

using namespace std;

class Solution {
public:
    static string removeDuplicates(string S) {
        string stk;
        for (char ch : S) {
            // 如果栈非空并且 栈中最后元素等于遍历的元素 则栈中最后元素出栈
            if (!stk.empty() && stk.back() == ch) {
                stk.pop_back();
            } else {
                stk.push_back(ch);
            }
        }
        return stk;
    }
};



int main() {
    string string1 = Solution::removeDuplicates("babbaca");
    cout << string1 << endl;
    return 0;
}