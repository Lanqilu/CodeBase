// 单链表
#include <cstdlib>
#include <iostream>

using namespace std;

#define ElemType int  // 设置该单链表元素类型为 int
typedef struct LNode {
    ElemType data;       // 每个结点存放的一个数据元素
    struct LNode *next;  // 指针指向下一个结点
} LNode, *LinkList;

/** 按位序插入（带头结点）
 *  @param L 单链表
 *  @param i 位序
 *  @param e 插入的元素
 */
bool ListInsert(LinkList &L, int i, int e) {
    if (i < 1) {
        return false;
    }

    // 找到第i-1个结点 GetElem
    LNode *p;   // 指针p指向当前扫描到的结点
    int j = 0;  // 当前p指向的是第几个结点
    p = L;      // L指向头结点，头结点是第0个结点
    while (p != nullptr && j < i - 1) {  // 循环找到第 i-1 个结点
        p = p->next;
        j++;
    }

    if (p == nullptr) {  // i值不合法
        return false;
    }

    // 将e插入到i-1结点之后 InsertNextNode
    LNode *s = (LNode *)malloc(sizeof(LNode));
    s->data = e;
    s->next = p->next;
    p->next = s;  // 将结点s连接到p之后
    return true;
}

/** 后插操作：在p结点之后插入元素e
 *  @param p 单链表的结点
 *  @param element 插入的元素
 */
bool InsertNextNode(LNode *p, int element) {
    if (p == nullptr) {
        return false;
    }
    LNode *s = (LNode *)malloc(sizeof(LNode));
    if (s == nullptr) {  // 内存分配失败
        return false;
    }
    s->data = element;
    s->next = p->next;
    p->next = s;
    return true;
}

/** 前插操作
 *  @param p 单链表的结点
 *  @param element 插入的元素
 */
bool InsertPriorNode(LNode *p, int element) {
    if (p == nullptr) {
        return false;
    }
    auto *s = (LNode *)malloc(sizeof(LNode));
    if (s == nullptr) {
        return false;
    }
    s->next = p->next;
    p->next = s;        // 新结点s连到p之后 ⭐
    s->data = p->data;  // 将p中元素覆盖到s中
    p->data = element;  // p中元素覆盖为e
    return true;
}

/** 按位序删除
 *  @param L 单链表
 *  @param i 需要删除元素的位序
 *  @param e 返回的元素的引用
 */
bool ListDelete(LinkList &L, int i, int &e) {
    if (i < 1) {
        return false;
    }
    // 找
    LNode *p;
    int j = 0;
    p = L;
    while (p != nullptr && j < i - 1) {
        p = p->next;
        j++;
    }
    // 判断
    if (p == nullptr || p->next == nullptr) {
        return false;
    }
    // 删除
    LNode *q = p->next;  // 使q指向被删除的结点
    e = q->data;         // 用e返回元素的值
    p->next = q->next;   // 将*q结点从链中断开
    free(q);             // 释放结点储存空间
    return true;
}

/** 删除节点
 * @param p 需要删除的结点
 */
bool DeleteNode(LNode *p) {
    if (p == nullptr) {
        return false;
    }
    LNode *q = p->next;       // 使q指向*p的后继结点
    p->data = p->next->data;  // 和后继结点交换数据域
    p->next = q->next;        // 将*q结点从链中断开
    free(q);                  // 释放后继结点的储存空间
    return true;
}

/** 按位查找，返回第i个元素
 * @param L 单链表
 * @param i 查找元素的位序
 */
LNode *GetElement(LinkList L, int i) {
    if (i < 0) {
        return nullptr;
    }
    LNode *p;
    int j = 0;
    p = L;
    while (p != nullptr && j < i) {
        p = p->next;
        j++;
    }
    return p;
}

/** 按值查找
 * @param L 单链表
 * @param e 查找的元素值
 */
LNode *LocateElem(LinkList L, int e) {
    LNode *p = L->next;
    // 从第一个结点开始查找数据域为e的结点
    while (p != nullptr && p->data != e) {
        p = p->next;
    }
    return p;
}

/** 求表的长度
 * @param L 单链表
 */
int Length(LinkList L) {
    int len = 0;
    LNode *p = L;
    while (p->next != nullptr) {
        p = p->next;
        len++;
    }
    return len;
}

// 头插法建立单链表
LinkList List_HeadInsert(LinkList &L) {
    LNode *s;
    int x;
    L = (LinkList)malloc(sizeof(LNode));
    L->next = nullptr;  // 初始空链表

    // 输入结点的数据
    int n;
    cout << "Enter size of LinkList: ";
    cin >> n;
    cout << "Enter elements: " << endl;

    int elem;
    for (int i = 0; i < n; i++) {
        cin >> elem;
        s = (LNode *)malloc(sizeof(LNode));  // 后插操作
        s->data = elem;
        s->next = L->next;
        L->next = s;
    }
    return L;
}

// 尾插法建立单链表
LinkList List_TailInsert(LinkList &L) {
    L = (LinkList)malloc(sizeof(LNode));  // 建立头结点
    LNode *s, *r = L;                     // r指针为表尾指针

    // 输入结点的数据
    int n;
    cout << "Enter size of LinkList: ";
    cin >> n;
    cout << "Enter elements: " << endl;

    int elem;
    for (int i = 0; i < n; i++) {
        cin >> elem;
        s = (LNode *)malloc(sizeof(LNode));
        s->data = elem;
        r->next = s;
        r = s;  // r指向新的表尾结点
    }
    r->next = nullptr;
    return L;
}

// 打印单链表
int PrintLinkList(LinkList &L) {
    if (L == nullptr) {
        return 0;
    }
    if (L->next == nullptr) {
        cout << L->data << endl;
        return 0;
    }
    while (L->next->next != nullptr) {
        L = L->next;
        cout << L->data << " -> ";
    }
    // 处理最后一个元素
    cout << L->next->data << endl;
    return 0;
}

int main() {
    // 头插法建立单链表
    // LinkList L = List_HeadInsert(L);

    // 尾插法建立单链表
    LinkList L = List_TailInsert(L);

    // 求表的长度
    cout << "Length(L) = " << Length(L) << endl;

    // 输出单链表
    PrintLinkList(L);

    // 按位序插入（带头结点）
    // ListInsert(L, 1, 0);
    // PrintLinkList(L);

    // 按位查找并删除
    DeleteNode(GetElement(L, 2));
    PrintLinkList(L);
}