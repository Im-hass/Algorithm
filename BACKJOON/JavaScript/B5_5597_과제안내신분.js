const filePath = process.platform === 'linux' ? '/dev/stdin' : process.cwd() + '/BACKJOON/JavaScript/input/B5_5597_과제안내신분.txt';
const [...arr] = require('fs').readFileSync(filePath).toString().trim().split('\n');

console.log(solution(arr));

function solution(arr) {
  let ans = [];

  let submitArr = new Array(31);
  submitArr.fill(0);
  
  submitArr[0] = 1;
  for (let i = 0; i < arr.length; i++) {
    let idx = Number(arr[i]);
    submitArr[idx] = 1;
  }
  
  for (let i = 0; i < submitArr.length; i++) {
    if (submitArr[i] !== 1) {
      ans.push(i);
    }
  }

  return ans.join('\n');
}

// includes()나 map의 has() 메서드를 이용해 풀기도 함.