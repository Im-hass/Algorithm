const filepath = process.platform === 'linux' ? '/dev/stdin' : process.cwd() + '/BACKJOON/JavaScript/input/B5_11654_아스키코드.txt';
const input = require('fs').readFileSync(filepath).toString().trim();

console.log(solution(input));

function solution(c) {
  return c.charCodeAt();
}