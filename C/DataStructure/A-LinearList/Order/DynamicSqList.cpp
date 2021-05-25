// 顺序表示的动态分配顺序表
#include <cstdlib>

#define InitSize 10   // 表长度的初始定义
#define ElemType int  // 设置该顺序表元素类型为 int

typedef struct {
    ElemType *data;       // 指示动态分配数组的指针
    int MaxSize, length;  // 数组的最大容量和当前个数
} DynamicSqList;          // 动态分配数组顺序表的类型定义

// 初始化
void InitList(DynamicSqList &L) {
    // 使用malloc函数申请一片连续的储存空间
    L.data = (int *)malloc(InitSize * sizeof(int));
    L.length = 0;
    L.MaxSize = InitSize;
}

/**
 * 动态增加数组的长度
 * @param L 顺序表
 * @param len 在原基础上扩展的大小
 */
void IncreaseSize(DynamicSqList &L, int len) {
    int *p = L.data;
    L.data = (int *)malloc((L.MaxSize + len) * sizeof(int));
    for (int i = 0; i < L.length; i++) {  // 将数据复制到新区域
        L.data[i] = p[i];
    }
    L.MaxSize += len;  // 增加顺序表的最大长度
    free(p);           // 释放原来的内存空间
}

int main() {
    // 声明一个顺序表
    DynamicSqList L;
    DynamicSqList P;

    // C 的初始动态分配语句
    L.data = (ElemType *)malloc(sizeof(ElemType) * InitSize);

    // C++ 的初始动态分配语句
    P.data = new ElemType[InitSize];

    // ...  相关操作
    return 0;
}