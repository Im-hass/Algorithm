import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 비트마스킹
public class Solution_D3_10726_이진수_표현 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		
		int T = Integer.parseInt(in.readLine()); // 테스트 케이스
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			
			st = new StringTokenizer(in.readLine());
			int N = Integer.parseInt(st.nextToken()); // 마지막 N개의 비트
			int M = Integer.parseInt(st.nextToken()); // 정수 M

			int on = (1 << N) - 1;
			if (on == (M & on)) {
				sb.append("ON");
			} else {
				sb.append("OFF");
			}

			sb.append("\n");
		}
		
		System.out.println(sb);
		
	}
	
}

//전부 1이 나와야 함 => 모든 각자릿수들이 1이 나오면 == 모든 각자리수를 &했을 때 1 => ON

// 30(10) = 11110(2) => OFF
// 47(10) = 101111(2) => ON
