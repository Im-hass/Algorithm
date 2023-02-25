import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Queue;
import java.util.StringTokenizer;

//S2_1260_DFS와BFS
public class Main_S2_1260_DFS와BFS {

	static StringBuilder sb;
	static int N; // 정점의 개수
	static ArrayList<Integer>[] list; // 인접 리스트
	static boolean[] visited; // 방문 상태 배열
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken()); // 간선의 개수
		int V = Integer.parseInt(st.nextToken()); // 시작할 정점의 번호
		
		list = new ArrayList[N + 1]; // 인접 리스트 배열 초기화
		for (int i = 0; i < N + 1; i++) {
			list[i] = new ArrayList<>();
		}

		int from, to;
		for (int i = 0; i < M; i++) { // 간선의 개수 만큼 입력 받기
			st = new StringTokenizer(in.readLine());
			from = Integer.parseInt(st.nextToken());
			to = Integer.parseInt(st.nextToken());
			
			// 무방향 그래프
			list[from].add(to);
			list[to].add(from);
		}
		
		for (ArrayList<Integer> l: list) { // 같은 차수일 경우, 작은 값 먼저 방문해야 하므로 정렬해야 함
			Collections.sort(l);
		}
		
		visited = new boolean[N + 1]; // 방문 상태 초기화
		dfs(V); // v정점 부터 dfs 탐색
		
		sb.append("\n");
		
		visited = new boolean[N + 1]; // 방문 상태 초기화
		bfs(V); // v정점 부터  bfs 탐색
		
		System.out.println(sb);
		
	}

	private static void dfs(int start) { // 깊이 우선 탐색 
		visited[start] = true;
		sb.append(start).append(" ");
		
		for (int v: list[start]) {
			if (!visited[v]) {
				dfs(v);
			}
		}
	}
	
	private static void bfs(int start) { // 너비 우선 탐색
		Queue<Integer> q = new ArrayDeque<>();
		
		q.offer(start);
		visited[start] = true;
		
		int curr = 0;
		while (!q.isEmpty()) {
			curr = q.poll();
			sb.append(curr).append(" ");
			for (int v: list[curr]) {
				if (!visited[v]) {
					q.offer(v);
					visited[v] = true;
				}
			}
		}
	}

}
