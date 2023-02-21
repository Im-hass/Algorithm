import java.util.Arrays;
import java.util.Scanner;

public class B1_18766_카드바꿔치기 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt(); // 테스트케이스
		
		for (int tc = 0; tc < T; tc++) {
			int card = sc.nextInt(); // 카드 개수
			String[] start = new String[card]; // 카드놀이를 하기 전 카드
			String[] end = new String[card]; // 카드놀이가 끝난 후 카드
			boolean isCheater = false;
			
			for (int i = 0; i < card; i++) {
				start[i] = sc.next();
			}
			
			for (int i = 0; i < card; i++) {
				end[i] = sc.next();
			}
			
			Arrays.sort(start);
			Arrays.sort(end);
			
			for (int i = 0; i < card; i++) {
				if (!start[i].equals(end[i])) {
					isCheater = true;
					break;
				}
			}
			
			if (isCheater) {
				System.out.println("CHEATER");
			} else {
				System.out.println("NOT CHEATER");
			}
		}
		
	}

}
