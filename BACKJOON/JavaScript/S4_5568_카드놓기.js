const filepath = process.platform === 'linux' ? '/dev/stdin' : process.cwd() + '/input/S4_5568_카드놓기.txt';
const [N, K, ...arr] = require('fs').readFileSync(filepath).toString().trim().split('\n').map(v => parseInt(v));

console.log(solution(N, K, arr));

/**
 * n장의 카드에 적힌 숫자가 주어졌을 때, 그 중에서 k개를 선택해서 만들 수 있는 정수의 개수를 반환
 * @param N 전체 카드 개수
 * @param K 뽑은 카드 개수
 * @param arr 뽑은 카드
 * @returns 만들 수 있는 정수의 개수
 */
function solution(N, K, arr) {
  const visited = Array(N).fill(false);
  const answer = new Set();

  dfs(K, arr, visited, answer, "", 0);

  return answer.size;
}

function dfs(K, arr, visited, answer, str, cnt) {
  if (cnt === K) {
    answer.add(str);
    return;
  }

  for (let i = 0; i < arr.length; i++) {
    if (visited[i]) continue;

    visited[i] = true;
    dfs(K, arr, visited, answer, str + arr[i], cnt + 1);
    visited[i] = false;
  }
}

// 중복순열 기본 코드
// const arr = ['a', 'b', 'c'];
// const temp = [];
// permutation([], arr, temp);

// function permutation(permu, rests, temp) {
//     if (rests.length === 0) {
//       return temp.push(permu);
//     }

//     rests.forEach((v, idx) => {
//       const rest = [...rests.slice(0, idx), ...rests.slice(idx + 1)];
//       permutation([...permu, v], rest, temp);
//     });
// }

