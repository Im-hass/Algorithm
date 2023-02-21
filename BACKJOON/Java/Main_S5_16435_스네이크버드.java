import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

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
		
		int no = 0;
		while (!h.isEmpty()) {
			if (no == h.size()) {
				break;
			}
			int p = h.poll();
			if (p <= L) {
				L++;
				no = 0;
			} else {
				no++;
				h.add(p);
			}
		}
		
		System.out.println(L);
	}
	
}
