import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class _0313_G5_18405_경쟁적전염 {

  static int N; // 시험관 크기
  static int K; // 마지막 바이러스 번호
  static int[][] board; // 시험관
  static Map<Integer, Queue<int[]>> map; // 각 virus(key)가 있는 위치(좌표 - value) 저장

  public static void main(String[] args) throws IOException {

    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(in.readLine());

    N = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());
    board = new int[N][N];
    map = new TreeMap<>((key1, key2) -> key1.compareTo(key2));
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(in.readLine());
      for (int j = 0; j < N; j++) {
        board[i][j] = Integer.parseInt(st.nextToken());
        if (board[i][j] != 0) {
          map.computeIfAbsent(board[i][j], k -> new ArrayDeque<>()).add(new int[] { i, j }); // key값이 있으면 list에 추가, 없으면
                                                                                             // 초기화
        }
      }
    }

    st = new StringTokenizer(in.readLine());
    int S = Integer.parseInt(st.nextToken());
    int X = Integer.parseInt(st.nextToken());
    int Y = Integer.parseInt(st.nextToken());

    for (int i = 0; i < S; i++) {
      bfs(); // 1초에 한 번씩 S초까지 퍼트리기
    }

    System.out.println(board[X - 1][Y - 1]);

  }

  private static void bfs() {
    Queue<int[]> tempList = new ArrayDeque<>(); // 새롭게 바이러스가 퍼진 곳 위치 저장
    int[] dy = { -1, 0, 1, 0 };
    int[] dx = { 0, 1, 0, -1 };

    for (Map.Entry<Integer, Queue<int[]>> entry : map.entrySet()) {
      int key = entry.getKey();
      Queue<int[]> list = entry.getValue();
      while (!list.isEmpty()) {
        int y = list.peek()[0];
        int x = list.peek()[1];
        list.poll();

        for (int d = 0; d < 4; d++) {
          int ny = y + dy[d];
          int nx = x + dx[d];
          if (ny > -1 && ny < N && nx > -1 && nx < N && board[ny][nx] == 0) {
            board[ny][nx] = key;
            tempList.add(new int[] { ny, nx });
          }
        }
      }
    }

    for (int[] position : tempList) { // 1초 후 바이러스 위치(새롭게 퍼진 곳만) 저장
      int y = position[0];
      int x = position[1];
      int virusType = board[y][x];
      map.get(virusType).offer(new int[] { y, x });
    }
  }

}
