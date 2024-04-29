import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_G4_16398_행성연결 {

  public static void main(String[] args) throws NumberFormatException, IOException {

    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = null;

    int N = Integer.parseInt(in.readLine());
    int[][] array = new int[N][N];
    int[] minEdge = new int[N];
    boolean[] visited = new boolean[N];
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(in.readLine());
      for (int j = 0; j < N; j++) {
        array[i][j] = Integer.parseInt(st.nextToken());
      }
      minEdge[i] = Integer.MAX_VALUE;
    }

    long answer = 0;
    minEdge[0] = 0;

    for (int i = 0; i < N; i++) {
      int min = Integer.MAX_VALUE;
      int minVertex = 0;

      for (int j = 0; j < N; j++) {
        if (!visited[j] && min > minEdge[j]) {
          min = minEdge[j];
          minVertex = j;
        }
      }

      answer += min;
      visited[minVertex] = true;

      for (int j = 0; j < N; j++) {
        if (!visited[j] && array[minVertex][j] != 0 && minEdge[j] > array[minVertex][j]) {
          minEdge[j] = array[minVertex][j];
        }
      }
    }

    System.out.println(answer);

  }

}
