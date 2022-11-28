score = int(input())

if 90 <= score:  # 90 ~ 100점은 A
    print('A')
elif 80 <= score:  # 80 ~ 89점은 B
    print('B')
elif 70 <= score:  # 70 ~ 79점은 C
    print('C')
elif 60 <= score:  # 60 ~ 69점은 D
    print('D')
else:  # 나머지 점수는 F
    print('F')
