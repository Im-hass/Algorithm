import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_G4_9252_LCS2 {

	public static void main(String[] args) throws IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String s1 = '\0' + in.readLine();
		String s2 = '\0' + in.readLine();
		int[][] dp = new int[s1.length()][s2.length()];

		for (int i = 1; i < s1.length(); i++) {
			char c1 = s1.charAt(i);
			for (int j = 1; j < s2.length(); j++) {
				char c2 = s2.charAt(j);
				if (c1 == c2)
					dp[i][j] = dp[i - 1][j - 1] + 1; // 같은 문자열이라면, 대각선 값 + 1
				else
					dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]); // 다른 문자열이라면, 더 큰 값 저장
			}
		}

		int len = dp[s1.length() - 1][s2.length() - 1];
		char[] answer = new char[len]; // 정답이 반대로 저장됨
		int idx = 0; // answer 배열 인덱스
		int y = s1.length() - 1;
		int x = s2.length() - 1;
		while (dp[y][x] != 0) { // 0을 만나면 종료
			// y축 먼저 탐색
			// 현재 값의 상/좌에서 같은 값이 있는지 탐색
			if (dp[y][x] == dp[y - 1][x]) { // 만약 상(y - 1)값이 같으면, 상으로 이동
				y--;
			} else if (dp[y][x] == dp[y][x - 1]) { // 만약 좌(x - 1)값이 같으면, 좌로 이동
				x--;
			} else { // 같은 값이 없다면, answer에 현재 문자열 추가(y 기준) 후 대각선(-1, -1)으로 이동
				answer[idx] = s1.charAt(y);
				idx++;
				y--;
				x--;
			}
		}

		// 정답 출력
		System.out.println(len);
		for (int i = len - 1; i > -1; i--) {
			System.out.print(answer[i]);
		}

	}

}
