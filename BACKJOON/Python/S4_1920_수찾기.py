def binary_search(array, target, start, end):
    while start <= end:
        mid = (start + end) // 2

        if array[mid] == target:
            return 1
        elif array[mid] > target:
            end = mid - 1
        else:
            start = mid + 1
    return 0


N = int(input())
A = list(map(int, input().split(' ')))

M = int(input())
arr = list(map(int, input().split(' ')))

# arr이 A 안에 존재하는지 확인
# 존재하면 1
# 존재하지 않으면 0

A.sort()

for i in arr:
    print(binary_search(A, i, 0, len(A) - 1))
