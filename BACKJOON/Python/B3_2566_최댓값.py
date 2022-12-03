max = 0  # 최댓값
row = 1  # 최댓값의 행 번호 1 ~ 9
col = 1  # 최댓값의 열 번호 1 ~ 9

for i in range(9):
    line = list(map(int, input().split(' ')))
    for j in range(9):
        if line[j] > max:  # 입력된 값이 최댓값일 경우
            max = line[j]
            row = i + 1
            col = j + 1

print(max)
print(row, col)
