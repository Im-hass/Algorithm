from collections import deque

dx = [0, 1, 0, -1]  # 상우하좌
dy = [-1, 0, 1, 0]

N, M = map(int, input().split(' '))  # 세로 N, 가로 M
maze = []  # 미로

for _ in range(N):
    maze.append(list(map(int, input())))


def bfs(y, x):  # bfs
    queue = deque()  # 큐
    queue.append((y, x))

    while queue:  # 큐가 빌 때까지
        y, x = queue.popleft()

        for i in range(4):  # 네 방향 확인
            ny = y + dy[i]
            nx = x + dx[i]

            if N > ny > -1 and M > nx > -1:  # 미로 내인 경우
                if maze[ny][nx] == 1:  # 이동할 수 있는 칸인 경우
                    queue.append((ny, nx))
                    maze[ny][nx] = maze[y][x] + 1

    return maze[N - 1][M - 1]


print(bfs(0, 0))
