import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class _0314_G4_1707_이분그래프 {

  static final int RED = 1;
  static final int BLUE = -1;
  static int V; // 정점의 개수
  static Node[] list; // 그래프
  static int[] colors; // 이분 그래프 확인용, 0 방문한 적 없음, 1 빨간색, -1 파란색
  static boolean isBipartiteGraph; // 이분 그래프일 경우 true

  static class Node {
    int value;
    Node link;

    public Node(int value, Node link) {
      this.value = value;
      this.link = link;
    }
  }

  public static void main(String[] args) throws IOException {

    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = null;

    int K = Integer.parseInt(in.readLine()); // 테스트 케이스 수
    for (int t = 0; t < K; t++) {
      st = new StringTokenizer(in.readLine());
      V = Integer.parseInt(st.nextToken());
      int E = Integer.parseInt(st.nextToken()); // 간선의 개수
      // 초기화
      list = new Node[V + 1];
      colors = new int[V + 1];
      isBipartiteGraph = true;
      for (int j = 0; j < E; j++) { // 양방향 연결
        st = new StringTokenizer(in.readLine());
        int from = Integer.parseInt(st.nextToken());
        int to = Integer.parseInt(st.nextToken());
        list[from] = new Node(to, list[from]);
        list[to] = new Node(from, list[to]);
      }

      for (int i = 1; i < V + 1; i++) { // 각 정점 탐색
        if (!isBipartiteGraph) { // 이분 그래프가 아닐 경우 탐색 종료
          break;
        }

        if (colors[i] == 0) { // 방문한적 없다면 방문
          bfs(i, RED);
        }
      }

      System.out.println(isBipartiteGraph ? "YES" : "NO");
    }

  }

  private static void bfs(int startValue, int color) {
    Queue<Integer> q = new ArrayDeque<>();
    q.offer(startValue);
    colors[startValue] = color;

    while (!q.isEmpty() && isBipartiteGraph) {
      int value = q.poll();
      for (Node n = list[value]; n != null; n = n.link) {
        if (colors[n.value] == 0) { // 방문한적 없는 정점일 경우
          q.offer(n.value);
          colors[n.value] = colors[value] * -1; // 현재 정점과 반대되는 값 저장
        } else if (colors[value] + colors[n.value] != 0) { // 방문한적 있을 경우, 현재 정점과 다른 색인지 확인(다른 색이 1, -1이므로 0이 나와야 다른 색임),
                                                           // 다른 색이 아닐 경우
          isBipartiteGraph = false; // 이분 그래프가 아님
          return; // 종료
        }
      }
    }
  }

}
