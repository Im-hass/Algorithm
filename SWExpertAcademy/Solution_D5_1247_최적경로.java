import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//D5_1247_최적경로
public class Solution_D5_1247_최적경로 {

//	회사에서 출발하여 N명의 고객을 모두 방문하고 집으로 돌아오는 경로 중 가장 짧은 것
	static int N; // 고객의 수
	static int[] comp; // 회사의 좌표
	static int[] home; // 집의 좌표
	static int[][] matrix; // 고객의 좌표
	static int[] select; // 순열
	static boolean[] isSelected; // 선택 상태
	static int min; // 최단거리 이동 경로
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		
		int T = Integer.parseInt(in.readLine()); // 테스트 케이스 수
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			
			N = Integer.parseInt(in.readLine());
			comp = new int[2];
			home = new int[2];
			matrix = new int[N][2];
			st = new StringTokenizer(in.readLine());
			comp[0] = Integer.parseInt(st.nextToken());
			comp[1] = Integer.parseInt(st.nextToken());
			home[0] = Integer.parseInt(st.nextToken());
			home[1] = Integer.parseInt(st.nextToken());
			for (int i = 0; i < N; i++) {
				matrix[i][0] = Integer.parseInt(st.nextToken());
				matrix[i][1] = Integer.parseInt(st.nextToken());
			}
			
			select = new int[N];
			isSelected = new boolean[N];
			min = Integer.MAX_VALUE;
			
			permu(0);

			sb.append(min).append("\n");
		}
		
		System.out.println(sb);
		
	}

	/**
	 * N명의 고객을 방문하는 모든 경우의 수를 구하는 함수
	 * @param idx 선택된 개수
	 */
	private static void permu(int idx) {
		if (idx == N) { // N개를 모두 골랐을 경우 = N명의 고객집 모두 방문했을 경우
			int sum = 0; // 거리의 합계
			sum += getDistance(comp[0], comp[1], matrix[select[0]][0], matrix[select[0]][1]); // 회사 ~ 1번째 선택된 고객집까지의 거리
			for (int i = 1; i < select.length; i++) { // 1번째 고객집 ~ N번째 고객집 까지의 거리
				sum += getDistance(matrix[select[i - 1]][0], matrix[select[i - 1]][1], matrix[select[i]][0], matrix[select[i]][1]);
			}
			sum += getDistance(matrix[select[select.length - 1]][0], matrix[select[select.length - 1]][1], home[0], home[1]); // N번째 고객집 ~ 집까지의 거리
			
			min = Math.min(min, sum); // 거리 중 최솟값을 찾음
			
			return;
		}
		
		for (int i = 0; i < N; i++) {
			if (isSelected[i]) continue;
			
			select[idx] = i;
			isSelected[i] = true;
			permu(idx + 1);
			isSelected[i] = false;
		}
	}

	/**
	 * 지점1과 지점2 사이 거리를 구하는 함수
	 * (x1, y1)와 (x2, y2) 사이의 거리는 |x1-x2| + |y1-y2|
	 * @param y1 지점1의 y좌표값
	 * @param x1 지점1의 x좌표값
	 * @param y2 지점2의 y좌표값
	 * @param x2 지점2의 x좌표값
	 * @return 지점1(x1, y1)과 지점2(x2, y2) 사이의 거리 반환
	 */
	private static int getDistance(int y1, int x1, int y2, int x2) {
		return Math.abs(x1 - x2) + Math.abs(y1 - y2);
	}
	
}
