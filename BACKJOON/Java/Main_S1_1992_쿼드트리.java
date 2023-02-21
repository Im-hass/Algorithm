import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//S1_1992_쿼드트리
public class Main_S1_1992_쿼드트리 {
	
	static StringBuilder sb;
	static char[][] spaces; // 영상 정보
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		int N = Integer.parseInt(in.readLine()); // 영상의 크기
		spaces = new char[N][N];
		for (int i = 0; i < N; i++) {
			spaces[i] = in.readLine().toCharArray();
		}
		
		cut(0, 0, N); // y 시작 좌표, x 시작 좌표, 맵 전체 크기
				
		System.out.println(sb);
	}

	/**
	 * 4분할 하는 함수
	 * @param y y 시작 좌표
	 * @param x x 시작 좌표
	 * @param size 맵 전체 크기
	 */
	static void cut(int y, int x, int size) {
		int zero = 0;
		int one = 0;
		for (int i = y, yEnd = y + size; i < yEnd; i++) {
			for (int j = x, xEnd = x + size; j < xEnd; j++) {
				if (spaces[i][j] == '0') { // 영상 내용이 0인 경우
					zero++; // 0 개수 세기
				} else { // 1인 경우
					one++; // 1 개수 세기
				}
			}
		}
		
		if (zero == size * size) { // 영상 내용이 모두 0이라면
			sb.append(0); // 0 추가
		} else if (one == size * size) { // 영상 내용이 모두 1이라면
			sb.append(1); // 1 추가
		} else { // 0과 1이 혼합된 상황 => 4분할
			sb.append("("); // 4개로 나눠지는 시작 괄호 추가
			int half = size / 2;
			cut(y, x, half); // ex) 0~4, 0~4
			cut(y, x + half, half); // ex) 0~4, 4~8
			cut(y + half, x, half); // ex) 4~8, 0~4
			cut(y + half, x + half, half); // ex) 4~8, 4~8
			sb.append(")"); // 4개로 나눠지는 끝 괄호 추가
		}
	}
	
}
