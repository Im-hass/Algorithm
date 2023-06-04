import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

// 링크드리스트
public class Solution_D3_1230_암호문3 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		
		for (int tc = 1; tc <= 10; tc++) {
			sb.append("#").append(tc).append(" ");

			LinkedList<Integer> list = new LinkedList<>(); // 암호문
			int N = Integer.parseInt(in.readLine()); // 원본 암호문의 길이
			st = new StringTokenizer(in.readLine());
			for (int i = 0; i < N; i++) { // 원본 암호문 입력 받기
				list.add(Integer.parseInt(st.nextToken()));
			}
			int M = Integer.parseInt(in.readLine()); // 명령어의 개수
			st = new StringTokenizer(in.readLine());
			for (int i = 0; i < M; i++) {
				String cmd = st.nextToken(); // 명령어
				if ("I".equals(cmd)) { // I 삽입  => x, y, s
					int x = Integer.parseInt(st.nextToken()); // x의 위치 바로 다음
					int y = Integer.parseInt(st.nextToken()); // y개의 숫자
					for (int j = 0; j < y; j++) {
						list.add(x + j, Integer.parseInt(st.nextToken()));
					}
				} else if ("D".equals(cmd)) { // D 삭제 => x, y
					int x = Integer.parseInt(st.nextToken()); // x의 위치 바로 다음
					int y = Integer.parseInt(st.nextToken()); // y개의 숫자
					for (int j = 0; j < y; j++) {
						list.remove(x);
					}
				} else { // A 추가 => y, s
					int y = Integer.parseInt(st.nextToken()); // y개의 숫자
					for (int j = 0; j < y; j++) {
						list.add(Integer.parseInt(st.nextToken()));
					}
				}
			}
			
			for (int i = 0; i < 10; i++) {
				sb.append(list.get(i)).append(" ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
		
	}
	
}
