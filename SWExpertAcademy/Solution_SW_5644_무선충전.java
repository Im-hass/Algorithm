import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

//SW모의역량_5644_무선충전
public class Solution_SW_5644_무선충전 {
	
	static int M; // 총 이동 시간
	static int A; // BC의 개수
	static int[][] BC; // BC 정보, [[x, y, 충전범위 C, 성능 P], ...] 

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(in.readLine()); // 테스트 케이스 수
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			
			StringTokenizer st = new StringTokenizer(in.readLine());
			M = Integer.parseInt(st.nextToken());
			A = Integer.parseInt(st.nextToken());
			
			// 사용자A는 지도의 (1, 1) 지점에서, 사용자B는 지도의 (10, 10) 지점에서 출발
			int[][] userA = new int[M + 1][2]; // 사용자A의 이동 경로
			userA[0][0] = 0;
			userA[0][1] = 0;
			st = new StringTokenizer(in.readLine());
			for (int i = 1 ; i < M + 1; i++) {
				int cmd = Integer.parseInt(st.nextToken());
				userA[i] = getYX(cmd, userA[i - 1][0], userA[i - 1][1]);
			}
			
			int[][] userB = new int[M + 1][2]; // 사용자A의 이동 경로
			userB[0][0] = 9;
			userB[0][1] = 9;
			st = new StringTokenizer(in.readLine());
			for (int i = 1 ; i < M + 1; i++) {
				int cmd = Integer.parseInt(st.nextToken());
				userB[i] = getYX(cmd, userB[i - 1][0], userB[i - 1][1]);
			}
			
			// 배터리 정보
			BC = new int[A][4];
			for (int i = 0 ; i < A; i++) {
				st = new StringTokenizer(in.readLine());
				for (int j = 0; j < 4; j++) {
					BC[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			int sum = 0;
			for (int i = 0; i < M + 1; i++) {
				List<int[]> listA = getAccessibleList(userA[i][0], userA[i][1]);
				List<int[]> listB = getAccessibleList(userB[i][0], userB[i][1]);
				
				Collections.sort(listA, (a, b) -> {
					return b[3] - a[3];
				});
				
				Collections.sort(listB, (a, b) -> {
					return b[3] - a[3];
				});
				
				if (listA.size() >= 2) { // userA가 충전 가능한 BC가 2개 이상일 경우
					if (listB.size() >= 2) { // userB가 충전 가능한 BC가 2개 이상일 경우
						if (listA.get(0)[0] == listB.get(0)[0] &&
							listA.get(0)[1] == listB.get(0)[1] &&
							listA.get(0)[3] == listB.get(0)[3]) { // 동일한 BC일 경우
							if (listA.get(1)[3] >= listB.get(1)[3]) {
								sum += listA.get(1)[3];
								sum += listB.get(0)[3];
							} else {
								sum += listA.get(0)[3];
								sum += listB.get(1)[3];
							}
						} else { // 동일한 BC가 아닐 경우
							sum += listA.get(0)[3];
							sum += listB.get(0)[3];
						}
					} else if (listB.size() == 1) { // userB가 충전 가능한 BC가 1개일 경우 => A, B 선택지 없음
						if (listA.get(0)[0] == listB.get(0)[0] &&
							listA.get(0)[1] == listB.get(0)[1] &&
							listA.get(0)[3] == listB.get(0)[3]) { // 동일한 BC일 경우
							sum += listA.get(1)[3];
							sum += listB.get(0)[3];
						} else {
							sum += listA.get(0)[3];
							sum += listB.get(0)[3];
						}
					} else {
						sum += listA.get(0)[3];
					}
				} else if (listB.size() >= 2) { // userB가 충전 가능한 BC가 2개 이상일 경우
					if (listA.size() >= 2) { // userA가 충전 가능한 BC가 2개 이상일 경우
						if (listA.get(0)[0] == listB.get(0)[0] &&
							listA.get(0)[1] == listB.get(0)[1] &&
							listA.get(0)[3] == listB.get(0)[3]) { // 동일한 BC일 경우
							if (listA.get(1)[3] >= listB.get(1)[3]) {
								sum += listA.get(1)[3];
								sum += listB.get(0)[3];
							} else {
								sum += listA.get(0)[3];
								sum += listB.get(1)[3];
							}
						} else { // 동일한 BC가 아닐 경우
							sum += listA.get(0)[3];
							sum += listB.get(0)[3];
						}
					} else if (listA.size() == 1) { // userA가 충전 가능한 BC가 1개일 경우 => A, B 선택지 없음
						if (listA.get(0)[0] == listB.get(0)[0] &&
							listA.get(0)[1] == listB.get(0)[1] &&
							listA.get(0)[3] == listB.get(0)[3]) { // 동일한 BC일 경우
							sum += listA.get(0)[3];
							sum += listB.get(1)[3];
						} else {
							sum += listA.get(0)[3];
							sum += listB.get(0)[3];
						}
					} else {
						sum += listB.get(0)[3];
					}
				} else if (listA.size() == 1) { // userA가 충전 가능한 BC가 1개일 경우
					if (listB.size() >= 2) { // userB가 충전 가능한 BC가 2개 이상일 경우
						sum += listA.get(0)[3];
						sum += listB.get(1)[3];
					} else if (listB.size() == 1) { // userB가 충전 가능한 BC가 1개일 경우 => A, B 선택지 없음
						if (listA.get(0)[0] == listB.get(0)[0] &&
							listA.get(0)[1] == listB.get(0)[1] &&
							listA.get(0)[3] == listB.get(0)[3]) { // 동일한 BC일 경우
							sum += listA.get(0)[3];
						} else { // 동일한 BC가 아닐 경우
							sum += listA.get(0)[3];
							sum += listB.get(0)[3];
						}
					} else {
						sum += listA.get(0)[3];
					}
				} else if (listB.size() == 1) { // userB가 충전 가능한 BC가 1개일 경우
					if (listA.size() >= 2) { // userA가 충전 가능한 BC가 2개 이상일 경우
						sum += listA.get(1)[3];
						sum += listB.get(0)[3];
					} else if (listA.size() == 1) { // userA가 충전 가능한 BC가 1개일 경우 => A, B 선택지 없음
						if (listA.get(0)[0] == listB.get(0)[0] &&
							listA.get(0)[1] == listB.get(0)[1] &&
							listA.get(0)[3] == listB.get(0)[3]) { // 동일한 BC일 경우
							sum += listA.get(0)[3];
						} else { // 동일한 BC가 아닐 경우
							sum += listA.get(0)[3];
							sum += listB.get(0)[3];
						}
					} else {
						sum += listB.get(0)[3];
					}
				}
			}
			
			sb.append(sum).append("\n");
		}
		
		System.out.println(sb);
		
	}
	
	/**
	 * y, x 좌표 구하는 함수
	 * @param cmd 명령어
	 * @param y 시작 y 위치
	 * @param x 시작 x 위치
	 * @return y, x 좌표 배열
	 */
	private static int[] getYX(int cmd, int y, int x) {
		switch (cmd) {
		case 0: // 이동하지 않음
			break;
		case 1: // 상
			y--;
			break;
		case 2: // 우
			x++;
			break;
		case 3: // 하
			y++;
			break;
		case 4: // 좌
			x--;
			break;
		}
		
		return new int[] {y, x};
	}

	/**
	 * BC에 접속 가능한지 확인하는 함수
	 * @param C BC의 충전 범위
	 * @param BC BC의 위치 y, x
	 * @param y 사용자의 위치 y
	 * @param x 사용자의 위치 x
	 * @return 접속 가능하면 true, 불가능하면 false
	 */
	private static boolean isAccessible(int[] bc, int y, int x) {
		boolean access = false;
		if (bc[2] >= getDistance(bc[1] - 1, bc[0] - 1, y, x)) {
			access = true;
		}
		return access;
	}
	
	private static List<int[]> getAccessibleList(int y, int x) {
		List<int[]> list = new ArrayList<>();

		for (int i = 0; i < A; i++) {
			if (isAccessible(BC[i], y, x)) {
				list.add(BC[i]);
			}
		}
		
		return list;
	}
	
	static int getDistance(int y1, int x1, int y2, int x2) {
		return Math.abs(x1 - x2) + Math.abs(y1 - y2);
	}
	
}
