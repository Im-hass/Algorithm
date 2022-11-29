A, B = map(int, input().split()) # 현재 시간, 분
C = int(input()) # 요리 하는데 필요한 시간(분)

B += C

if B >= 60: # 60분 이거나 넘을 경우
    A += B // 60 # 넘은 시간 추가
    B %= 60 # 남은 분

if A >= 24: # 24시간을 넘을 경우
    A %= 24

print(A, B)

# 다른 사람 풀이
# H, M = map(int, input().split())
# timer = int(input())
#
# H += timer // 60
# M += timer % 60
#
# if M >= 60:
#     H += 1
#     M -= 60
# if H >= 24:
#     H -= 24
#
# print(H, M)