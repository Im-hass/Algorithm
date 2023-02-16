import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  static int N; // 카드의 개수
  static int M; // 카드의 합 제한
  static int[] cards; // 카드 목록
  static int[] select; // 선택된 카드 목록
  static boolean[] isSelect; // 선택된 카드인지 체크
  static int max; // M을 넘지 않으면서 M과 최대한 가까운 값

  public static void main(String[] args) throws IOException {

    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(in.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    cards = new int[N];
    select = new int[3];
    isSelect = new boolean[N];
    max = Integer.MIN_VALUE;
    st = new StringTokenizer(in.readLine());
    for (int i = 0; i < N; i++) {
      cards[i] = Integer.parseInt(st.nextToken());
    }

    combination(0, 0);

    System.out.println(max);
  }

  private static void combination(int idx, int start) {
    if (idx == 3) {
      int sum = 0;
      for (int s : select) {
        sum += s;
      }

      if (sum <= M) {
        max = Math.max(max, sum);
      }

      return;
    }

    for (int i = start; i < N; i++) {
      if (isSelect[i]) {
        continue;
      }

      select[idx] = cards[i];
      isSelect[i] = true;
      combination(idx + 1, i + 1);
      isSelect[i] = false;
    }
  }

}
