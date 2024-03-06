package _0306_G4_3190_뱀;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

// G4_3190 뱀
public class Main {

  public static int N; // 맵의 크기
  public static int[][] map; // 맵 정보, 빈칸 0, 사과 2
  public static int sec; // 초
  public static Snake snake; // 뱀 정보(방향, 위치)
  public static Queue<Turn> turnList; // 방향 변환 정보(초, 방향)

  static class Snake {
    int dir; // 뱀 방향, 0 우, 1 하, 2 좌, 3 상
    List<int[]> list; // 뱀 위치

    public Snake() {
      dir = 0; // 오른쪽
      list = new ArrayList<>();
    }

    public void setDir(char dir) {
      if (dir == 'D') { // 오른쪽으로 90도 회전
        this.dir = (this.dir + 1) % 4;
      } else { // 왼쪽으로 90도 회전
        this.dir = (this.dir - 1) % 4;
        if (this.dir == -1)
          this.dir = 3;
      }
    }

    public int[] getHead() {
      if (list.size() == 0)
        return new int[] { 0, 0 };
      return list.get(list.size() - 1);
    }

    public boolean isBody(int ny, int nx) {
      for (int[] l : list) {
        if (l[0] == ny && l[1] == nx)
          return true;
      }
      return false;
    }
  }

  static class Turn {
    int sec; // n초 뒤
    char dir; // 회전 방향

    public Turn(int sec, char dir) {
      this.sec = sec;
      this.dir = dir;
    }
  }

  public static void main(String[] args) throws NumberFormatException, IOException {

    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = null;

    snake = new Snake();
    snake.list.add(new int[] { 0, 0 });
    turnList = new ArrayDeque<>();
    N = Integer.parseInt(in.readLine());
    map = new int[N][N];
    int K = Integer.parseInt(in.readLine()); // 사과의 개수
    for (int i = 0; i < K; i++) {
      st = new StringTokenizer(in.readLine());
      int y = Integer.parseInt(st.nextToken()) - 1;
      int x = Integer.parseInt(st.nextToken()) - 1;
      map[y][x] = 2;
    }

    int L = Integer.parseInt(in.readLine()); // 방향 변환 횟수
    for (int i = 0; i < L; i++) {
      st = new StringTokenizer(in.readLine());
      int X = Integer.parseInt(st.nextToken()); // X초 후 방향 전환
      char C = st.nextToken().charAt(0); // L 왼쪽, D 오른쪽 90도 회전
      turnList.offer(new Turn(X, C));
    }

    int[] dy = { 0, 1, 0, -1 };
    int[] dx = { 1, 0, -1, 0 };
    boolean isEnd = false;
    while (!isEnd) {
      sec++;

      int dir = snake.dir;
      int y = snake.getHead()[0];
      int x = snake.getHead()[1];

      // 방향 전환 확인
      if (!turnList.isEmpty() && isTurn(sec, turnList.peek().sec)) {
        char nextDir = turnList.poll().dir;
        snake.setDir(nextDir);
      }

      // 1. 먼저 뱀은 몸길이를 늘려 머리를 다음칸에 위치시킨다.
      int ny = y + dy[dir];
      int nx = x + dx[dir];
      // 2. 만약 벽이나 자기자신의 몸과 부딪히면 게임이 끝난다.
      if (ny < 0 || ny >= N || nx < 0 || nx >= N ||
          snake.isBody(ny, nx)) {
        break;
      } else if (map[ny][nx] == 2) { // 3. 만약 이동한 칸에 사과가 있다면, 그 칸에 있던 사과가 없어지고 꼬리는 움직이지 않는다.
        snake.list.add(new int[] { ny, nx });
        map[ny][nx] = 0;
      } else { // 4. 만약 이동한 칸에 사과가 없다면, 몸길이를 줄여서 꼬리가 위치한 칸을 비워준다. 즉, 몸길이는 변하지 않는다.
        snake.list.remove(0);
        snake.list.add(new int[] { ny, nx });
      }
    }

    System.out.println(sec);

  }

  private static boolean isTurn(int now, int turnTime) {
    return now == turnTime;
  }

}
