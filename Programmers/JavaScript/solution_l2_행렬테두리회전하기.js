function solution(rows, columns, queries) {
  let answer = [];
  
  let arr = []; // 주어진 행렬
  let num = 1; // 행렬에 들어갈 숫자값
  for (let i = 0; i < rows; i++) { // 행렬 초기화
      let tmp = [];
      for (let j = 0; j < columns; j++) {
          tmp.push(num++);
      }
      arr.push(tmp);
  }

  for (let query of queries) {
      let [y1, x1, y2, x2] = query; // 회전할 좌표
      x1--;
      y1--;
      x2--;
      y2--;
      let list = []; // 회전할 값
      
      // 회전
      for (let x = x1; x <= x2; x++) {
          list.push(arr[y1][x]);
      }
      for (let y = y1 + 1; y <= y2; y++) {
          list.push(arr[y][x2]);
      }
      for (let x = x2 - 1; x >= x1; x--) {
          list.push(arr[y2][x]);
      }
      for (let y = y2 - 1; y > y1; y--) {
          list.push(arr[y][x1]);
      }
      
      answer.push([...list].sort((x, y) => x - y)[0]);
      arr[y1][x1] = list.pop();
      
      for (let x = x1 + 1; x <= x2; x++) {
          arr[y1][x] = list.shift();
      }
      for (let y = y1 + 1; y <= y2; y++) {
          arr[y][x2] = list.shift();
      }
      for (let x = x2 - 1; x >= x1; x--) {
          arr[y2][x] = list.shift();
      }
      for (let y = y2 - 1; y > y1; y--) {
          arr[y][x1] = list.shift();
      }
  }
  
  return answer;
}