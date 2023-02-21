# 시간초과
# N = int(input())
# arrN = list(map(int, input().split(' ')))  # 상근이가 가진 숫자 카드
#
# M = int(input())
# arrM = list(map(int, input().split(' ')))  # 상근이가 몇 개 가지고 있는 숫자 카드인지 구해야 할 정수
#
# cnt = [0] * len(arrM)
#
# for i in range(len(arrM)):
#     if arrM[i] in arrN:
#         cnt[i] = arrN.count(arrM[i])
#
# print(' '.join(map(str, cnt)))


N = int(input())
arrN = list(map(int, input().split(' ')))  # 상근이가 가진 숫자 카드

M = int(input())
arrM = list(map(int, input().split(' ')))  # 상근이가 몇 개 가지고 있는 숫자 카드인지 구해야 할 정수

cnt = {}

for i in arrN:
    if i in cnt:
        cnt[i] += 1
    else:
        cnt[i] = 1

for i in arrM:
    if i in cnt:
        print(cnt[i], end=' ')
    else:
        print(0, end=' ')
