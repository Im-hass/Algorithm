# # 퀵 정렬 제출, 116ms
# import sys
# sys.setrecursionlimit(10**6)
#
#
# def quick_sort(arr):  # 퀵 정렬
#     if len(arr) <= 1:
#         return arr
#
#     pivot = arr[0]
#     tail = arr[1:]
#
#     # 내림차순 정렬
#     left = [i for i in tail if i >= pivot]  # pivot과 같거나 큰 값
#     right = [i for i in tail if i < pivot]  # pivot 보다 작은 값
#
#     return quick_sort(left) + [pivot] + quick_sort(right)
#
#
# N, k = map(int, input().split(' '))  # 응시자 수 N, 상을 받는 사람 수 k
# x = list(map(int, input().split(' ')))  # 각 학생의 점수 x
# sort_list = quick_sort(x)  # 내림차순 정렬된 리스트
#
# print(sort_list[k - 1])

# 내장 함수 제출, 40ms
N, k = map(int, input().split(' '))  # 응시자 수 N, 상을 받는 사람 수 k
x = list(map(int, input().split(' ')))  # 각 학생의 점수 x
x.sort(reverse=True)  # 내림차순 정렬된 리스트

print(x[k - 1])
