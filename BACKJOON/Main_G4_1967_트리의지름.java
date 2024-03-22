import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class _0322_G4_1967_트리의지름 {

	static int N; // 노드의 개수
	static List<Node>[] list;
	static boolean[] visited;
	static int max = Integer.MIN_VALUE;
	
	static class Node {
		int value;
		int cost;
		
		public Node(int value, int cost) {
			this.value = value;
			this.cost = cost;
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		N = Integer.parseInt(in.readLine());
		list = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<Node>();
		}
		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(in.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			list[from].add(new Node(to, cost));
			list[to].add(new Node(from, cost));
		}
		

		for (int i = 1; i <= N; i++) {
			visited = new boolean[N + 1];
			visited[i] = true;
			dfs(i, 0);
		}
		
		System.out.println(max);
		
	}

	private static void dfs(int i, int cost) {
		for (Node node : list[i]) {
			if (!visited[node.value]) {
				visited[node.value] = true;
				dfs(node.value, cost + node.cost);
			}
		}
		
		if (max < cost) max = cost;
	}

}
