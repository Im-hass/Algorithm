import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

// G4_2573 빙산
public class _0318_G4_2573_빙산 {

  static int[] dy = { -1, 0, 1, 0 };
  static int[] dx = { 0, 1, 0, -1 };
  static int N; // 행
  static int M; // 열
  static int[][] map;
  static int year = 1;

  public static void main(String[] args) throws IOException {

    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(in.readLine());

    N = Integer.parseInt(st.nextToken()); // 행
    M = Integer.parseInt(st.nextToken()); // 열
    map = new int[N][M];

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(in.readLine());
      for (int j = 0; j < M; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    while (true) {
      int[][] cntMap = new int[N][M]; // 해당 칸의 녹는 개수 저장

      for (int i = 0; i < N; i++) {
        for (int j = 0; j < M; j++) {
          if (map[i][j] != 0) {
            setCnt(cntMap, i, j); // 녹는 개수 세기
          }
        }
      }

      joinMap(cntMap); // 녹이기

      if (!isOne()) { // 두 덩어리로 나눠졌을 경우
        System.out.println(year); // 나눠진 년도 출력 및 종료
        return;
      }

      if (isZero()) { // 다 녹을 때까지 두 덩어리로 나뉘지 않을 경우
        break;
      }

      year++;
    }

    System.out.println(0);

  }

  private static boolean isZero() {
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        if (map[i][j] != 0) {
          return false;
        }
      }
    }
    return true;
  }

  private static void joinMap(int[][] cntMap) {
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        map[i][j] -= cntMap[i][j];
        if (map[i][j] < 0)
          map[i][j] = 0;
      }
    }
  }

  private static boolean isOne() {
    boolean[][] checkMap = new boolean[N][M];
    int cnt = 1;

    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        if (map[i][j] != 0 && !checkMap[i][j]) {
          if (cnt > 1)
            return false;
          bfs(i, j, checkMap, cnt);
          cnt++;
        }
      }
    }
    return true;
  }

  private static void bfs(int i, int j, boolean[][] checkMap, int cnt) {
    Queue<int[]> q = new ArrayDeque<>();
    q.offer(new int[] { i, j });
    checkMap[i][j] = true;

    while (!q.isEmpty()) {
      int y = q.peek()[0];
      int x = q.peek()[1];
      q.poll();

      for (int d = 0; d < 4; d++) {
        int ny = y + dy[d];
        int nx = x + dx[d];
        if (ny > -1 && ny < N && nx > -1 && nx < M) {
          if (map[ny][nx] != 0 && !checkMap[ny][nx]) {
            q.offer(new int[] { ny, nx });
            checkMap[ny][nx] = true;
          }
        }
      }
    }
  }

  private static void setCnt(int[][] cntMap, int y, int x) {
    int cnt = 0;

    for (int d = 0; d < 4; d++) {
      int ny = y + dy[d];
      int nx = x + dx[d];
      if (ny > -1 && ny < N && nx > -1 && nx < M && map[ny][nx] == 0) {
        cnt++;
      }
    }

    cntMap[y][x] = cnt;
  }

}
