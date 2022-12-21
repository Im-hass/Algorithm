array = [7, 5, 9, 0, 3, 1, 6, 2, 4, 8]

for i in range(len(array)):
    min_idx = i  # 가장 작은 원소의 인덱스
    for j in range(i + 1, len(array)):
        if array[min_idx] > array[j]:  # 가장 작은 원소 값보다 현재 값이 작다면
            min_idx = j  # 가장 작은 원소의 인덱스 교체
    array[i], array[min_idx] = array[min_idx], array[i]  # swap

print(array)  # [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
