N = int(input())
A = list(map(int, input().split(' ')))
arr = [0] * 1000001
for i in A:
    arr[i] += 1

for i in range(1, len(arr)):
    if arr[i] == 0:
        print(i)
        break
