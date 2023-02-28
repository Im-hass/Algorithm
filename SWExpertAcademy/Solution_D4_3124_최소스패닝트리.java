import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//D4_3124_최소스패닝트리
public class Solution_D4_3124_최소스패닝트리 {
	
	static int V, E;
	static Edge[] list;
	static int[] parents;
	
	static class Edge implements Comparable<Edge> {
		int from;
		int to;
		int weight;
		
		public Edge(int from, int to, int weight) {
			super();
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return this.weight - o.weight;
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		StringTokenizer st = null;
		
		int T = Integer.parseInt(in.readLine()); // 테스트 케이스 수
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			
			st = new StringTokenizer(in.readLine());
			V = Integer.parseInt(st.nextToken()); // 정점의 개수
			E = Integer.parseInt(st.nextToken()); // 간선의 개수
			list = new Edge[E];
			parents = new int[V + 1];
			for (int i = 0; i < E; i++) {
				st = new StringTokenizer(in.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				int weight = Integer.parseInt(st.nextToken());
				list[i] = new Edge(from, to, weight);
			}
			
			Arrays.sort(list); // 오름차순으로 정렬
			
			makeSet();
			
			long result = 0;
			int count = 0;
			
			for (Edge e: list) {
				if (union(e.from, e.to)) {
					result += e.weight;
					
					if (++count == V - 1) {
						break;
					}
				}
			}
			
			
			sb.append(result).append("\n");
		}
		
		System.out.println(sb);
		
	}

	private static void makeSet() {
		for (int i = 0; i <= V; i++) {
			parents[i] = i;
		}
	}
	
	private static int findSet(int a) {
		if (a == parents[a]) {
			return a;
		}
		
		return parents[a] = findSet(parents[a]);
	}

	private static boolean union(int from, int to) {
		int aRoot = findSet(from);
		int bRoot = findSet(to);
		
		if (aRoot == bRoot) {
			return false;
		}
		
		parents[bRoot] = aRoot;
		return true;
	}
	
}
