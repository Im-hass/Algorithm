import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//G5_1759_암호만들기
public class Main_G5_1759_암호만들기 {

	static StringBuilder sb;
	static int L; // 암호 길이: 서로 다른 L개의 알파벳(소문자)
	static int C; // 문자의 종류 개수
	static char[] alpabet; // 사용 가능한 문자
	static char[] select; // 문자 조합
	static char[] vowel = { 'a', 'e', 'i', 'o', 'u' }; // 모음

	public static void main(String[] args) throws IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		alpabet = new char[C];
		select = new char[L];
		st = new StringTokenizer(in.readLine());
		for (int i = 0; i < C; i++) {
			alpabet[i] = st.nextToken().charAt(0);
		}
		
		Arrays.sort(alpabet);
		
		combination(0, 0);
		
		System.out.println(sb);
	}
	
	/**
	 * 암호 길이만큼 알파벳을 조합하는 함수
	 * @param idx
	 * @param start
	 */
	private static void combination(int idx, int start) {
		if (idx == L) {
			int vCnt = 0; // 모음 개수
			int cCnt = 0; // 자음 개수
			boolean isV = false;
			for (int i = 0; i < select.length; i++) { // 조합된 알파벳 하나씩 검사
				for (int j = 0; j < vowel.length; j++) { // 알파벳이 모음인지 하나씩 비교
					if (select[i] == vowel[j]) { // 알파벳이 모음일 경우
						isV = true;
						break;
					}
				}
				
				if (isV) { // 모음일 경우
					vCnt++; // 모음 개수 추가
				} else { // 자음일 경우
					cCnt++; // 자음 개수 추가
				}
				
				isV = false; // 초기화
			}
			
			if (vCnt >= 1 && cCnt >= 2) { // 1개 이상의 모음과 2개 이상의 자음이 있을 경우 => 가능한 암호
				for (char c: select) {
					sb.append(c);
				}
				sb.append("\n");
			}
			
			return;
		}
		
		for (int i = start; i < C; i++) {
			select[idx] = alpabet[i];
			combination(idx + 1, i + 1);
		}
	}
	
}
