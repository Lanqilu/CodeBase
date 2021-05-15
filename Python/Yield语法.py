def fibonacci(n):
    a = 0
    b = 1
    nums = []
    for _ in range(n):
        nums.append(a)
        a, b = b, a+b
    return nums


def fibonacciByYield(n):
    a = 0
    b = 1
    for _ in range(n):
        yield a
        a, b = b, a+b


print(fibonacci(10))

for i in fibonacciByYield(10):
    print(i)