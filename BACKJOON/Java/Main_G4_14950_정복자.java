import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

class Node implements Comparable<Node> {
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
		return Integer.compare(this.cost, o.cost);
	}
}

public class Main_G4_14950_정복자 {

	static int[] parent;
	static List<Node> list;

	public static void main(String[] args) throws IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());

		int N = Integer.parseInt(st.nextToken()); // 도시의 개수
		int M = Integer.parseInt(st.nextToken()); // 도로의 개수
		int t = Integer.parseInt(st.nextToken()); // 정복할 때 증가하는 도로의 비용(한 번 도시가 정복되면, 모든 도시는 경계를 하게 되기 때문에 모든 도로의 비용이 t만큼
																							// 증가한다)
		list = new ArrayList<>();

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			list.add(new Node(from, to, cost));
		}

		Collections.sort(list);

		parent = new int[N + 1];
		for (int i = 0; i <= N; i++) {
			parent[i] = i;
		}

		int answer = 0;
		int cnt = 0; // 도시가 정복된 횟수

		for (int i = 0; i < list.size(); i++) {
			Node node = list.get(i);
			if (union(node.from, node.to)) {
				answer += cnt * t + node.cost;
				cnt++;
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
		if (aRoot > bRoot)
			parent[aRoot] = bRoot;
		else
			parent[bRoot] = aRoot;
		return true;
	}

}
