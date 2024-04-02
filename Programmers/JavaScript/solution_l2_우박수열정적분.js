// k: 우박수의 초항
// ranges: 정적분을 구하는 구간들의 목록
// 정적분의 넓이 = 사다리꼴의 넓이 = ((윗변 + 아랫변) * 높이) / 2
function solution(k, ranges) {
  let answer = [];
  let graph = [];
  
  let temp = k;
  graph.push(temp);
  
  while (temp > 1) {
      if (temp % 2 == 0) temp /= 2;
      else temp = temp * 3 + 1;
      graph.push(temp);
  }
  
  let n = graph.length; // k가 초항인 우박수열이 1이 될때 까지의 횟수
  for (let range of ranges) {
      let a = range[0];
      let b = n + range[1];
      
      if (a >= b) { // 주어진 구간의 시작점이 끝점보다 커서 유효하지 않은 구간이 주어질 수 있음
          answer.push(-1);
          continue;
      }
      
      let sum = 0;
      for (let i = a + 1; i < b; i++) {
          sum += (graph[i - 1] + graph[i]) / 2 // 정적분의 넓이
      }
      answer.push(sum);
  }
  
  return answer;
}