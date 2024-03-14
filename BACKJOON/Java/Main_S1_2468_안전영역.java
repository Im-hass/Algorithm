import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class _0315_S1_2468_안전영역 {

  static int N; // 맵의 크기
  static int[][] map; // 지역 정보
  static boolean[][] visited;
  static int max = Integer.MIN_VALUE; // 안전영역 최대 개수
  static int maxMount = Integer.MIN_VALUE; // 최대 비의 양

  public static void main(String[] args) throws NumberFormatException, IOException {

    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = null;

    N = Integer.parseInt(in.readLine());
    map = new int[N][N];

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(in.readLine());
      for (int j = 0; j < N; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());
        if (maxMount < map[i][j]) {
          maxMount = map[i][j];
        }
      }
    }

    for (int m = 1; m < maxMount; m++) {
      int cnt = 0; // 안전영역 개수
      visited = new boolean[N][N];
      for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
          if (map[i][j] > m && !visited[i][j]) {
            bfs(i, j, m);
            cnt++;
          }
        }
      }
      if (max <= cnt) {
        max = cnt;
      }
    }

    System.out.println(max == Integer.MIN_VALUE ? 1 : max);

  }

  private static void bfs(int i, int j, int target) {
    int[] dy = { -1, 0, 1, 0 };
    int[] dx = { 0, 1, 0, -1 };

    Queue<int[]> q = new ArrayDeque<>();
    q.offer(new int[] { i, j });
    visited[i][j] = true;

    while (!q.isEmpty()) {
      int y = q.peek()[0];
      int x = q.peek()[1];
      q.poll();
      for (int d = 0; d < 4; d++) {
        int ny = y + dy[d];
        int nx = x + dx[d];
        if (ny > -1 && ny < N && nx > -1 && nx < N && !visited[ny][nx] && map[ny][nx] > target) {
          visited[ny][nx] = true;
          q.offer(new int[] { ny, nx });
        }
      }
    }

  }

}
