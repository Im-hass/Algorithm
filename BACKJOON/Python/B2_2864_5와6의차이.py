A, B = input().split(' ')
minSum = int(A.replace('6', '5')) + int(B.replace('6', '5'))
maxSum = int(A.replace('5', '6')) + int(B.replace('5', '6'))
print(minSum, maxSum)
