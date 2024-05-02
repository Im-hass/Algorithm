import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

class Solution {

  static int[] parent;
  static List<Node> list;

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
    public int compareTo(Node n) {
      return Integer.compare(this.cost, n.cost);
    }
  }

  public int solution(int n, int[][] costs) {
    int answer = 0;
    list = new ArrayList<>();

    for (int i = 0; i < costs.length; i++) {
      int from = costs[i][0];
      int to = costs[i][1];
      int cost = costs[i][2];
      list.add(new Node(from, to, cost));
    }

    Collections.sort(list);

    parent = new int[n];
    for (int i = 0; i < n; i++) {
      parent[i] = i;
    }

    for (int i = 0; i < list.size(); i++) {
      Node node = list.get(i);
      if (union(node.from, node.to)) {
        answer += node.cost;
      }
    }

    return answer;
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
    if (aRoot > bRoot)
      parent[aRoot] = bRoot;
    else
      parent[bRoot] = aRoot;
    return true;
  }

}