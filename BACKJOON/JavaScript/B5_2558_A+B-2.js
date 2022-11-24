const filepath = process.platform === 'linux' ? '/dev/stdin' : process.cwd() + '/BACKJOON/JavaScript/input/B5_2558_A+B-2.txt';
const input = require('fs').readFileSync(filepath).toString().trim().split('\n');

console.log(solution(parseInt(input[0]), parseInt(input[1])));

function solution(A, B) {
  return (A + B);
}