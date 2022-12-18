# 병합 정렬
def merge_sort(array):
    if len(array) <= 1:  # 배열의 길이가 1이면 반환
        return array
    mid = len(array) // 2  # 반으로 분할
    left = merge_sort(array[:mid])  # 분할된 arr(앞)로 재귀
    right = merge_sort(array[mid:])  # 분할된 arr(뒤)로 재귀

    L, R, K = 0, 0, 0  #

    while L < len(left) and R < len(right):
        if left[L] < right[R]:
            array[K] = left[L]
            L += 1
        else:
            array[K] = right[R]
            R += 1
        K += 1

    if L == len(left):
        while R < len(right):
            array[K] = right[R]
            R += 1
            K += 1
    elif R == len(right):
        while L < len(left):
            array[K] = left[L]
            L += 1
            K += 1
    return array


N = int(input())
arr = []
for _ in range(N):
    arr.append(int(input()))

print('\n'.join(list(map(str, merge_sort(arr)))))
