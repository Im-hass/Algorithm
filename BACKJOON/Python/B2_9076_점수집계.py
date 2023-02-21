def quick_sort(arr):
    if len(arr) <= 1:
        return arr

    pivot = arr[0]
    tail = arr[1:]

    left = [x for x in tail if pivot <= x]
    right = [x for x in tail if pivot > x]

    return quick_sort(left) + [pivot] + quick_sort(right)


T = int(input())
for _ in range(T):
    score = quick_sort(list(map(int, input().split(' '))))

    if abs(score[1] - score[3]) >= 4:
        print('KIN')
    else:
        print(sum(score[1:4]))
