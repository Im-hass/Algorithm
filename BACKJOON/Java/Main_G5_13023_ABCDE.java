import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

//G5_13023_ABCDE
public class Main_G5_13023_ABCDE {

//	A, B, C, D, E가 존재하면 1을 없으면 0
	static List<Integer>[] list; // 각 사람들의 친구 목록
	static boolean[] isVisited; // 방문 상태
	static boolean isEnd; // 끝인지 검사
	static int vistCnt; // 누적 방문수 = 누적 친구 수
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken()); // 사람의 수
		int M = Integer.parseInt(st.nextToken()); // 친구 관계의 수
		
		list = new ArrayList[N];
		for (int i = 0; i < N; i++) {
			list[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			list[from].add(to);
			list[to].add(from);
		}
		
		for (int i = 0; i < N; i++) {
			isVisited = new boolean[N];
			vistCnt = 0;
			isEnd = false;
			dfs(i, 0); // 시작 정점
			if (isEnd) {
				break;
			}
		}
		if (isEnd) {
			System.out.println(1);
		} else {
			System.out.println(0);
		}
	}

	private static void dfs(int curr, int vistCnt) {
		if (vistCnt >= 4) {
			isEnd = true;
			return;
		}
		
		isVisited[curr] = true;
		
		for (int vertex: list[curr]) {
			if (!isVisited[vertex]) {
				isVisited[vertex] = true;
				dfs(vertex, vistCnt + 1);
				isVisited[vertex] = false;
			}
		}
	}
}
