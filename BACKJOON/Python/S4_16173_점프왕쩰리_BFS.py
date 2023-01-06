from collections import deque
import sys
input = sys.stdin.readline

N = int(input())  # 게임 구역의 크기
board = []  # 게임판의 구역(맵)
for _ in range(N):
    board.append(list(map(int, input().split(' '))))

isVisited = [[False] * N for _ in range(N)]  # 방문 저장

def bfs(y, x):
    queue = deque()  # 큐
    queue.append((y, x))
    isVisited[y][x] = True

    while queue:
        y, x = queue.popleft()
        v = board[y][x]  # 현재 인덱스 위치의 값(이동할 수 있는 칸 수)

        if v == -1:  # 승리 지점일 경우
            return True

        ny = y + v
        nx = x + v
        if ny < N and not isVisited[ny][x]:  # 아래쪽으로 v칸 갈 수 있는 경우
            queue.append((ny, x))
            isVisited[ny][x] = True
        if nx < N and not isVisited[y][nx]:  # 오른쪽으로 v칸 갈 수 있는 경우
            queue.append((y, nx))
            isVisited[y][nx] = True
    return False  # 큐가 빌 때까지 -1에 도달하지 못한 경우

if bfs(0, 0):
    print('HaruHaru')
else:
    print('Hing')
