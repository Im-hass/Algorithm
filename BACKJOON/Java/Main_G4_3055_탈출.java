import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

// G4_3055 탈출
public class _0320_G4_3055_탈출 {

  static int[] dy = { -1, 0, 1, 0 };
  static int[] dx = { 0, 1, 0, -1 };
  static int R; // 행
  static int C; // 열
  static char[][] map; // 빈 곳 ., 물 *, 돌 X, 비버의 굴 D, 고슴도치 S
  static boolean[][] visited; // 방문 확인
  static boolean isGoal; // 도착 여부

  public static void main(String[] args) throws IOException {

    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(in.readLine());
    R = Integer.parseInt(st.nextToken());
    C = Integer.parseInt(st.nextToken());
    map = new char[R][C];
    visited = new boolean[R][C];

    for (int i = 0; i < R; i++) {
      String str = in.readLine();
      map[i] = str.toCharArray();
    }

    Queue<int[]> q = new ArrayDeque<>();
    int time = 0; // 이동 시간
    while (!isGoal) { // 도착했다면 종료
      // 물이 있는 위치 q에 추가
      for (int i = 0; i < R; i++) {
        for (int j = 0; j < C; j++) {
          if (map[i][j] == '*' && !visited[i][j]) {
            visited[i][j] = true; // 주변에 물이 채워질 공간은 다음 time에 q에 들어가야 하므로 현재 위치만 true로 바꿔줌(bfs 내에서 주변 빈공간 true로 안
                                  // 바꿈)
            q.offer(new int[] { i, j });
          }
        }
      }

      // 물 채우기
      while (!q.isEmpty()) {
        moveWater(q.peek()[0], q.peek()[1]);
        q.poll();
      }

      // 고슴도치가 있는 위치 q에 추가
      for (int i = 0; i < R; i++) {
        for (int j = 0; j < C; j++) {
          if (map[i][j] == 'S' && !visited[i][j]) {
            visited[i][j] = true;
            q.offer(new int[] { i, j });
          }
        }
      }

      int cnt = 0; // 이동할 수 있는 방향 수
      // 고슴도치 채우기
      while (!q.isEmpty()) {
        cnt += moveHedgehog(q.peek()[0], q.peek()[1]);
        q.poll();
      }
      if (cnt == 0)
        break; // 갈 수 있는 곳이 없을 경우 종료

      time++;
    }

    if (!isGoal) {
      System.out.println("KAKTUS");
      return;
    }

    System.out.println(time);

  }

  private static int moveHedgehog(int i, int j) {
    int cnt = 0;
    for (int d = 0; d < 4; d++) {
      int ny = i + dy[d];
      int nx = j + dx[d];
      if (ny > -1 && ny < R && nx > -1 && nx < C) {
        if (map[ny][nx] == '.') {
          map[ny][nx] = 'S';
          cnt++;
        } else if (map[ny][nx] == 'D') {
          isGoal = true;
          cnt++;
          break;
        }
      }
    }
    return cnt;
  }

  private static void moveWater(int i, int j) {
    for (int d = 0; d < 4; d++) {
      int ny = i + dy[d];
      int nx = j + dx[d];
      if (ny > -1 && ny < R && nx > -1 && nx < C) {
        if (map[ny][nx] != 'X' && map[ny][nx] != 'D' && map[ny][nx] != 'S') {
          map[ny][nx] = '*';
        }
      }
    }
  }

}
