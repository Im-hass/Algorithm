import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_G4_1647_도시분할계획 {

  static int N, M; // 정점 개수, 간선 개수
  static int[] parent; // 최상위 루트
  static ArrayList<Edge> list;

  static class Edge implements Comparable<Edge> {
    int from;
    int to;
    int weight;

    public Edge(int from, int to, int weight) {
      this.from = from;
      this.to = to;
      this.weight = weight;
    }

    @Override
    public int compareTo(Edge o) {
      return Integer.compare(this.weight, o.weight);
    }
  }

  public static void main(String[] args) throws IOException {

    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(in.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    list = new ArrayList<>();

    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(in.readLine());
      int from = Integer.parseInt(st.nextToken());
      int to = Integer.parseInt(st.nextToken());
      int weight = Integer.parseInt(st.nextToken());
      list.add(new Edge(from, to, weight));
    }

    Collections.sort(list); // 제일 비용이 낮은 간선부터 오름차순 정렬

    parent = new int[N + 1];
    for (int i = 1; i <= N; i++) {
      parent[i] = i;
    }

    long answer = 0;
    int max = 0;
    for (int i = 0; i < list.size(); i++) {
      Edge edge = list.get(i);
      if (union(edge.from, edge.to)) {
        answer += edge.weight;
        max = edge.weight;
      }
    }

    System.out.println(answer - max);

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
    parent[bRoot] = aRoot; // parent[b] = aRoot;로 해둬서 틀림
    return true;
  }

}
