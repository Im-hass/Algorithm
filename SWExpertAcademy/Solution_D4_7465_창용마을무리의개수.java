import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

//D4_7465_창용마을무리의개수
public class Solution_D4_7465_창용마을무리의개수 {
	
	static int N; // 사람 수
	static int[] parents; // 루트를 저장할 배열(index = 자기 번호, value = 부모 노드 번호)

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		
		int T = Integer.parseInt(in.readLine());
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			
			st = new StringTokenizer(in.readLine());
			N = Integer.parseInt(st.nextToken());
			parents = new int[N + 1];
			int M = Integer.parseInt(st.nextToken()); // 서로 알고 있는 사람의 관계 수
			
			makeSet(); // 부모 노드로 자기 자신을 기본으로 설정
			
			for (int i = 0; i < M; i++) { // 아는 사이 입력 받기
				st = new StringTokenizer(in.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				union(a, b); // 합집합 만들기
			}
			
			Set<Integer> s = new HashSet<>(); // 중복 제거
			for (int i = 1; i <= N; i++) { // 1부터 N까지
				s.add(findSet(i)); // 부모 노드를 찾아서 set에 추가
			}
			
			sb.append(s.size()).append("\n");
		}
		
		System.out.println(sb);
		
	}

	private static void makeSet() {
		for (int i = 1; i <= N; i++) {
			parents[i] = i;
		}
	}
	
	private static int findSet(int a) {
		if (parents[a] == a) {
			return a;
		}
		
		return parents[a] = findSet(parents[a]);
	}

	private static void union(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		
		if (aRoot == bRoot) {
			return;
		}
		
		parents[bRoot] = aRoot;
	}
	
}
