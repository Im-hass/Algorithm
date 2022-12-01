# 가로, 세로의 크기가 각각 100인 정사각형 모양의 흰색 도화지
# 가로, 세로의 크기가 각각 10인 정사각형 모양의 검은색 색종이
# 색종이의 왼쪽 변과 도화지의 왼쪽 변 사이의 거리
# 색종이의 아래쪽 변과 도화지의 아래쪽 변 사이의 거리

cnt = int(input())  # 색종이의 수
answer = 0
paper = []  # 도화지
for i in range(100):  # 도화지 초기화
    paper.append([0] * 100)

for _ in range(cnt):
    # x: 색종이의 왼쪽 변과 도화지의 왼쪽 변 사이의 거리
    # y: 색종이의 아래쪽 변과 도화지의 아래쪽 변 사이의 거리
    x, y = map(int, input().split(' '))
    x -= 1
    y -= 1

    for i in range(10):
        for j in range(10):
            paper[99 - (y + 10) + i][x + j] = 1

for i in range(100):
    for j in range(100):
        if paper[i][j] == 1:
            answer += 1

print(answer)

# 다른 사람의 풀이
# N = int(input())
# paper = [[0 for _ in range(101)] for _ in range(101)]
#
# for _ in range(N):
#     x, y = map(int, input().split())
#     for i in range(x, x+10):
#         for j in range(y, y+10):
#             paper[i][j] = 1
#
# answer = 0
# for row in paper:
#     answer += row.count(1)
# print(answer)

# 초기화 시 주의
# test1 = [[0] * 3] * 3
# test1[0][0] = 1
# test1[0][1] = 1
# test1[0][2] = 1
# print('test1', test1) # test1 [[1, 1, 1], [1, 1, 1], [1, 1, 1]]
#
# test2 = [[0] * 3 for _ in range(3)]
# test2[0][0] = 1
# test2[0][1] = 1
# test2[0][2] = 1
# print('test2', test2) # test2 [[1, 1, 1], [0, 0, 0], [0, 0, 0]]
