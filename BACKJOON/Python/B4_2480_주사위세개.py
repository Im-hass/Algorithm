dice = sorted(list(map(int, input().split())), reverse=True)

cnt = 0 # 같은 눈 개수
same = 0 # 같은 눈
for i in range(1, len(dice)): # dice 값을 하나씩 비교 하며 같은 눈을 찾음
    if dice[i - 1] == dice[i]:
        cnt += 1
        same = dice[i]

if cnt == 0: # 모두 다른 눈이 나올 경우
    print(dice[0] * 100)
elif cnt == 1: # 같은 눈이 2개 나오는 경우
    print(1000 + same * 100)
else: # 같은 눈이 3개 나오는 경우
    print(10000 + same * 1000)

# 다른 사람의 풀이
# a, b, c = map(int, input().split())
#
# if a == b == c:
#     print(10000 + a * 1000)
# elif a == b:
#     print(1000 + a * 100)
# elif a == c:
#     print(1000 + a * 100)
# elif b == c:
#     print(1000 + b * 100)
# else:
#     print(100 * max(a, b, c))
