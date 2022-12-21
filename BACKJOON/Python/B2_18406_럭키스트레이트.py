N = input()
nums = list(map(int, list(N)))
half = int(len(nums) / 2)

left = sum(nums[0:half])
right = sum(nums[half:])

if left == right:
    print('LUCKY')
else:
    print('READY')
