// 문제: https://school.programmers.co.kr/learn/courses/30/lessons/120866
import java.util.*;

class Solution {
    public int solution(int[][] board) {
        int answer = 0;
        
        // 지뢰 1, 땅 0
        int[] dy = { -1, -1, -1, 0, 1, 1, 1, 0 };
        int[] dx = { -1, 0, 1, 1, 1, 0, -1, -1 };
        
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] == 1) {
                    for (int d = 0; d < dy.length; d++) {
                        int ny = dy[d] + i;
                        int nx = dx[d] + j;
                        if (ny > -1 && ny < board.length && nx > -1 && nx < board.length && board[ny][nx] != 1) {
                            board[ny][nx] = 2;
                        }
                    }
                }
            }
        }
        
        for (int[] i: board) {
            for (int j: i) {
                if (j == 0) {
                    answer++;
                }
            }
        }
        
        return answer;
    }
}
