N = int(input())
P = list(map(int, input().split(' ')))
answer = []
total = 0
for i in sorted(P):
    total += i
    answer.append(total)

print(sum(answer))

# 다른 방식
# for x in range(1, n+1):
#     answer += sum(peoples[0:x])  # 리스트의 0번째 수부터 x번째 수까지를 더해줍니다.
