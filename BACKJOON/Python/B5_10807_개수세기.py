N = int(input())
arr = list(map(int, input().split(" ")))
v = int(input())
answer = list(filter(lambda x: x == v, arr))
print(len(answer))

# 4~5번: filter 대신 count() 메서드를 사용하면 개수를 셀 수 있음.
# => print(arr.count(v))