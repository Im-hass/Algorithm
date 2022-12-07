T = int(input())
for _ in range(T):
    R, S = input().split(' ')
    answer = ''
    s = list(S)  # 각 문자 배열로 변환, 근데 변환하지 않아도 S로 반복문 가능

    for i in s:
        answer += i * int(R)  # 문자 R개 반복해서 추가

    print(answer)
