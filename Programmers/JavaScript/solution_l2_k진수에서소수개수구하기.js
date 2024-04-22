function solution(n, k) {
  let answer = 0;

  // console.log(n.toString(3)); // 10진수 -> 3진수
  // console.log(parseInt(n.toString(3), 3)); // 3진수 -> 10진수

  const num = n.toString(k);
  let temp = '';
  for (let i = 0; i < num.length; i++) {
    if (num[i] === '0') {
      if (isPrime(+temp)) {
        answer++;
      }
      temp = '';
    } else {
      temp += num[i];
    }
  }

  if (isPrime(+temp)) {
    answer++;
  }

  return answer;
}

function isPrime(num) {
  if (num === 0 || num === 1) return false;
  if (num === 2) return true;

  for (let i = 2; i <= Math.floor(Math.sqrt(num)); i++) {
    if (num % i === 0) return false;
  }

  return true;
}
