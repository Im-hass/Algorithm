def factor(n):
    if n == 0 or n == 1:
        return 1
    return n * factor(n - 1)


N = int(input())

# for문
# answer = 1
# for i in range(1, N + 1):
#     answer *= i
# print(answer)

# 재귀
print(factor(N))
