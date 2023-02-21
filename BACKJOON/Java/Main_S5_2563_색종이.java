import java.util.Scanner;

public class S5_2563_색종이 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int paper = sc.nextInt(); // 색종이의 수
		int[][] map = new int[100][100]; // 도화지
		int res = 0;
		
		for (int tc = 0; tc < paper; tc++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			
			for (int i = y; i < y + 10; i++) {
				for (int j = x; j < x + 10; j++) {
					if (map[i][j] == 0) {
						map[i][j] = ++res;
					}
				}
			}
		}
		
		System.out.println(res);
		
	}

}
