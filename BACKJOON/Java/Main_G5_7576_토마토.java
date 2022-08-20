import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 토마토
// 골5
// 그래프, bfs
public class Main_G5_7576_토마토 {
  static int N, M;
  static int[][] map;
  static Queue<int[]> q = new LinkedList<>();
  static int[] dx = { 0, 1, 0, -1 };
  static int[] dy = { -1, 0, 1, 0 };

  public static void main(String[] args) throws IOException {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(in.readLine());
    M = Integer.parseInt(st.nextToken());
    N = Integer.parseInt(st.nextToken());
    map = new int[N][M];

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(in.readLine());
      for (int j = 0; j < M; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());
        if (map[i][j] == 1) {
          q.offer(new int[] { i, j });
        }
      }
    }

    bfs();
  }

  private static void bfs() {
    while (!q.isEmpty()) {
      int[] tmp = q.poll();

      for (int i = 0; i < 4; i++) {
        int ny = tmp[0] + dy[i];
        int nx = tmp[1] + dx[i];

        if (nx > -1 && ny > -1 && nx < M && ny < N) {
          if (map[ny][nx] == 0) {
            q.offer(new int[] { ny, nx });
            map[ny][nx] = map[tmp[0]][tmp[1]] + 1;
          }
        }
      }
    }

    int res = Integer.MIN_VALUE;

    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        if (map[i][j] == 0) {
          System.out.println(-1);
          return;
        }
        if (res <= map[i][j]) {
          res = map[i][j];
        }
      }
    }

    if (res == 1) {
      System.out.println(0);
    } else {
      System.out.println(res - 1);
    }
  }
}