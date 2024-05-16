import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_G5_5582_공통부분문자열 {
	
	static int[][] dp;
	static int max;

	public static void main(String[] args) throws IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		String str1 = in.readLine();
		String str2 = in.readLine();

		dp = new int[str2.length() + 1][str1.length() + 1];

		for (int i = 1; i <= str2.length(); i++) {
			char c1 = str2.charAt(i - 1);

			for (int j = 1; j <= str1.length(); j++) {
				char c2 = str1.charAt(j - 1);

				if (c1 == c2) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
					max = Math.max(max, dp[i][j]);
				}
			}
		}

		System.out.println(max);
		
	}
	
}
