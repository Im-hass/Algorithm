N = int(input())  # 단어의 개수
arr = []
for _ in range(N):
    arr.append(input())

set_list = list(set(arr))
set_list.sort(key=lambda x: (len(x), x))

for i in set_list:
    print(i, end='\n')
