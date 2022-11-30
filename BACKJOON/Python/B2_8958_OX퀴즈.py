T = int(input())  # 테케

for _ in range(T):
    result = list(input())  # 퀴즈 결과 배열
    cnt = 0  # 연속된 점수
    score = 0  # 누적 점수

    for i in result:
        if i == 'O':
            cnt += 1
            score += cnt
        else:
            cnt = 0

    print(score)
