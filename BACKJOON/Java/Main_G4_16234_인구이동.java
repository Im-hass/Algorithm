import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class _0319_G4_16234_인구이동 {

  static final int[] dy = { -1, 0, 1, 0 };
  static final int[] dx = { 0, 1, 0, -1 };

  static int N; // 땅 크기 N*N
  static int L; // 최소 인구 차이, L명 이상
  static int R; // 최대 인구 차이, R명 이하
  static int[][] map; // 나라 정보

  static class Union {
    int count; // 연합 국가수
    int people; // 연합 인구수

    public Union(int count, int people) {
      this.count = count;
      this.people = people;
    }
  }

  public static void main(String[] args) throws IOException {

    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(in.readLine());
    N = Integer.parseInt(st.nextToken());
    L = Integer.parseInt(st.nextToken());
    R = Integer.parseInt(st.nextToken());
    map = new int[N][N];
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(in.readLine());
      for (int j = 0; j < N; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    int day = 0; // 인구 이동하는 일수(정답)
    while (day <= 2000 && canMove()) { // 2000일 이하고 이동이 가능할 때 반복
      boolean[][] visitied = new boolean[N][N]; // 방문 기록
      int[][] unionMap = new int[N][N]; // 연합 번호 기록
      Map<Integer, Union> m = new HashMap<>(); // key: 연합 번호, value: Union 객체(연합 국가수, 연합 인원수)
      int number = 1; // 연합 번호
      for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
          if (!visitied[i][j]) { // 방문한 적 없는 곳일 경우 bfs
            int[] result = bfs(visitied, unionMap, i, j, number);
            int count = result[0];
            int people = result[1];
            m.put(number, new Union(count, people));
            number++;
          }
        }
      }

      for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
          map[i][j] = (int) Math.floor(m.get(unionMap[i][j]).people / m.get(unionMap[i][j]).count); // 인구 이동한 결과, 인구수 저장
        }
      }

      day++;
    }

    System.out.println(day);

  }

  /**
   * 
   * @param visitied 방문 기록
   * @param unionMap 연합 번호 기록
   * @param i        시작 y 좌표
   * @param j        시작 x 좌표
   * @param number   연합 번호
   * @return
   */
  private static int[] bfs(boolean[][] visitied, int[][] unionMap, int i, int j, int number) {
    Queue<int[]> q = new ArrayDeque<>();
    int count = 1;
    int people = map[i][j];
    visitied[i][j] = true;
    unionMap[i][j] = number;
    q.offer(new int[] { i, j });

    while (!q.isEmpty()) {
      int y = q.peek()[0];
      int x = q.peek()[1];
      q.poll();
      for (int d = 0; d < 4; d++) {
        int ny = y + dy[d];
        int nx = x + dx[d];
        if (ny > -1 && ny < N && nx > -1 && nx < N && !visitied[ny][nx]) {
          int sub = Math.abs(map[y][x] - map[ny][nx]);
          if (sub >= L && sub <= R) {
            count++;
            people += map[ny][nx];
            visitied[ny][nx] = true;
            unionMap[ny][nx] = number;
            q.offer(new int[] { ny, nx });
          }
        }
      }
    }

    return new int[] { count, people };
  }

  /**
   * 이동이 가능한지 확인하는 함수
   * 
   * @return 한 곳이라도 이동 가능할 경우 true, 불가능할 경우 false
   */
  private static boolean canMove() {
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        for (int d = 0; d < 4; d++) {
          int ny = i + dy[d];
          int nx = j + dx[d];
          if (ny > -1 && ny < N && nx > -1 && nx < N) {
            int sub = Math.abs(map[i][j] - map[ny][nx]);
            if (sub >= L && sub <= R) {
              return true;
            }
          }
        }
      }
    }

    return false;
  }

}
