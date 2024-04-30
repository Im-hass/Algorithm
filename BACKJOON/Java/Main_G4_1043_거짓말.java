import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_G4_1043_거짓말 {

  static int[] parent; // 모든 사람의 루트

  public static void main(String[] args) throws IOException {

    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(in.readLine());

    int N = Integer.parseInt(st.nextToken()); // 사람의 수
    int M = Integer.parseInt(st.nextToken()); // 파티의 수

    st = new StringTokenizer(in.readLine());
    int truth = Integer.parseInt(st.nextToken()); // 진실을 아는 사람의 수
    int[] truthRoots = new int[truth]; // 진실을 아는 사람의 루트
    for (int i = 0; i < truth; i++) { // 진실을 아는 사람 입력 받기
      truthRoots[i] = Integer.parseInt(st.nextToken());
    }

    parent = new int[N + 1];
    for (int i = 0; i <= N; i++) {
      parent[i] = i;
    }

    int[] partyRoots = new int[M]; // 각 파티의 루트
    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(in.readLine());
      int cnt = Integer.parseInt(st.nextToken());
      int a = Integer.parseInt(st.nextToken());
      partyRoots[i] = a;
      for (int j = 0; j < cnt - 1; j++) {
        int b = Integer.parseInt(st.nextToken());
        union(a, b);
      }
    }

    int answer = M; // 거짓말할 수 있는 파티의 수
    if (truth == 0) { // 진실을 아는 사람이 0명이라면 그대로 return
      System.out.println(answer);
      return;
    }

    for (int i = 0; i < partyRoots.length; i++) { // union이 끝난 후 각 파티의 루트의 루트 찾기
      partyRoots[i] = find(partyRoots[i]);
    }

    for (int i = 0; i < truthRoots.length; i++) { // union이 끝난 후 진실을 아는 사람의 루트 찾기
      truthRoots[i] = find(truthRoots[i]);
    }

    for (int i = 0; i < partyRoots.length; i++) {
      for (int j = 0; j < truthRoots.length; j++) {
        if (partyRoots[i] == truthRoots[j]) { // 파티의 루트가 진실을 아는 사람의 루트에 있다면, 거짓말할 수 없는 파티
          answer--;
          break;
        }
      }
    }

    System.out.println(answer);

  }

  public static int find(int a) {
    if (parent[a] == a)
      return a;
    return parent[a] = find(parent[a]);
  }

  public static void union(int a, int b) {
    int aRoot = find(a);
    int bRoot = find(b);

    if (aRoot == bRoot)
      return;
    parent[bRoot] = aRoot;
    return;
  }

}
