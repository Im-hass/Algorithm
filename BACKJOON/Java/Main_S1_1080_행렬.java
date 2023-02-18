import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int[][] A; // 행렬 A
	static int[][] B; // 행렬 B

	public static void main(String[] args) throws IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken()); // 행렬의 세로 크기
		int M = Integer.parseInt(st.nextToken()); // 행렬의 가로 크기
		
		A = new int[N][M]; // 행렬 A
		B = new int[N][M]; // 행렬 B
		for (int i = 0; i < N; i++) { // 행렬 A 입력 받기
			String c = in.readLine();
			for (int j = 0; j < M; j++) {
				A[i][j] = c.charAt(j) - '0';
			}
		}
		for (int i = 0; i < N; i++) { // 행렬 B 입력 받기
			String c = in.readLine();
			for (int j = 0; j < M; j++) {
				B[i][j] = c.charAt(j) - '0';
			}
		}

		boolean isMatch = isMatch(0, 0, N, M);

		if (isMatch) {
			System.out.println(0);
			return;
		}
		
		if (N < 2 || M < 2) {
			System.out.println(-1);
			return;
		}

		int cnt = 0;
		for (int i = 0; i < N - 2; i++) {
			for (int j = 0; j < M - 2; j++) {
				if (A[i][j] != B[i][j]) {
					reverse(i, j, N, M); // 제일 위 y, x 인덱스
					cnt++;
				}
			}
		}

		isMatch = isMatch(0, 0, N, M);
		
		if (isMatch) {
			System.out.println(cnt);
		} else {
			System.out.println(-1);
		}
		
	}

	private static void reverse(int y, int x, int N, int M) {
		int ny = y + 3;
		int nx = x + 3;
		
		for (int i = y; i < ny; i++) {
			for (int j = x; j < nx; j++) {
				A[i][j] = 1 - A[i][j];
			}
		}
	}
	
	private static boolean isMatch(int y1, int x1, int y2, int x2) {
		boolean isMatch = true;
		
		for (int i = y1; i < y2; i++) {
			for (int j = x1; j < x2; j++) {
				if (A[i][j] != B[i][j]) {
					isMatch = false;
					break;
				}
			}
		}
		
		return isMatch;
	}
	
}
