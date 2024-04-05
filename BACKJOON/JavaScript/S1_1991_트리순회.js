const filePath = process.platform === 'linux' ? '/dev/stdin' : process.cwd() + '/input/S1_1991_트리순회.txt';
const [N, ...arr] = require('fs').readFileSync(filePath).toString().trim().split('\n');

console.log(solution(N, arr.map(v => v.trim().split(' '))));

function solution(N, arr) {
  let str = '';
  const tree = {};
  for (let i = 0; i < N; i++) {
    const [node, left, right] = arr[i];
    tree[node] = [left, right];
  }

  function preorder(node) { // 전위 순회
    if (node === '.') return;
  
    const [left, right] = tree[node];
    str += node;
    preorder(left);
    preorder(right);
  }
  
  function inorder(node) { // 중위 순회
    if (node === '.') return;
  
    const [left, right] = tree[node];
    inorder(left);
    str += node;
    inorder(right);
  }

  function postorder(node) { // 후위 순회
    if (node === '.') return;
  
    const [left, right] = tree[node];
    postorder(left);
    postorder(right);
    str += node;
  }

  preorder('A');
  str += '\n';
  inorder('A');
  str += '\n';
  postorder('A');

  return str;
}
