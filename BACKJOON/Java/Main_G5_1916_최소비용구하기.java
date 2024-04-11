import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class _0411_G5_1916_최소비용구하기 {

  static final int INF = Integer.MAX_VALUE;
  static int N; // 정점 개수
  static int S; // 시작 정점
  static int E; // 끝 정점

  static class Node {
    int idx, cost;

    public Node(int idx, int cost) {
      this.idx = idx;
      this.cost = cost;
    }
  }

  public static void main(String[] args) throws NumberFormatException, IOException {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = null;

    N = Integer.parseInt(in.readLine()); // 정점의 개수
    int M = Integer.parseInt(in.readLine()); // 간선의 개수

    List<Node>[] list = new ArrayList[N + 1];

    for (int i = 0; i <= N; i++) {
      list[i] = new ArrayList<>();
    }

    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(in.readLine());
      int from = Integer.parseInt(st.nextToken());
      int to = Integer.parseInt(st.nextToken());
      int v = Integer.parseInt(st.nextToken());
      list[from].add(new Node(to, v));
    }

    st = new StringTokenizer(in.readLine());
    S = Integer.parseInt(st.nextToken()); // 출발점
    E = Integer.parseInt(st.nextToken()); // 도착점

    int[] distance = dijkstra(list);

    System.out.println(distance[E]); // 출발 정점에서 도착 정점까지 가는데 드는 최소 비용

  }

  public static int[] dijkstra(List<Node> list[]) {
    PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
    pq.add(new Node(S, 0));

    int dis[] = new int[N + 1];
    Arrays.fill(dis, INF);
    dis[0] = 0;
    dis[S] = 0;

    while (!pq.isEmpty()) {
      Node now = pq.poll();
      if (dis[now.idx] < now.cost)
        continue;

      for (Node next : list[now.idx]) {
        int cost = next.cost + dis[now.idx];
        if (dis[next.idx] > cost) {
          dis[next.idx] = cost;
          pq.add(new Node(next.idx, cost));
        }
      }
    }

    return dis;
  }

}
