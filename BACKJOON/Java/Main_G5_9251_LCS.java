import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_G5_9251_LCS {

    private static final int MAX = 1001;
    private static String str1 = "\0";
    private static String str2 = "\0";
    private static int[][] dp = new int[MAX][MAX];

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        str1 = str1 + in.readLine();
        str2 = str2 + in.readLine();

        for (int i = 1; i < str1.length(); i++) {
            for (int j = 1; j < str2.length(); j++) {
                if (str1.charAt(i) == str2.charAt(j))
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                else
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
            }
        }

        System.out.println(dp[str1.length() - 1][str2.length() - 1]);
    }

}
