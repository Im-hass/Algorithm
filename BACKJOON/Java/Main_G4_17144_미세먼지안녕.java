package _0308_G4_17144_미세먼지안녕;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

// G4_17144 미세먼지 안녕!
public class Main {

  static int R; // 가로 크기
  static int C; // 세로 크기
  static int T; // 초
  static int[][] map; // 방(원본 미세먼지), 공기청정기 -1
  static int topAir = -1; // 공기청정기 위쪽 y 좌표

  public static void main(String[] args) throws IOException {

    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(in.readLine());

    R = Integer.parseInt(st.nextToken());
    C = Integer.parseInt(st.nextToken());
    T = Integer.parseInt(st.nextToken());
    map = new int[R][C];
    for (int i = 0; i < R; i++) {
      st = new StringTokenizer(in.readLine());
      for (int j = 0; j < C; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());
        if (topAir == -1 && map[i][j] == -1) {
          topAir = i;
        }
      }
    }

    for (int i = 0; i < T; i++) {
      spread(); // 1. 미세먼지 확산
      airOperation(); // 2. 공기청정기 작동
    }

    System.out.println(getTotalDust());

  }

  public static void spread() {
    int[] dy = { -1, 0, 1, 0 };
    int[] dx = { 0, 1, 0, -1 };
    int[][] sumDust = new int[R][C]; // 누적된 미세먼지(주변에서 확산된 미세먼지)

    for (int i = 0; i < R; i++) {
      for (int j = 0; j < C; j++) {
        if (map[i][j] != -1 && map[i][j] >= 5) { // 5로 나눈 소수점은 버리기 때문에 5 이상 넘지 않으면 확산되는 양이 없음
          int spreadCnt = 0;
          for (int d = 0; d < 4; d++) {
            int ny = i + dy[d];
            int nx = j + dx[d];
            if (ny > -1 && ny < R && nx > -1 && nx < C && map[ny][nx] != -1) {
              // 확산되는 방향
              spreadCnt++;
              // 2. 확산되는 양은 ⌊Ar,c/5⌋이다.
              sumDust[ny][nx] += Math.ceil(map[i][j] / 5);
            }
          }
          // 3. (r, c)에 남은 미세먼지의 양은 Ar,c - ⌊Ar,c/5⌋×(확산된 방향의 개수) 이다.
          map[i][j] -= Math.ceil(map[i][j] / 5) * spreadCnt;
        }
      }
    }

    for (int i = 0; i < R; i++) {
      for (int j = 0; j < C; j++) {
        map[i][j] += sumDust[i][j];
      }
    }

  }

  public static void airOperation() {
    // 2-1. 위쪽 공기청정기의 바람은 반시계방향으로 순환한다.
    // 3. 바람이 불면 미세먼지가 바람의 방향대로 모두 한 칸씩 이동한다.
    topOperation();

    // 2-2. 아래쪽 공기청정기의 바람은 시계방향으로 순환한다.
    // 3. 바람이 불면 미세먼지가 바람의 방향대로 모두 한 칸씩 이동한다.
    bottomOperation();
  }

  public static void topOperation() {
    Queue<Integer> q = new ArrayDeque<>();
    q.offer(0);

    for (int i = 1; i < C; i++) {
      q.offer(map[topAir][i]);
    }
    for (int i = topAir - 1; i >= 0; i--) {
      q.offer(map[i][C - 1]);
    }
    for (int i = C - 2; i >= 0; i--) {
      q.offer(map[0][i]);
    }
    for (int i = 1; i < topAir; i++) {
      q.offer(map[i][0]);
    }

    for (int i = 1; i < C; i++) {
      map[topAir][i] = q.poll();
    }
    for (int i = topAir - 1; i >= 0; i--) {
      map[i][C - 1] = q.poll();
    }
    for (int i = C - 2; i >= 0; i--) {
      map[0][i] = q.poll();
    }
    for (int i = 1; i < topAir; i++) {
      map[i][0] = q.poll();
    }
  }

  public static void bottomOperation() {
    int bottomAir = topAir + 1;
    Queue<Integer> q = new ArrayDeque<>();
    q.offer(0);

    for (int i = 1; i < C; i++) {
      q.offer(map[bottomAir][i]);
    }
    for (int i = bottomAir + 1; i < R; i++) {
      q.offer(map[i][C - 1]);
    }
    for (int i = C - 2; i >= 0; i--) {
      q.offer(map[R - 1][i]);
    }
    for (int i = R - 2; i > bottomAir + 1; i--) {
      q.offer(map[i][0]);
    }

    for (int i = 1; i < C; i++) {
      map[bottomAir][i] = q.poll();
    }
    for (int i = bottomAir + 1; i < R; i++) {
      map[i][C - 1] = q.poll();
    }
    for (int i = C - 2; i >= 0; i--) {
      map[R - 1][i] = q.poll();
    }
    for (int i = R - 2; i > bottomAir; i--) {
      map[i][0] = q.poll();
    }
  }

  public static int getTotalDust() {
    int totalDust = 0;

    for (int i = 0; i < R; i++) {
      for (int j = 0; j < C; j++) {
        if (map[i][j] == -1)
          continue;
        totalDust += map[i][j];
      }
    }

    return totalDust;
  }

}
