import sys

input = sys.stdin.readline
word = list(input().rstrip('\n'))
res = []

for i in range(1, len(word) - 1):
    for j in range(i + 1, len(word)):
        # 1. 세 단어로 나누기
        first = word[:i]  # 첫 번째 단어
        second = word[i:j]  # 두 번째 단어
        third = word[j:]  # 세 번째 단어

        # 2. 각각 뒤집기
        first.reverse()
        second.reverse()
        third.reverse()

        # 3. 합치기
        res.append(''.join(first + second + third))

print(min(res))
