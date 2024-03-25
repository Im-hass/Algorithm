function solution(n, t, m, p) {
  let answer = '';
  let temp = '';
  let num = 0;
  
  for (let i = 0; i < t;) {
      temp += num.toString(n);
      if (num % m == 0) {
          i++;
      }
      num++;
  }
  
  let cnt = 0;
  for (let i = 0; i < temp.length; i++) {
      if (cnt == t) break;
      if (i % m + 1 == p) {
          answer += temp[i];
          cnt++;
      }
  }
  
  return answer.toUpperCase();
}