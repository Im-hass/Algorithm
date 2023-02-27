import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_S4_2567_색종이2 {
	
	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { -1, 1, 0, 0 };
	static int[][] map;
	static boolean[][] isVisited;
	static int cnt;

	public static void main(String[] args) throws IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int N = Integer.parseInt(in.readLine()); // 색종이의 개수
		// x y
		map = new int[101][101];
		isVisited = new boolean[101][101];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			for (int j = y; j < y + 10; j++) {
				for (int k = x; k < x + 10; k++) {
					map[j][k] = 1;
				}
			}
		}
		
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				if (map[i][j] == 1) {
					bfs(i, j);
				}
			}
		}
		
		System.out.println(cnt);
		
	}

	private static void bfs(int i, int j) {
		for (int d = 0; d < 4; d++) {
			int ny = i + dy[d];
			int nx = j + dx[d];
			
			if (ny < 101 && ny > -1 && nx < 101 && nx > -1) {
				if (map[ny][nx] != 1) {
					cnt++;
				}
			}
		}
	}
	
}
