import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_5215_임희선 {

  static int N; // 재료의 수
  static int L; // 제한 칼로리
  static int[][] foodInfo; // 음식 정보: [ [점수, 칼로리], [...], ... ]
  static int[][] select; // 고른 음식 정보
  static int maxScore; // 제한 칼로리 이하의 조합 중 가장 맛의 점수가 높은 햄버거 점수

  public static void main(String[] args) throws NumberFormatException, IOException {

    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    StringTokenizer st = null;

    int T = Integer.parseInt(in.readLine()); // 테스트케이스 수
    for (int tc = 1; tc <= T; tc++) {
      sb.append("#").append(tc).append(" ");

      st = new StringTokenizer(in.readLine());
      N = Integer.parseInt(st.nextToken()); // 재료의 수
      L = Integer.parseInt(st.nextToken()); // 제한 칼로리
      foodInfo = new int[N][2];
      select = new int[N][2];
      maxScore = 0;
      for (int i = 0; i < N; i++) {
        st = new StringTokenizer(in.readLine());
        foodInfo[i][0] = Integer.parseInt(st.nextToken()); // 맛에 대한 점수
        foodInfo[i][1] = Integer.parseInt(st.nextToken()); // 칼로리
      }

      for (int i = 1; i <= N; i++) { // 재료 1개 ~ N개까지 조합
        combination(0, 0, i);
      }

      sb.append(maxScore).append("\n");
    }

    System.out.println(sb);

  }

  private static void combination(int idx, int start, int n) { // n: 선택하는 재료 개수
    if (idx == n) {
      int score = 0;
      int kal = 0;
      for (int s[] : select) { // 고른 재료들의 맛점수와 칼로리 총합 계산
        if (s[0] == 0) { // 고르지 않았다면 반복문 종료
          break;
        }
        score += s[0];
        kal += s[1];
      }

      if (kal <= L) { // 칼로리의 합계가 정해진 칼로리 이하일 경우
        maxScore = Math.max(maxScore, score); // 가장 맛 점수가 높은 햄버거 점수 저장
      }

      return;
    }

    for (int i = start; i < N; i++) {
      select[idx][0] = foodInfo[i][0];
      select[idx][1] = foodInfo[i][1];
      combination(idx + 1, i + 1, n);
    }

  }

}