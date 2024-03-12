import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class _0312_G5_16509_장군 {

  static int[][] map; // 장기판
  static int min = Integer.MAX_VALUE; // 최소 이동 횟수

  public static void main(String[] args) throws IOException {

    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(in.readLine());
    // 상의 위치
    int R1 = Integer.parseInt(st.nextToken());
    int C1 = Integer.parseInt(st.nextToken());
    st = new StringTokenizer(in.readLine());
    // 왕의 위치
    int R2 = Integer.parseInt(st.nextToken());
    int C2 = Integer.parseInt(st.nextToken());

    map = new int[10][9];
    map[R2][C2] = -1; // 왕

    bfs(R1, C1);

    if (min == Integer.MAX_VALUE) { // 도달할 수 없음
      System.out.println(-1);
      return;
    }

    System.out.println(min);

  }

  private static void bfs(int R1, int C1) {
    int[][] dy = {
        { -1, -1, -1 },
        { -1, -1, -1 },
        { 0, -1, -1 },
        { 0, 1, 1 },
        { 1, 1, 1 },
        { 1, 1, 1 },
        { 0, 1, 1 },
        { 0, -1, -1 }
    };
    int[][] dx = {
        { 0, -1, -1 },
        { 0, 1, 1 },
        { 1, 1, 1 },
        { 1, 1, 1 },
        { 0, 1, 1 },
        { 0, -1, -1 },
        { -1, -1, -1 },
        { -1, -1, -1 },
    };
    boolean[][] visited = new boolean[10][9];
    Queue<int[]> q = new ArrayDeque<>();

    q.offer(new int[] { R1, C1 });

    boolean isJoin = false;
    while (!q.isEmpty() && !isJoin) {
      int y = q.peek()[0];
      int x = q.peek()[1];
      q.poll();
      visited[y][x] = true;

      for (int i = 0; i < 8; i++) { // 8가지 방향 탐색
        boolean isPass = false;
        int ny = y;
        int nx = x;
        for (int j = 0; j < 3; j++) { // 3번 경로 따라 이동
          ny += dy[i][j];
          nx += dx[i][j];

          if (ny > -1 && ny < 10 && nx > -1 && nx < 9 &&
              !(j != 2 && map[ny][nx] == -1)) { // 도착지점이 아닌데 왕을 만나면 지나갈 수 없음(지나가는 길이 아님)
            isPass = true; // 이동 가능한 길
          } else {
            isPass = false; // 이동 불가능한 길
            break;
          }
        }
        if (isPass && !visited[ny][nx]) { // 이동 가능하고 방문한 적 없을 때
          if (map[ny][nx] == -1) { // 왕을 잡았을 경우
            min = Math.min(min, map[y][x] + 1);
            isJoin = true;
            break;
          } else {
            map[ny][nx] = map[y][x] + 1;
            q.offer(new int[] { ny, nx });
          }
        }
      }
    }

  }

}
