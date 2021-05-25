// 顺序表示的静态分配顺序表
#include <iostream>
using namespace std;

#define MaxSize 10    // 定义线性表的最大长度
#define ElemType int  // 设置该顺序表元素类型为 int
typedef struct {
    ElemType data[MaxSize];  // 顺序表的元素
    int length;              // 顺序表的当前长度
} StaticSqList;              // 顺序表的类型定义 Sq:sequence

// 初始化一个顺序表
void InitList(StaticSqList &L) {
    for (int i = 0; i < MaxSize; i++) {
        L.data[i] = 0;  // 将所有数据元素设置默认值(可省略)
    }
    L.length = 0;  // 顺序表初始长度为0
}

// 基本操作

/** 插入操作
 * @param L 顺序表
 * @param i 位置
 * @param element 要插入的元素
 * @return 插入成功true，失败false
 */
bool ListInsert(StaticSqList &L, int i, int element) {
    // 判断i的范围是否有效
    if (i < 1 || i > L.length + 1) {
        return false;
    }
    // 储存已满不能插入
    if (L.length >= MaxSize) {
        return false;
    }
    // 将第i个元素及之后的元素后移
    for (int j = L.length; j >= i; j--) {
        L.data[j] = L.data[j - 1];
    }
    // 在位置 i 处放入e
    L.data[i - 1] = element;
    // 线性表长度加1
    L.length++;
    return true;
}

/** 删除操作
 * @param L
 * @param i
 * @param element
 * @return
 */
bool ListDelete(StaticSqList &L, int i, int &element) {
    // 判断i的范围是否有效
    if (i < 1 || i > L.length + 1) {
        return false;
    }
    // 将被删除的元素赋值给element
    element = L.data[i - 1];
    // 将第i个位置后的元素前移
    for (int j = i; j < L.length; j++) {
        L.data[j - 1] = L.data[j];
    }
    L.length--;
    return true;
}

/** 按位查找
 * @param L 顺序表
 * @param i 位序
 * @return 第i个位置的元素的值
 */
int GetElem(StaticSqList L, int i) { return L.data[i - 1]; }

/** 按值查找
 * @param L 顺序表
 * @param element 需要查找的元素值
 * @return 查找到则返回位序(索引+1)，否则返回0
 */
int LocateElem(StaticSqList L, int element) {
    for (int i = 0; i < L.length; ++i) {
        if (L.data[i] == element) {
            return i + 1;  // 下标为 i 的元素值等于 element,返回其位序 i+1
        }
    }
    return 0;
}

/** 打印顺序表
 * @param L 顺序表
 */
int PrintList(StaticSqList L) {
    for (int i = 0; i < L.length; ++i) {
        cout << "L[" << i << "]"
             << " = " << L.data[i] << endl;
    }
    return 0;
}

int main() {
    StaticSqList L;  // 声明一个顺序表
    InitList(L);     // 初始化顺序表
    // 插入 5 个元素
    ListInsert(L, 1, 0);
    ListInsert(L, 2, 1);
    ListInsert(L, 3, 2);
    ListInsert(L, 4, 3);
    ListInsert(L, 5, 4);
    // 输出顺序表
    PrintList(L);
    // 删除位序为3的元素并输出其值
    int deleted;
    ListDelete(L, 3, deleted);
    cout << "deleted = " << deleted << endl;
    // 输出删除后的顺序表
    PrintList(L);
    // 按位查找
    cout << "GetElem(L, 1) = " << GetElem(L, 1) << endl;
    // 按值查找
    cout << "LocateElem(L, 1) = " << LocateElem(L, 1) << endl;
    return 0;
}