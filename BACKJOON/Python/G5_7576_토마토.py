from collections import deque

dx = [0, 1, 0, -1]  # 상우하좌
dy = [-1, 0, 1, 0]
queue = deque()  # 큐

M, N = map(int, input().split(' '))  # 상자의 가로 칸 수, 세로 칸 수
box = []  # 상자에 저장된 토마토 정보
answer = []  # 걸린 일 수

for _ in range(N):  # 토마토 정보 입력 받기
    box.append(list(map(int, input().split(' '))))


def bfs():  # bfs
    while queue:  # 큐가 빌 때까지
        y, x = queue.popleft()

        for i in range(4):  # 네 방향 확인
            ny = y + dy[i]
            nx = x + dx[i]
            if N > ny > -1 and M > nx > -1:  # 상자 내인 경우
                if box[ny][nx] == 0:  # 안 익은 토마토인 경우
                    queue.append([ny, nx])
                    box[ny][nx] = box[y][x] + 1  # 이전 일자에서 +1일


for i in range(N):
    for j in range(M):
        if box[i][j] == 1:  # 익은 토마토일 경우
            queue.append((i, j))  # 큐에 추가

bfs()  # bfs 실행

res = 0  # 정답(익는데 걸리는 최소 일수)

# 상자를 돌며 안 익은 토마토 여부와 익는데 걸린 최소 일수 확인
for i in box:
    if 0 in i:  # 안 익은 토마토가 있는 경우
        res = -1  # 익을 수 없음 -1, 확인 종료
        break

    for j in i:
        if res <= j:
            res = j

if res != -1:  # 안 익은 토마토가 없는 경우, 익는데 걸린 최소 일수 출력
    print(res - 1)
else:
    print(res)
