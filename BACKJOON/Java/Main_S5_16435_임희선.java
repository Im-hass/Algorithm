import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_16435_임희선 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken()); // 과일의 개수
		int L = Integer.parseInt(st.nextToken()); // 스네이크버드의 초기 길이
		st = new StringTokenizer(in.readLine());
		Queue<Integer> h = new ArrayDeque<>(); // 과일의 높이 배열
		for (int i = 0; i < N; i++) {
			h.add(Integer.parseInt(st.nextToken()));
		}
		
		int cnt = 0; // 먹을 수 없는 과일의 개수
		while (!h.isEmpty()) {
			if (cnt == h.size()) { // 먹을 수 없는 과일 밖에 없다면 종료
				break;
			}
			
			int p = h.poll();
			if (p <= L) { // 스네이크버드의 길이와 같거나 작다면 => 먹을 수 있는 과일
				L++;
				cnt = 0;
			} else { // 먹을 수 없는 과일이라면
				cnt++; // 먹을 수 없는 과일 개수 증가
				h.add(p); // 뒷쪽에 다시 넣기
			}
		}
		
		System.out.println(L);
	}
	
}
