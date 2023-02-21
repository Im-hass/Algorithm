# # 반복문 풀이
# A, P = map(int, input().split(' '))
# D = [A]  # 수열
#
# while True:
#     temp = 0
#
#     for s in str(D[-1]):
#         temp += int(s) ** P
#
#     if temp in D:
#         break
#
#     D.append(temp)
#
# print(D.index(temp))


# DFS 풀이
A, P = map(int, input().split(' '))
D = [0] * 236197  # 9 ** 5 + 9 ** 5 + 9 ** 5 + 9 ** 5 = 최대 인덱스의 값
i = 1


def cal(a):  # 제곱 계산 하는 함수
    result = 0
    for i in str(a):
        result += pow(int(i), P)
    return result


def dfs(n, i, D):
    if D[n] != 0:
        return D[n] - 1

    D[n] = i
    i += 1
    result = cal(n)
    return dfs(result, i, D)


print(dfs(A, i, D))
