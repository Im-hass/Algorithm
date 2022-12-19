array = [7, 5, 9, 0, 3, 1, 6, 2, 4, 8]

for i in range(0, len(array) - 1):  # 두 개씩 비교하므로 마지막 원소는 정렬이 완료된 상태로 친다
    for j in range(0, len(array) - i - 1):  # 한 바퀴를 돌 때마다 마지막 원소는 정렬이 완료된 상태가 된다
        if array[j] > array[j + 1]:  # 현재 원소가 다음(오른쪽) 원소 보다 클 경우
            array[j], array[j + 1] = array[j + 1], array[j]  # swap

print(array)  # [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
