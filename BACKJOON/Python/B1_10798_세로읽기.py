ls = []
maxL = 0
for i in range(5):
    ls.append(list(input()))
    if maxL < len(ls[i]):
        maxL = len(ls[i])

for i in ls:
    if maxL > len(i):
        for _ in range(maxL-len(i)):
            i.append(-1)

for i in range(maxL):
    # print('i', i)
    for j in range(len(ls)):
        # print('j', j)
        if ls[j][i] != -1:
            print(ls[j][i], end='')
