import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// D4_3289_서로소집합
public class Solution_D4_3289_서로소집합 {
	
	static int n; // 집합의 개수
	static int[] parents; // 루트를 저장할 배열(index = 자기 번호, value = 부모 노드 번호)

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		
		int T = Integer.parseInt(in.readLine());
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			st = new StringTokenizer(in.readLine());
			n = Integer.parseInt(st.nextToken()); // 집합의 개수
			int m = Integer.parseInt(st.nextToken()); // 연산의 개수
			parents = new int[n + 1];
			
			makeSet(); // 부모 노드로 자기 자신을 기본으로 설정
			
			for (int i = 0; i < m; i++) { // 연산 횟수만큼 반복하며 계산
				st = new StringTokenizer(in.readLine());
				int cmd = Integer.parseInt(st.nextToken()); // 명령어(1 = 같은 집합인지 확인, 0 = 합집합 만들기)
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				if (cmd == 1) { // 1 == a와 b가 같은 집합에 포함되어 있는지 확인
					if (findSet(a) == findSet(b)) { // 같은 집합에 포함되어 있는 경우 1 출력
						sb.append(1);
					} else { // 같은 집합이 아닌 경우 0 출력
						sb.append(0);
					}
				} else { // 합집합, a와 b 집합을 합침
					union(a, b);
				}
			}
			
			sb.append("\n");
		}
		
		System.out.println(sb);
		
	}
	
	private static void makeSet() {
		for (int i = 0; i <= n; i++) {
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
