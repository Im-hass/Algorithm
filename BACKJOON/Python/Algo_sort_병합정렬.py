# print 있는거
array = [7, 5, 9, 0, 3, 1, 6, 2, 4, 8]


def merge_sort(array):  # 병합 정렬
    print('호출')
    if len(array) <= 1:  # 배열의 길이가 1이면 반환
        print('리턴', array)
        return array

    print('array', array)
    print('mid', len(array) // 2)
    print('left_arr', array[:len(array) // 2])
    print('right_arr', array[len(array) // 2:])
    print()

    mid = len(array) // 2  # 반으로 분할
    left_arr = merge_sort(array[:mid])  # 분할된 arr(앞)로 재귀
    right_arr = merge_sort(array[mid:])  # 분할된 arr(뒤)로 재귀

    print('----------------------------------')
    # L : left_arr 인덱스
    # R : right_arr 인덱스
    # K : array 인덱스(array : left_arr + right_arr 길이의 정렬된 배열)
    L, R, K = 0, 0, 0

    # 분할된 배열 끼리 비교
    print('>>>> 분할된 배열 끼리 비교')
    print('left_arr', left_arr)
    print('right_arr', right_arr)
    print('L, R, K', L, R, K)

    while L < len(left_arr) and R < len(right_arr):
        if left_arr[L] < right_arr[R]:
            array[K] = left_arr[L]
            L += 1
        else:
            array[K] = right_arr[R]
            R += 1
        K += 1
        print('array', array)
        print('L, R, K', L, R, K)

    print()
    # left_arr 또는 right_arr 정렬이 끝났을 경우, 남은 한 쪽을 정렬
    print('>>>> 남은 한 쪽 정렬')
    if L == len(left_arr):
        print('left 끝남')
        while R < len(right_arr):
            array[K] = right_arr[R]
            R += 1
            K += 1
            print('array', array)
            print('L, R, K', L, R, K)
    elif R == len(right_arr):
        print('right 끝남')
        while L < len(left_arr):
            array[K] = left_arr[L]
            L += 1
            K += 1
            print('array', array)
            print('L, R, K', L, R, K)
    print('리턴', array)
    print('==================================')
    return array


print(merge_sort(array))  # [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]


# # print 제거
# array = [7, 5, 9, 0, 3, 1, 6, 2, 4, 8]
#
#
# def merge_sort(array):  # 병합 정렬
#     if len(array) <= 1:  # 배열의 길이가 1이면 반환
#         return array
#     mid = len(array) // 2  # 반으로 분할
#     left_arr = merge_sort(array[:mid])  # 분할된 arr(앞)로 재귀
#     right_arr = merge_sort(array[mid:])  # 분할된 arr(뒤)로 재귀
#
#     # L : left_arr 인덱스
#     # R : right_arr 인덱스
#     # K : array 인덱스(array : left_arr + right_arr 길이의 정렬된 배열)
#     L, R, K = 0, 0, 0
#
#     # 분할된 배열 끼리 비교
#     while L < len(left_arr) and R < len(right_arr):
#         if left_arr[L] < right_arr[R]:
#             array[K] = left_arr[L]
#             L += 1
#         else:
#             array[K] = right_arr[R]
#             R += 1
#         K += 1
#
#     # left_arr 또는 right_arr 정렬이 끝났을 경우, 남은 한 쪽을 정렬해줌
#     if L == len(left_arr):
#         while R < len(right_arr):
#             array[K] = right_arr[R]
#             R += 1
#             K += 1
#     elif R == len(right_arr):
#         while L < len(left_arr):
#             array[K] = left_arr[L]
#             L += 1
#             K += 1
#     return array
#
#
# print(merge_sort(array))  # [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
