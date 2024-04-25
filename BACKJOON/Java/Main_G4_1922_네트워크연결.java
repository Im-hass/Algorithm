import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main_G4_1922_네트워크연결 {

  static int N, M;
  static int[] parent;
  static ArrayList<Node> list;

  static class Node implements Comparable<Node> {
    int from;
    int to;
    int cost;

    public Node(int from, int to, int cost) {
      this.from = from;
      this.to = to;
      this.cost = cost;
    }

    @Override
    public int compareTo(Node o) {
      return Integer.compare(cost, o.cost);
    }
  }

  public static void main(String[] args) throws NumberFormatException, IOException {

    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = null;

    N = Integer.parseInt(in.readLine());
    M = Integer.parseInt(in.readLine());
    list = new ArrayList<>();
    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(in.readLine());
      int from = Integer.parseInt(st.nextToken());
      int to = Integer.parseInt(st.nextToken());
      int cost = Integer.parseInt(st.nextToken());
      if (from == to)
        continue;
      list.add(new Node(from, to, cost));
    }
    Collections.sort(list);

    parent = new int[N + 1];
    for (int i = 0; i <= N; i++) {
      parent[i] = i;
    }

    int answer = 0;

    for (int i = 0; i < list.size(); i++) {
      Node node = list.get(i);
      if (union(node.from, node.to)) {
        answer += node.cost;
      }
    }

    System.out.println(answer);

  }

  public static int find(int a) {
    if (parent[a] == a)
      return a;
    return parent[a] = find(parent[a]);
  }

  public static boolean union(int a, int b) {
    int aRoot = find(a);
    int bRoot = find(b);

    if (aRoot == bRoot)
      return false;
    parent[bRoot] = aRoot;
    return true;
  }

}
