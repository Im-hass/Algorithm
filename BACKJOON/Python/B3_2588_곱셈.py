num1 = int(input())  # 첫 번째 세 자리 수
num_str = input()  # 문자열 형태의 두 번째 세 자리 수
num2 = list(map(int, list(num_str)))  # 두 번째 세 자리 수의 각 자릿수를 담은 배열

print(num1 * num2[2])
print(num1 * num2[1])
print(num1 * num2[0])
print(num1 * int(num_str))

# 풀이2
# num1 = int(input()) # 첫 번째 세 자리 수
# num2 = int(input()) # 두 번째 세 자리 수
#
# print(num1 * (num2 % 10))
# print(num1 * ((num2 % 100) // 10))
# print(num1 * (num2 // 100))
# print(num1 * num2)
