submit = [0] * 31
for _ in range(28):
    submit[int(input())] = 1

ans_res = list(filter(lambda x: submit[x] != 1, range(len(submit))))
for i in range(1, len(ans_res)):
    print(ans_res[i])

# 5번 줄 ~ : if not을 이용해 바로 print해주는 방법도 있음

# 다른 풀이 : 1 ~ 30까지 값이 들어간 list에서 remove() 메서드로 input() 값을 제거하고 출력한다
# num = [i for i in range(1, 31)]
# for _ in range(28):
#     data = int(input())
#     num.remove(data)
# for i in range(len(num)):
#     print(num[i])