const filePath =
  process.platform === 'linux'
    ? '/dev/stdin'
    : process.cwd() + '/input/S2_11053_가장긴증가하는부분수열.txt';
const [N, str] = require('fs').readFileSync(filePath).toString().trim().split('\n');

console.log(
  solution(
    +N,
    str.split(' ').map((v) => +v)
  )
);

function solution(N, A) {
  let answer = 1;
  const dp = new Array(N); // 증가 부분 수열의 길이값 저장
  dp.fill(1); // 최소 길이는 1로 전부 초기화

  // A[1]이 A[0]보다 크면 dp[1] = dp[0] + 1
  // A[1]이 A[0]보다 작으면 dp[1] 그대로
  // A[1]이 A[0]과 같으면 dp[1] 그대로
  // A[2]가 A[0]보다 크면 dp[2] = dp[0] + 1
  // A[2]가 A[1]보다 크면 dp[2] = dp[1] + 1
  // ...
  for (let i = 0; i < A.length; i++) {
    for (let j = 0; j < i; j++) {
      if (A[i] > A[j]) dp[i] = Math.max(dp[i], dp[j] + 1);
      answer = Math.max(answer, dp[i]);
    }
  }

  return answer;
}
