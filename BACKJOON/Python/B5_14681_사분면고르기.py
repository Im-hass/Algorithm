x = int(input())
y = int(input())

if x > 0 and y > 0:  # 둘 다 양수
    print(1)
elif x < 0 and y < 0:  # 둘 다 음수
    print(3)
elif x < 0 < y:  # x는 음수, y는 양수
    print(2)
else:  # y는 음수, x는 양수
    print(4)
