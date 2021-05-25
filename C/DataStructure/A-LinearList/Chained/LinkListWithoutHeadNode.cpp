// 单链表 不带头结点
#include <cstdlib>

#define ElemType int  // 设置该单链表元素类型为 int
typedef struct LNode {
    ElemType data;       // 每个结点存放的一个数据元素
    struct LNode *next;  // 指针指向下一个结点
} LNode, *LinkList;

// 初始化不带头结点的空单链表函数
bool InitList(LinkList &L) {
    L = nullptr;
    return true;
}

// 初始化带头结点的空单链表函数
bool InitList(LinkList &L) {
    L = (LNode *)malloc(sizeof(LNode));  // 分配一个头结点
    if (L == nullptr) {                  // 内存不足，分配失败
        return false;
    }
    L->next = nullptr;  // 头结点之后暂时还没有结点
    return true;
}

// 按位序插入（不带头结点）
bool ListInsert(LinkList &L, int i, int e) {
    if (i < 1) {
        return false;
    }

    if (i == 1) {  // 插入第1个结点操作与其他结点操作不同
        LNode *s = (LNode *)malloc(sizeof(LNode));
        s->data = e;
        s->next = L;
        L = s;
        return true;
    }

    LNode *p;   // 指针p指向当前扫描到的结点
    int j = 1;  // 当前p指向的是第几个结点
    p = L;      // L指向头结点，头结点是第0个结点
    while (p != nullptr && j < i - 1) {  // 循环找到第 i-1 个结点
        p = p->next;
        j++;
    }
    if (p == nullptr) {  // i值不合法
        return false;
    }
    LNode *s = (LNode *)malloc(sizeof(LNode));
    s->data = e;
    s->next = p->next;
    p->next = s;  // 将结点s连接到p之后
    return true;
}