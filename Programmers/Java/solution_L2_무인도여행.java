import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.stream.Collectors;

class Solution {
    static char[][] m; // split한 map
    static boolean[][] isVisited; // 방문 체크
    static int[] dy = { -1, 0, 1, 0 };
    static int[] dx = { 0, 1, 0, -1 };
    
    public int[] solution(String[] maps) {
        m = new char[maps.length][maps[0].length()];
        isVisited = new boolean[m.length][m[0].length];
        
        for (int i = 0; i < maps.length; i++) {
            char[] chars = maps[i].toCharArray();
            for (int j = 0; j < chars.length; j++) {
                m[i][j] = chars[j];
            }
        }
        
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                isVisited[i][j] = true;
                if (m[i][j] != 'X') {
                    list.add(bfs(i, j));
                }
            }
        }
        
        if (list.size() <= 0) {
            return new int[] { -1 };
        }
        
        int[] answer = list.stream().mapToInt(i->i).toArray();
        Arrays.sort(answer);
        
        return answer;
    }
    
    public static int bfs(int i, int j) {
        int count = m[i][j] - '0';
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[] {i, j});
        
        while (!q.isEmpty()) {
            int y = q.peek()[0];
            int x = q.peek()[1];
            q.poll();
            m[y][x] = 'X';
            
            for (int d = 0; d < 4; d++) {
                int ny = y + dy[d];
                int nx = x + dx[d];
                
                if (ny > -1 && ny < m.length && nx > -1 && nx < m[i].length) {
                    if (!isVisited[ny][nx] && m[ny][nx] != 'X') {
                        count += (m[ny][nx] - '0');
                        q.offer(new int[] {ny, nx});
                        isVisited[ny][nx] = true;
                    }
                }
            }
        }
        
        return count;
    }
}