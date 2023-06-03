import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_D2_1288_새로운_불면증_치료법 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(in.readLine()); // 테스트 케이스
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			
			int N = Integer.parseInt(in.readLine()); // 숫자
			int k = 1; // 곱할 수
			int count = 0; // 나온 숫자의 개수(0~9 => 10개)
			int[] countArr = new int[10]; // 0~9가 있는지 체크
			for (;;) {
				int now = N * k++; // 현재 양
				char[] nowArr = (now + "").toCharArray(); // 현재 양의 각 자릿수
//				char[] nowArr = String.valueOf(N * k++).toCharArray(); // 위 두 줄과 동일
				for (int i = 0; i < nowArr.length; i++) {
					if (countArr[nowArr[i] - '0'] == 0) { // 아직 나타나지 않은 수라면
						countArr[nowArr[i] - '0'] = 1; // 나타난수로 표시
						count++; // 나온 숫자 개수 증가
					}
				}
				if (count == 10) break;
			}
			sb.append((k - 1) * N).append("\n");
		}
		
		System.out.println(sb);
		
	}
	
}
