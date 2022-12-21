# print 있는거
array = [7, 5, 9, 0, 3, 1, 6, 2, 4, 8]


def quick_sort(array):
    print('호출')
    # 리스트가 하나 이하의 원소만을 담고 있다면 종료
    if len(array) <= 1:
        print('리턴', array)
        return array

    pivot = array[0]  # 피벗은 첫 번째 원소
    tail = array[1:]  # 피벗을 제외한 리스트

    left_arr = [x for x in tail if x <= pivot]  # 분할된 왼쪽, 피벗 보다 작거나 같은 값
    right_arr = [x for x in tail if x > pivot]  # 분할된 오른쪽, 피벗 보다 큰 값

    print('array', array)
    print('pivot', pivot)
    print('tail', tail)
    print('left_arr', left_arr)
    print('right_arr', right_arr)
    print()

    # 분할 이후 왼쪽 부분과 오른쪽 부분에서 각각 정렬을 수행하고, 전체 리스트 반환
    print('리턴', quick_sort(left_arr) + [pivot] + quick_sort(right_arr))
    print('----------------------------------')
    return quick_sort(left_arr) + [pivot] + quick_sort(right_arr)


print(quick_sort(array))  # [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]


# # print 제거
# array = [7, 5, 9, 0, 3, 1, 6, 2, 4, 8]
#
#
# def quick_sort(array):
#     # 리스트가 하나 이하의 원소만을 담고 있다면 종료
#     if len(array) <= 1:
#         return array
#
#     pivot = array[0]  # 피벗은 첫 번째 원소
#     tail = array[1:]  # 피벗을 제외한 리스트
#
#     left_arr = [x for x in tail if x <= pivot]  # 분할된 왼쪽
#     right_arr = [x for x in tail if x > pivot]  # 분할된 오른쪽
#
#     # 분할 이후 왼쪽 부분과 오른쪽 부분에서 각각 정렬을 수행하고, 전체 리스트 반환
#     return quick_sort(left_arr) + [pivot] + quick_sort(right_arr)
#
#
# print(quick_sort(array))  # [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
#
# # 참고
# # 리스트 컴프리헨션, 1과 2는 동일함
# # 1
# a = []
# for x in range(5):
#     a.append(x)
#
# # 2
# a = [x for x in range(5)]
