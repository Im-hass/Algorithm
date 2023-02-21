def dfs(y, x):
    # 2-1. dfs 종료 조건 검사
    if y < 0 or y >= N or x < 0 or x >= N:
        return False

    # 2-2. 방문 해야 하는 경우
    if array[y][x] == 1:
        global cnt
        cnt += 1
        # 2-3. 다시 방문하는 것을 방지하기 위해 값 변경
        array[y][x] = 0

        # 2-4. 해당 위치에서 상하좌우 4방향 검사
        for i in range(4):
            ny = y + dy[i]
            nx = x + dx[i]
            dfs(ny, nx)
        return True
    return False


array = []
dan = 0  # 단지 번호
cnt = 0  # 단지내 집 수
answer = []
dx = [0, 1, 0, -1]  # 시계방향(상우하좌)
dy = [-1, 0, 1, 0]

# 1. 단지 크기 및 단지 입력 받기
N = int(input())  # 지도의 크기(정사각형)
for _ in range(N):
    array.append(list(map(int, input())))

# 2. 단지를 순서대로 돌며 DSF
for y in range(N):
    for x in range(N):
        if dfs(y, x):
            # 3. 하나의 단지를 다 돌면 단지 개수 +1
            dan += 1
            # 4. 단지내 집 수 저장 및 초기화
            answer.append(cnt)
            cnt = 0

print(dan)
answer.sort()
for i in answer:
    print(i)
