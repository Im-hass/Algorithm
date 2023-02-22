package com.ssafy._0222.task;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//D3_1873_상호의배틀필드
public class Solution_D3_1873_상호의배틀필드 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(in.readLine()); // 테스트 케이스
		
		for (int tc = 0; tc < T; tc++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			int H = Integer.parseInt(st.nextToken()); // 맵의 높이
			int W = Integer.parseInt(st.nextToken()); // 맵의 너비
			String[][] map = new String[H][W]; // 맵
			int[] car = new int[3]; // 전차의 현재 위치(x, y)와 방향(1위, 2아래, 3좌, 4우)
			
			for (int y = 0; y < H; y++) {
				st = new StringTokenizer(in.readLine());
				String[] str = st.nextToken().split(""); // 맵 한 줄
				for (int x = 0; x < W; x++) {
					map[y][x] = str[x];
					switch (str[x]) {
					case "^":
						car[0] = x;
						car[1] = y;
						car[2] = 1;
						break;
					case "v":
						car[0] = x;
						car[1] = y;
						car[2] = 2;
						break;
					case "<":
						car[0] = x;
						car[1] = y;
						car[2] = 3;
						break;
					case ">":
						car[0] = x;
						car[1] = y;
						car[2] = 4;
						break;
					}
				}
			}
			
			int N = Integer.parseInt(in.readLine()); // 명령어 길이
			String[] work = new String[N]; // 명령어 배열
			work = in.readLine().split("");
			
			for (int i = 0; i < work.length; i++) {
				int nx;
				int ny;
				
				switch (work[i]) {
				case "U": // 전차 방향을 위로, 평지라면 한 칸 위로 이동
					map[car[1]][car[0]] = "^"; // 전차 방향 표시 위로 바꾸기
					car[2] = 1; // 전차 방향값 위로 바꾸기
					nx = car[0];
					ny = car[1] - 1;
					
					if (nx > -1 && ny > -1 && nx < W && ny < H && map[ny][nx].equals(".")) { // 맵 내부일 경우
						map[car[1]][car[0]] = "."; // 전차가 있던 자리는 평지로 변경
						map[ny][nx] = "^"; // 전차가 이동한 자리에 전차 표시
						car[0] = nx; // 전차가 이동한 x위치
						car[1] = ny; // 전차가 이동한 y위치
					}
					break;
				case "D": // 전차 방향 아래로, 평지라면 아래로 이동 
					map[car[1]][car[0]] = "v"; // 전차 방향 표시 아래로 바꾸기
					car[2] = 2; // 전차 방향값 위로 바꾸기
					nx = car[0];
					ny = car[1] + 1;
					
					if (nx > -1 && ny > -1 && nx < W && ny < H && map[ny][nx].equals(".")) { // 맵 내부일 경우
						map[car[1]][car[0]] = "."; // 전차가 있던 자리는 평지로 변경
						map[ny][nx] = "v"; // 전차가 이동한 자리에 전차 표시
						car[0] = nx; // 전차가 이동한 x위치
						car[1] = ny; // 전차가 이동한 y위치
					}
					break;
				case "L": // 전차 방향 왼쪽으로, 평지라면 왼쪽으로 이동
					map[car[1]][car[0]] = "<"; // 전차 방향 표시 왼쪽으로 바꾸기
					car[2] = 3; // 전차 방향값 왼쪽으로 바꾸기
					nx = car[0] - 1;
					ny = car[1];
					
					if (nx > -1 && ny > -1 && nx < W && ny < H && map[ny][nx].equals(".")) { // 맵 내부일 경우
						map[car[1]][car[0]] = "."; // 전차가 있던 자리는 평지로 변경
						map[ny][nx] = "<"; // 전차가 이동한 자리에 전차 표시
						car[0] = nx; // 전차가 이동한 x위치
						car[1] = ny; // 전차가 이동한 y위치
					}
					break;
				case "R": // 전차 방향 오른쪽으로, 평지라면 오른쪽으로 이동
					map[car[1]][car[0]] = ">"; // 전차 방향 표시 오른쪽으로 바꾸기
					car[2] = 4; // 전차 방향값 오른쪽으로 바꾸기
					nx = car[0] + 1;
					ny = car[1];
					
					if (nx > -1 && ny > -1 && nx < W && ny < H && map[ny][nx].equals(".")) { // 맵 내부일 경우
						map[car[1]][car[0]] = "."; // 전차가 있던 자리는 평지로 변경
						map[ny][nx] = ">"; // 전차가 이동한 자리에 전차 표시
						car[0] = nx; // 전차가 이동한 x위치
						car[1] = ny; // 전차가 이동한 y위치
					}
					break;
				case "S": // 전차가 바라보는 방향으로 포탄 발사
					switch (car[2]) {
					case 1: // 바라보는 방향이 위일 경우
						nx = car[0];
						ny = car[1] - 1;
						
						if (nx > -1 && ny > -1 && nx < W && ny < H) { // 맵 내부일 경우
							for (int y = ny; y > -1; y--) { // x는 그대로 y는 -1씩 감소 = 포탄의 경로
								if (map[y][nx].equals("#")) { // 포탄 소멸
									break;
								} else if (map[y][nx].equals("*")) { // 벽 파괴
									map[y][nx] = "."; // 부숴짐
									break;
								}
							}
						}
						break;
					case 2: // 바라보는 방향이 아래일 경우
						nx = car[0];
						ny = car[1] + 1;
						
						if (nx > -1 && ny > -1 && nx < W && ny < H) { // 맵 내부일 경우
							for (int y = car[1]; y < H; y++) { // x는 그대로 y는 +1씩 증가 = 포탄의 경로
								if (map[y][nx].equals("#")) { // 포탄 소멸
									break;
								} else if (map[y][nx].equals("*")) { // 벽 파괴
									map[y][nx] = "."; // 부숴짐
									break;
								}
							}
						}
						break;
					case 3: // 바라보는 방향이 왼쪽일 경우
						nx = car[0] - 1;
						ny = car[1];
						
						if (nx > -1 && ny > -1 && nx < W && ny < H) { // 맵 내부일 경우
							for (int x = nx; x > -1; x--) { // y는 그대로 x는 -1씩 감소 = 포탄의 경로
								if (map[ny][x].equals("#")) { // 포탄 소멸
									break;
								} else if (map[ny][x].equals("*")) { // 벽 파괴
									map[ny][x] = "."; // 부숴짐
									break;
								}
							}
						}
						break;
					case 4: // 바라보는 방향이 오른쪽일 경우
						nx = car[0] + 1;
						ny = car[1];
						
						if (nx > -1 && ny > -1 && nx < W && ny < H) { // 맵 내부일 경우
							for (int x = car[0]; x < W; x++) { // y는 그대로 x는 +1씩 증가 = 포탄의 경로
								if (map[ny][x].equals("#")) { // 포탄 소멸
									break;
								} else if (map[ny][x].equals("*")) { // 벽 파괴
									map[ny][x] = "."; // 부숴짐
									break;
								}
							}
						}
						break;
					}
					break;
				} 
			}
			
			sb.append("#" + (tc + 1) + " ");
			
			for (int i = 0; i < H; i++) {
				sb.append(String.join("", map[i])).append("\n");
			}
		}
		
		System.out.println(sb); // 모든 입력을 처리하고 나면 게임 맵의 상태
	}
}
