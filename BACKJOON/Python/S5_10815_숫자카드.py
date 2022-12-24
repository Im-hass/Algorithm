def binay_search(arr, target, start, end):
    if start > end:
        return False
    mid = (start + end) // 2

    if arr[mid] == target:
        return True
    elif arr[mid] > target:
        return binay_search(arr, target, start, mid - 1)
    else:
        return binay_search(arr, target, mid + 1, end)


N = int(input())  # 상근가 가진 숫자 카드의 개수
my = list(map(int, input().split(' ')))  # 상근이가 가진 숫자 카드 목록
my.sort()

M = int(input())  # 주어 지는 숫자 카드의 개수
li = list(map(int, input().split(' ')))  # 상근이가 가졌는지 확인해야 하는 숫자 카드 목록

for i in range(M):
    if binay_search(my, li[i], 0, len(my) - 1):
        print(1, end=' ')
    else:
        print(0, end=' ')

# set으로 풀거나, Counter 라이브러리를 사용하는 방법으로도 풀 수 있음