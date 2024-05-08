import java.util.List;
import java.util.ArrayList;

class Solution {
  public int[] solution(int[] prices) {
    List<Integer> list = new ArrayList<>();
    for (int i = 0; i < prices.length - 1; i++) {
      int time = 0;
      for (int j = i + 1; j < prices.length; j++) {
        time++;
        if (prices[i] > prices[j]) {
          break;
        }
      }
      list.add(time);
    }

    list.add(0);

    return list.stream().mapToInt(i -> i).toArray();
  }
}