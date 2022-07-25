function solution(s, n) {
  let answer = '';
  s.split('').map(v => {
      if (v === ' ') { // 공백일 경우
          answer += ' ';
      } else {
          let code = v.charCodeAt(0); // 해당 문자의 아스키코드
          let sum = code + n;
          if (code >= 65 && code <= 90 && sum > 90 || code >= 97 && code <= 122 && sum > 122) { // (대문자 && 합이 90을 넘는 경우) OR (소문자 && 합이 122를 넘는 경우)
              sum -= 26; // 다시 앞쪽 알파벳으로 돌아감
          }
          answer += String.fromCharCode(sum);
      }
  });
  return answer;
}

// //////////////다른 사람의 풀이
// function solution(s, n) {
//   var upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
//   var lower = "abcdefghijklmnopqrstuvwxyz";
//   var answer= '';

//   for(var i =0; i <s.length; i++){
//       var text = s[i];
//       if(text == ' ') {
//           answer += ' '; 
//           continue;
//       }
//       var textArr = upper.includes(text) ? upper : lower;
//       var index = textArr.indexOf(text)+n;
//       if(index >= textArr.length) index -= textArr.length;
//       answer += textArr[index];
//   }
//   return answer;
// }
// //////////////다른 사람의 풀이