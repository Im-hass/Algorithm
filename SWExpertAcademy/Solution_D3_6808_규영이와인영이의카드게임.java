import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_6808_임희선 {

  static final int R = 9; // 카드 개수
  static int[] gu; // 규영이가 가진 카드
  static int[] young; // 인영이가 가진 카드
  static boolean[] isGu; // 규영이가 가진 카드인지
  static int guWinCnt; // 규영이가 이기는 횟수
  static final int GAME_COUNT = 9 * 8 * 7 * 6 * 5 * 4 * 3 * 2 * 1; // 총 게임 횟수

  public static void main(String[] args) throws NumberFormatException, IOException {

    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    StringTokenizer st = null;

    int T = Integer.parseInt(in.readLine()); // 테스트 케이스 수
    for (int tc = 1; tc <= T; tc++) {
      sb.append("#").append(tc).append(" ");

      gu = new int[9];
      young = new int[9];
      isGu = new boolean[19];
      guWinCnt = 0;

      st = new StringTokenizer(in.readLine());
      for (int i = 0; i < 9; i++) {
        int temp = Integer.parseInt(st.nextToken());
        gu[i] = temp; // 규영이의 카드
        isGu[temp] = true; // 규영이의 카드 체크
      }

      permutaion(0);

      sb.append(guWinCnt).append(" ").append(GAME_COUNT - guWinCnt).append("\n");
    }

    System.out.println(sb);

  }

  private static void permutaion(int idx) { // 인영이가 카드를 내는 경우의 수 => 순열
    if (idx == R) {
      int guTotal = 0;
      int youngTotal = 0;
      for (int i = 0; i < R; i++) {
        if (gu[i] > young[i]) { // 규영이가 낸 카드가 인영이가 낸 카드 보다 클 경우 => 규영이 승
          guTotal += (gu[i] + young[i]); // 두 카드에 적힌 수의 합만큼 점수 획득
        } else { // 인영이가 낸 카드가 규영이가 낸 카드 보다 클 경우 => 인영이 승
          youngTotal += (gu[i] + young[i]); // 두 카드에 적힌 수의 합만큼 점수 획득
        }
      }

      if (guTotal > youngTotal) { // 규영이의 점수가 더 크다면
        guWinCnt++; // 규영이 승리
      }

      return;
    }

    for (int i = 1; i <= R * 2; i++) { // 1~18까지의 숫자
      if (isGu[i])
        continue; // 규영이 카드거나, 선택된 숫자라면 패스

      young[idx] = i;
      isGu[i] = true;
      permutaion(idx + 1);
      isGu[i] = false;
    }

  }

}