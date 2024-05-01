import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main_G4_6497_전력난 {

	static int[] parent;
	static List<Node> list;
	
	static class Node implements Comparable<Node> {
		int x; // x번집
		int y; // y번 집
		int z; // z미터 도로
		public Node(int x, int y, int z) {
			this.x = x;
			this.y = y;
			this.z = z;
		}
		
		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.z, o.z);
		}
	}
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		while (true) {
			st = new StringTokenizer(in.readLine());
			int m = Integer.parseInt(st.nextToken()); // 집의 수
			int n = Integer.parseInt(st.nextToken()); // 길의 수
			
			if (m == 0 && n == 0) break;
			
			list = new ArrayList<>();
			long answer = 0; // 절약할 수 있는 최대 액수
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(in.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int z = Integer.parseInt(st.nextToken());
				list.add(new Node(x, y, z));
				answer += z;
			}

			Collections.sort(list);
			
			parent = new int[m];
			for (int i = 0; i < m; i++) {
				parent[i] = i;
			}
			
			for (int i = 0; i < list.size(); i++) {
				Node node = list.get(i);
				if (union(node.x, node.y)) {
					answer -= node.z;
				}
			}
			
			sb.append(answer).append("\n");
		}

		System.out.println(sb);
		
	}
	
	public static int find(int a) {
		if (parent[a] == a) return a;
		return parent[a] = find(parent[a]);
	}
	
	public static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		
		if (aRoot == bRoot) return false;
		
		if (aRoot > bRoot) parent[aRoot] = bRoot;
		else parent[bRoot] = aRoot;
		
		return true;
	}
	
}
