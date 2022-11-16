# https://www.acmicpc.net/problem/3003

originArr = [1, 1, 2, 2, 2, 8]

strArr = input().split(' ')
intArr = list(map(int, strArr))
ans = []
for i in range(len(intArr)):
    ans.append(str(originArr[i] - intArr[i]))

print(' '.join(ans))

# 5, 6번을 한 줄로 적을 수 있음
# intArr = list(map(int, input().split(' ')))

# ans에 따로 담지 않고 바로 print 해주면 됨
# for i in range(6):
#   print(originArr[i] - intArr[i], end=' ')
