# 딸기 0 -> 초코 1 -> 바나나 2
N = int(input())  # 우유 가게 수
store = list(map(int, input().split(' ')))  # 가게별 파는 우유
now = 0  # 현재 마실 수 있는 우유
answer = 0  # 마실 수 있는 우유 개수
for i in store:
    if i == now % 3:
        now += 1
        answer += 1

print(answer)
