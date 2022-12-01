def recursion(s, s_idx, e_idx, cnt):
    if s_idx >= e_idx:
        return [1, cnt]
    elif s[s_idx] != s[e_idx]:
        return [0, cnt]
    else:
        cnt += 1
        return recursion(s, s_idx+1, e_idx-1, cnt)


def isPalindrome(s):
    return recursion(s, 0, len(s)-1, 1)


T = int(input())
for _ in range(T):
    print(' '.join(map(str, isPalindrome(input()))))
