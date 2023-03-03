import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

//G5_7569_토마토
public class Main_G5_7569_토마토 {
	
//	위, 아래, 왼쪽, 오른쪽, 앞, 뒤 여섯 방향
	static int[] dx = { 0, 0, -1, 1, 0, 0 };
	static int[] dy = { 0, 0, 0, 0, 1, -1 };
	static int[] dz = { 1, -1, 0, 0, 0, 0 };
	static Queue<int[]> q;
	static int M; // 상자의 가로
	static int N; // 상자의 세로
	static int H; // 상자의 높이
	static int[][][] box; // 토마토가 든 상자
	static int max;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		M = Integer.parseInt(st.nextToken()); // 상자의 가로
		N = Integer.parseInt(st.nextToken()); // 상자의 세로
		H = Integer.parseInt(st.nextToken()); // 상자의 높이
		box = new int[H][N][M]; // 토마토가 든 상자
		int cnt1 = 0; // 익은 토마토 개수
		int cnt2 = 0; // 토마토가 들어있지 않은 칸 개수
		for (int i = 0; i < H; i ++) { // 상자 정보 입력 받기
//			1은 익은 토마토
//			0 은 익지 않은 토마토
//			-1은 토마토가 들어있지 않은 칸
			for (int j = 0; j < N; j++) {
				st = new StringTokenizer(in.readLine());
				for (int k = 0; k < M; k++) {
					box[i][j][k] = Integer.parseInt(st.nextToken());
					if (box[i][j][k] == 1) { // 익은 토마토 개수 증가
						cnt1++;
					} else if (box[i][j][k] == -1) { // 토마토가 없는 칸 개수 증가
						cnt2++;
					}
				}
				
			}
		}
		
		if ((cnt1 + cnt2) == M * N * H) { // 이미 전부 익어 있는 상자일 경우
			System.out.println(0); // 0 출력 후 종료
			return;
		}

		q = new ArrayDeque<>();
		max = Integer.MIN_VALUE;
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < M; k++) {
					if (box[i][j][k] == 1) { // 토마토가 있는 칸일 경우
						q.offer(new int[] {i, j, k}); // 큐에 한 번에 넣기
					}
				}
			}
		}
		
		bfs();
		
		boolean isRipeable = true; // 전부 익었는가
		for (int[][] pan: box) {
			for (int[] row: pan) {
				for (int value: row) {
					if (value == 0) { // 익지 않은 토마토가 있을 경우
						isRipeable = false; // false로 바꾸고 종료
						break;
					}
				}
				if (!isRipeable) {
					break;
				}
			}
			if (!isRipeable) {
				break;
			}
		}
		
		if (!isRipeable) { // 전체가 익을 수 없다면
			System.out.println(-1); // -1 출력
			return;
		}
		
		System.out.println(max - 1); // 날짜를 1일로 시작해서 -1일 해주기
	}

	private static void bfs() {
		while (!q.isEmpty()) {
			int h = q.peek()[0];
			int y = q.peek()[1];
			int x = q.peek()[2];
			q.poll();
			
			for (int d = 0; d < 6; d++) { // 6방향 탐색
				int nh = h + dz[d]; // 높이
				int ny = y + dy[d]; // 세로
				int nx = x + dx[d]; // 가로
				
				if (nh < H && nh > -1 &&
					ny < N && ny > -1 &&
					nx < M && nx > -1) {
					if (box[nh][ny][nx] == 0) {
						q.offer(new int[] {nh, ny, nx});
						box[nh][ny][nx] = box[h][y][x] + 1; // 이전 일자 + 1일자로 값 갱신
						max = Math.max(max, box[nh][ny][nx]); // 최대값 찾기
					}
				}
				
			}
		}
		
	}

}
