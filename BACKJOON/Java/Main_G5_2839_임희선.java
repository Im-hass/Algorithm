import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		int answer = 0;
		
		if (N % 5 == 0) {
			answer += N / 5;
			N %= 5;
		} else {
			while (N > 2) {
				N -= 3;
				answer++;
				if (N % 5 == 0) {
					answer += N / 5;
					N %= 5;
					break;
				}
			}
		}
		
		if (N == 0) {
			System.out.println(answer);			
		} else {
			System.out.println(-1);
		}
	}
	
}