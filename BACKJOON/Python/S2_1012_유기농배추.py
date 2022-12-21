import sys
sys.setrecursionlimit(10000)  # 재귀 제한 해제


def dfs(x, y):
    dx = [0, 1, 0, -1]  # 상 우 하 좌
    dy = [-1, 0, 1, 0]

    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]

        if 0 <= nx < M and 0 <= ny < N:
            if arr[ny][nx] == 1:
                arr[ny][nx] = 0
                dfs(nx, ny)


T = int(input())

for _ in range(T):
    M, N, K = map(int, input().split(' '))  # 배추밭 가로, 세로, 배추가 심어진 위치 개수
    answer = 0  # 정답
    arr = [[0] * M for _ in range(N)]  # [[가로] * 세로]
    for _ in range(K):
        x, y = map(int, input().split(' '))  # 배추가 있는 좌표
        arr[y][x] = 1  # 배추 표시

    # 배추밭 전체 탐색 하며 DFS
    for x in range(M):
        for y in range(N):
            if arr[y][x] == 1:
                dfs(x, y)
                answer += 1

    print(answer)
