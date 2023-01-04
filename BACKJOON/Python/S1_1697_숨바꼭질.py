from collections import deque

N, K = map(int, input().split(' '))  # 수빈이의 위치, 동생의 위치
MAX = 100000  # 위치 최댓값
dist = [0] * (MAX + 1)  # 인덱스 = 위치, 값 = 해당 위치로 이동할 때 걸린 이동 횟수


def bfs():
    queue = deque()
    queue.append(N)  # 수빈이의 시작 위치를 큐에 삽입

    while queue:
        S = queue.popleft()  # 수빈이의 위치

        if S == K:  # 둘의 위치가 겹치면 종료
            print(dist[S])
            break

        for nS in (S - 1, S + 1, S * 2):  # ex) 현재 위치 S가 5일 경우, 5에서 -1, +1, *2 했을 때 각각의 경우에 대해 확인
            if 0 <= nS <= MAX and not dist[nS]:
                dist[nS] = dist[S] + 1  # dist[S]에서 다음(dist[nS])으로 가면 이동 횟수 + 1
                queue.append(nS)
                # print('dist[', nS, ']', dist[nS], ', dist[', S, ']', dist[S])


bfs()
