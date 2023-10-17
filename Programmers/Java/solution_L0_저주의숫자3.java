// 문제: https://school.programmers.co.kr/learn/courses/30/lessons/120871

class Solution {
    public int solution(int n) {
        int num = 0;
        for (int i = 1; i <= n; i++) {
            num++;
            while (true) {
                if (num % 3 != 0 && !String.valueOf(num).contains("3")) {
                    break;
                }
                if (num % 3 == 0 || String.valueOf(num).contains("3")) {
                    num++;
                }
            }
        }
        return num;
    }
}
