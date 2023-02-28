import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2839_임희선 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine()); // 배달해야 하는 설탕 무게
		int answer = 0; // 들고 가야하는 봉지 개수
		
		if (N % 5 == 0) { // 5로 나머지가 0인 경우 => 5kg짜리만 들고 가면 됨
			answer += N / 5;
			N %= 5;
		} else { // 아닌 경우 => 3kg만 또는 3kg + 5kg으로 들고 가면 됨
			while (N > 2) { // N의 값이 2 이하가 될 때까지 반복
				N -= 3;
				answer++;
				if (N % 5 == 0) { // 5kg으로 나눠진다면 => 남은건 5kg짜리만 들고 가면 됨
					answer += N / 5;
					N %= 5;
					break;
				}
			}
		}
		
		if (N == 0) { // 들고 갈 수 있는 경우 0
			System.out.println(answer);			
		} else { // 들고 갈 수 없는 경우
			System.out.println(-1);
		}
	}
	
}
