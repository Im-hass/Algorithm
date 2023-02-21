import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

//G5_10026_적록색약
public class Main_G5_10026_적록색약 {

	static int[] dx = { 0, 0, 1, -1 }; // 상하좌우
	static int[] dy = { -1, 1, 0, 0 }; // 상하좌우
	static int N; // 그림 크기
	static char[][] map; // 그림 정보
	static boolean[][] isVisited; // 방문 상태

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(in.readLine());
		map = new char[N][N];
		for (int i = 0; i < N; i++) {
			map[i] = in.readLine().toCharArray();
		}

		// 색약이 아닌 경우
		int areaCnt = 0; // 영역 개수
		isVisited = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!isVisited[i][j]) { // 방문 상태가 아니면 방문
					areaCnt++; // 영역 개수 증가
					dfs(i, j, false); // y좌표, x좌표, 색약이 아닐 경우
				}
			}
		}

		sb.append(areaCnt).append(" ");

		// 색약인 경우
		areaCnt = 0; // 영역 개수 초기화
		isVisited = new boolean[N][N]; // 방문 상태 초기화
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!isVisited[i][j]) { // 방문 상태가 아니면 방문
					areaCnt++; // 영역 개수 증가
					dfs(i, j, true); // y좌표, x좌표, 색약일 경우
				}
			}
		}

		sb.append(areaCnt).append(" ");

		System.out.println(sb);

	}

	/**
	 * 영역을 탐색하는 함수
	 * 
	 * @param i               y 좌표
	 * @param j               x 좌표
	 * @param isColorWeakness 색약 구분, true면 색약
	 */
	private static void dfs(int i, int j, boolean isColorWeakness) {
		Stack<int[]> s = new Stack<>();
		s.push(new int[] { i, j });

		while (!s.isEmpty()) {
			int y = s.peek()[0];
			int x = s.peek()[1];
			isVisited[y][x] = true;
			s.pop();

			for (int d = 0; d < 4; d++) {
				int ny = y + dy[d];
				int nx = x + dx[d];

				if (ny < N && ny > -1 && nx < N && nx > -1 && !isVisited[ny][nx]) { // 그림 내부고 방문한적 없을 경우
					if (!isColorWeakness && map[y][x] == map[ny][nx]) { // 적녹색약이 아니고, 현재와 다음 영역이 같은 영역일 경우
						isVisited[ny][nx] = true; // 방문 처리
						s.push(new int[] { ny, nx }); // 스택에 추가
					} else if (isColorWeakness) { // 적녹색약일 경우
						if (map[y][x] == map[ny][nx] ||
								(map[y][x] == 'R' && map[ny][nx] == 'G') ||
								(map[y][x] == 'G' && map[ny][nx] == 'R')) { // 현재 영역과 다음 영역이 같은 영역이거나, 현재 영역이 R이고 다음 영역이
																			// G이거나, 현재 영역이 G이고 다음 영역이 R일 경우
							isVisited[ny][nx] = true; // 방문 처리
							s.push(new int[] { ny, nx }); // 스택에 추가
						}
					}
				}
			}
		}
	}
}
