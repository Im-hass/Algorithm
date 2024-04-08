// 이진 트리라고 한적 없음
// 0이 루트가 아닐 수 있음
// 루트가 삭제될 경우 0을 반환해야 함
const filePath = process.platform === 'linux' ? '/dev/stdin' : process.cwd() + '/input/G5_1068_트리.txt';
const [N, str, deleteNode] = require('fs').readFileSync(filePath).toString().trim().split('\n');

console.log(solution(N, str.split(' ').map(v => parseInt(v)), parseInt(deleteNode)));

function solution(N, nodes, deleteNode) {
  const list = {};
  for (let i = 0; i < N; i++) {
    list[i] = new Array();
  }
  
  let num = 0;
  let root = 0;
  for (let i = 0; i < nodes.length; i++) { // 자식 넣기
    if (nodes[i] === -1) { // 루트 저장
      root = num++;
      continue;
    }
    if (num === deleteNode) { // 자식 deleteNode 스킵
      num++;
      continue;
    }
    list[nodes[i]].push(num++);
  }

  delete list[deleteNode]; // 부모 deleteNode 제거

  if (root === deleteNode) return 0;

  let cnt = 0;
  dfs(root);

  function dfs(idx) {
    if (!list[idx]) return;
    if (list[idx].length === 0) {
      cnt++;
      return;
    }

    for (let i = 0; i < list[idx].length; i++) {
      dfs(list[idx][i]);
    }
  }

  return cnt;
}



///////////////////////////

// const filePath = process.platform === 'linux' ? '/dev/stdin' : process.cwd() + '/input/G5_1068_트리.txt';
// const [N, str, deleteNode] = require('fs').readFileSync(filePath).toString().trim().split('\n');

// console.log(solution(N, str.split(' ').map(v => parseInt(v)), parseInt(deleteNode)));

// function solution(N, nodes, deleteNode) {
//   if (deleteNode === 0) return 0;

//   const tree = {};
//   for (let i = 0; i < N; i++) {
//     tree[i] = new Array(2);
//   }

//   let num = 1;
//   for (let i = 0; i < nodes.length; i++) {
//     if (i === deleteNode) {
//       num++;
//       continue;
//     }
//     if (nodes[i] === -1) continue;
//     if (!tree[nodes[i]][0]) tree[nodes[i]][0] = num++;
//     else tree[nodes[i]][1] = num++;
//   }

//   let cnt = 0;
//   dfs(0);

//   function dfs(idx) {
//     if (!tree[idx]) return;
//     if (!tree[idx][0] && !tree[idx][1]) {
//       cnt++;
//       return;
//     }

//     dfs(tree[idx][0]);
//     dfs(tree[idx][1]);
//   }

//   return cnt;
// }

