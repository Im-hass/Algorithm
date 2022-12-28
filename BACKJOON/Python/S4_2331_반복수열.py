A, P = map(int, input().split(' '))
D = [A]  # 수열

while True:
    temp = 0

    for s in str(D[-1]):
        temp += int(s) ** P

    if temp in D:
        break

    D.append(temp)

print(D.index(temp))
