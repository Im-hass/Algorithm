T = int(input())

for _ in range(T):
    A, B = input().split(' ')
    arrA = [0] * 26
    arrB = [0] * 26
    answer = False

    for i in A:
        arrA[ord(i) - 97] += 1

    for i in B:
        arrB[ord(i) - 97] += 1

    if arrA == arrB:
        print(A, '&', B, 'are anagrams.')
    else:
        print(A, '&', B, 'are NOT anagrams.')
