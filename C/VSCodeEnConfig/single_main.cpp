#include <iostream>

using namespace std;

void swap(int &a, int &b) {
    int temp;
    temp = a;
    a = b;
    b = temp;
}

int main() {
    int val1 = 10;
    int val2 = 20;
    cout << "Before swap:" << endl;
    cout << "val1 = " << val1 << endl;
    cout << "val2 = " << val2 << endl;

    swap(val1, val2);

    cout << "After swap:" << endl;
    cout << "val1 = " << val1 << endl;
    cout << "val2 = " << val2 << endl;

    return 0;
}