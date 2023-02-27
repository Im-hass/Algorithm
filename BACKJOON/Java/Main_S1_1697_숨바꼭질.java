import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

//S1_1697_숨바꼭질
public class Main_S1_1697_숨바꼭질 {
	
	static int[] distance; // 해당 위치까지 이동하는데 걸린 시간 목록(index = 위치, value = 걸린 초)
	static int N; // 수빈이의 위치
	static int K; // 동생의 위치

	public static void main(String[] args) throws IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		distance = new int[100001]; // 최대 위치까지 배열 생성
		
		bfs(); // 너비 우선 탐색
		
	}

	private static void bfs() {
		Queue<Integer> q = new ArrayDeque<>();
		q.offer(N); // 시작 위치(현재 위치) 넣기
		
		while (!q.isEmpty()) {
			int now = q.poll(); // 현재 위치 꺼내기
			if (now == K) { // 현재 위치가 동생 위치와 같다면
				System.out.println(distance[now]); // 거리 출력 후 종료
				break;
			}

			// 현재 위치에서 -1, +1, *2 했을 때
			for (int next: new int[] {now - 1, now + 1, now * 2}) {
				// 값이 0 ~ 100000이고, 0이 아니라면(= 첫 방문일 경우)
				if (0 <= next && next <= 100000 && distance[next] == 0) {
					distance[next] = distance[now] + 1; // 다음 위치까지 이동하는 시간 = 현재 위치까지 오는데 걸린 초 + 1초
		        	q.offer(next);
		        }
			}
		}
	}
	
}
