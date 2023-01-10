from collections import deque
import sys
input = sys.stdin.readline

N = int(input())  # 게임 구역의 크기
board = []  # 게임판의 구역(맵)
for _ in range(N):
    board.append(list(map(int, input().split(' '))))

isVisited = [[False] * N for _ in range(N)]  # 방문 저장

def dfs(y, x):
    if y < 0 or y >= N or x < 0 or x >= N or isVisited[x][y]:  # 영역을 벗어났을 경우, 이미 방문했을 경우 return
        return
    
    if board[x][y] == -1 :  # 승리 지점일 경우
        isVisited[x][y] = True
        return
    else:
        v = board[x][y]  # 현재 인덱스 위치의 값(이동할 수 있는 칸 수)
        isVisited[x][y] = True  # 방문 표시

    ny = y + v
    nx = x + v
    dfs(ny, x)
    dfs(y, nx)


dfs(0, 0)

if isVisited[-1][-1]:  # 게임 구역의 끝 점에 방문한 적이 있는 경우(승리)
    print('HaruHaru')
else:
    print('Hing')
