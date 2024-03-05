package _0305_G4_14502_연구소;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

// G4_14502_연구소
public class Main {

	static int max = Integer.MIN_VALUE;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int N = Integer.parseInt(st.nextToken()); // 지도 세로
		int M = Integer.parseInt(st.nextToken()); // 지도 가로
		int[][] map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dfs(N, M, map, 0);

		System.out.println(max);
		
	}
	
	public static void dfs(int N, int M, int[][] map, int cnt) {
		if (cnt == 3) {
			int[][] tempMap = new int[N][M];
			for (int i = 0; i < N; i++) {
				tempMap[i] = map[i].clone();
			}
			
			setVirus(N, M, tempMap);
			max = Integer.max(max, getSafeZoneCount(N, M, tempMap));
			
			return;
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 0) {
					map[i][j] = 1;
					dfs(N, M, map, cnt + 1);
					map[i][j] = 0;
				}
			}
		}
	}
	
	public static void setVirus(int N, int M, int[][] map) {
		Queue<int[]> q = new ArrayDeque<>();
		int[] dy = { -1, 0, 1, 0 };
		int[] dx = { 0, 1, 0, -1 };
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 2) {
					q.offer(new int[] {i, j});
				}
			}
		}
		
		while (!q.isEmpty()) {
			int y = q.peek()[0];
			int x = q.peek()[1];
			q.poll();
			
			for (int d = 0; d < 4; d++) {
				int ny = y + dy[d];
				int nx = x + dx[d];
				if (ny > -1 && ny < N && nx > -1 && nx < M) {
					if (map[ny][nx] == 0) {
						q.offer(new int[] {ny, nx});
						map[ny][nx] = 2;
					}
				}
			}
		}
	}
	
	public static int getSafeZoneCount(int N, int M, int[][] map) {
		int count = 0;
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 0) {
					count++;
				}
			}
		}
		
		return count;
	}

}
