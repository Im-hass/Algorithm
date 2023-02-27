import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//G4_1987_알파벳
public class Main_G4_1987_알파벳 {
	
	static int[] dy = { -1, 1, 0, 0 }; // 상하좌우
	static int[] dx = { 0, 0, -1, 1 }; // 상하좌우
	static int R; // 세로
	static int C; // 가로
	static char[][] board; // 보드
	static boolean[] isVisitedAlpabat; // 방문 상태 배열
	static int answer; // 현재 있는 칸 포함

	public static void main(String[] args) throws IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		board = new char[R][C];
		for (int i = 0; i < R; i++) {
			board[i] = in.readLine().toCharArray();
		}
		
		isVisitedAlpabat = new boolean[26]; // 알파벳 개수만큼 생성
		isVisitedAlpabat[board[0][0] - 65] = true; // 첫 위치(0, 0) 알파벳 방문 처리
		answer = Integer.MIN_VALUE;
		
		dfs(0, 0, 1); // 깊이 우선 탐색
		
		System.out.println(answer);
		
	}

	/**
	 * 
	 * @param i y좌표
	 * @param j x좌표
	 * @param cnt 지나간 칸 수
	 */
	private static void dfs(int i, int j, int cnt) {
		answer = Math.max(answer, cnt); // 최대 칸수로 갱신
		
		for (int d = 0; d < 4; d++) {
			int ny = i + dy[d];
			int nx = j + dx[d];

			if (ny < R && ny > -1 && nx < C && nx > -1) {
				if (!isVisitedAlpabat[board[ny][nx] - 65]) { // 방문한 적 없는 알파벳일 경우
					isVisitedAlpabat[board[ny][nx] - 65] = true;
					dfs(ny, nx, cnt + 1); // 지나간 칸 수 증가
					isVisitedAlpabat[board[ny][nx] - 65] = false;
				}
			}
		}
	}
	
}
