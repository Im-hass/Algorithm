def dfs(idx, arr):  # dfs를 이용한 조합
    if len(arr) == r:  # 6개의 숫자를 다 뽑은 경우
        answer.append(arr)  # 한 가지 조합 완성, answer에 추가
        return

    for i in range(idx, k):  # 0 ~ k, 1 ~ k, 2 ~ k, ..., idx를 1씩 올리며 조합 하기
        dfs(i + 1, arr + [S[i]])


while True:
    input_arr = list(map(int, input().split(' ')))

    if input_arr == [0]:  # 0이 들어 오면 반복 종료
        break

    k = input_arr[0]  # 숫자 개수 k개
    S = input_arr[1:]  # k개의 숫자로 구성된 집합 S
    r = 6  # 뽑아야 할 숫자 개수 : 6개
    answer = []  # 정답

    dfs(0, [])  # 조합 만들기

    for i in answer:
        print(' '.join(list(map(str, i))))
    print()
