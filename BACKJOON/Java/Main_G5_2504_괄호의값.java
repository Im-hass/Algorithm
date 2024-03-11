import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

// G5_2504 괄호의 값
public class _0311_G5_2504_괄호의값 {

  public static void main(String[] args) throws IOException {

    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    char[] chars = in.readLine().toCharArray();

    int sum = 0;
    Stack<Character> s = new Stack<>(); // 괄호를 누적할 스택
    Stack<Integer> value = new Stack<>(); // 곱할 값을 누적할 스택
    for (int i = 0; i < chars.length; i++) {
      if (s.isEmpty()) {
        s.add(chars[i]);
        if (chars[i] == '(')
          value.add(2); // '('로 시작하면 2를 누적
        else if (chars[i] == '[')
          value.add(3); // '['로 시작하면 3을 누적
        else
          break; // ')'나 ']'일 경우 반복문 종료(올바른 괄호열이 아님)

        continue;
      }

      if (chars[i] == ')' || chars[i] == ']') {
        if (!(chars[i - 1] == ')' || chars[i - 1] == ']')) {
          // 분배법칙을 활용하여 미리 곱하고 sum에 누적
          int temp = 1;
          for (int v : value) {
            temp *= v;
          }
          sum += temp;
        }

        if (s.peek() == '(' && chars[i] == ')') {
          s.pop();
          value.pop();
        } else if (s.peek() == '[' && chars[i] == ']') {
          s.pop();
          value.pop();
        }
      } else {
        s.add(chars[i]);
        if (chars[i] == '(')
          value.add(2); // '('로 시작하면 2를 누적
        else if (chars[i] == '[')
          value.add(3); // '['로 시작하면 3을 누적
      }
    }

    if (!s.isEmpty()) {
      System.out.println(0);
      return;
    }

    System.out.println(sum);

  }

}