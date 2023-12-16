import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// G5_14503_로봇 청소기

// 방의 가장 북쪽, 가장 남쪽, 가장 서쪽, 가장 동쪽 줄 중 하나 이상에 위치한 모든 칸에는 벽이 있다. => 사방이 벽으로 막혀 있다.
// 로봇 청소기가 있는 칸은 항상 빈 칸이다. => 청소기가 있는 칸도 세어야 한다.
public class Main {
	
	public static int[] dy = { -1, 0, 1, 0 };
	public static int[] dx = { 0, 1, 0, -1 };
	
	public static int N; // 방의 세로 크기
	public static int M; // 방의 가로 크기
	
	public static int r; // 로봇 청소기의 세로 위치 좌표
	public static int c; // 로봇 청소기의 가로 위치 좌표
	public static int d; // 로봇 청소기가 바라보는 방향, 0 북, 1 동, 2 남, 3 서
	
	public static int[][] map; // 방의 상태, 0 청소되지 않은 빈칸, 1 벽

	public static void main(String[] args) throws IOException, NumberFormatException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(in.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int cnt = 0;
		while(true) {
			if (map[r][c] == 0) { // 1. 현재 칸이 청소되지 않은 경우
				map[r][c] = 2;
				cnt++;
			}
			
			if (isBlank()) { // 3. 주변 4칸에 청소되지 않은 빈 칸이 있는 경우
				d = (d + 3) % 4; // 3-1. 반시계 방향으로 90도 회전
				int frontR = r + dy[d];
				int frontC = c + dx[d];
				if (map[frontR][frontC] == 0) { // 3-2. 바라보는 앞 칸이 청소되지 않은 빈칸인 경우 한 칸 전진
					r = frontR;
					c = frontC;
				}
			} else { // 2. 주변 4칸에 청소되지 않은 빈 칸이 없는 경우
				if (isReversible()) { // 2-1. 후진할 수 있는 경우
					int backDir = (d + 2) % 4;
					r = r + dy[backDir];
					c = c + dx[backDir];
				} else { // 2-2. 종료
					break;
				}
			}
		}
		
		System.out.println(cnt);
	}
	
	/**
	 * 청소되지 않은 빈칸이 있는지 확인하는 메서드
	 * @return 빈칸이 있으면 true, 없으면 false
	 */
	public static boolean isBlank() {
		for (int dir = 0; dir < 4; dir++) {
			int nx = r + dy[dir];
			int ny = c + dx[dir];
			
			if (map[nx][ny] == 0) {
				return true;
			}
		}
		
		return false;
	}
	
	/**
	 * 후진할 수 있는지 확인하는 메서드 
	 * @return 가능하면 true, 불가능하면 false
	 */
	public static boolean isReversible() {
		int backDir = (d + 2) % 4;
		int backR = r + dy[backDir];
		int backC = c + dx[backDir];
		if (map[backR][backC] != 1) {
			return true;
		}
		
		return false;
	}
	
}
