T = int(input())  # 테스트케이스
for _ in range(T):
    cnt = int(input())  # 카드 개수
    before = input().split(' ')  # 게임 전 카드
    after = input().split(' ')  # 게임 후 카드
    before.sort()
    after.sort()

    if before == after:
        print('NOT CHEATER')
    else:
        print('CHEATER')
