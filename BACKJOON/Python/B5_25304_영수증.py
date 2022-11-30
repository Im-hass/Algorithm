X = int(input())  # 영수증 총 금액
N = int(input())  # 구매한 물건의 종류 수
total = 0  # 구매한 총 금액

for i in range(N):
    a, b = map(int, input().split(' '))
    total += a * b

if X == total:
    print('Yes')
else:
    print('No')
