function main(n) {
  const arr = new Array(n);

  for (let i = 1; i <= n; i++) {
    arr[i] = i;
  }
  
  // 간선 연결
  union(arr, 1, 2);
  union(arr, 2, 3);
  union(arr, 4, 6);
  union(arr, 6, 5);
  union(arr, 7, 8);

  console.log(arr); // [1, 1, 1, 4, 4, 4, 7, 7]

  console.log(isSameParent(arr, 1, 2)); // true
  console.log(isSameParent(arr, 1, 3)); // true
  console.log(isSameParent(arr, 3, 5)); // false
  console.log(isSameParent(arr, 4, 5)); // true
  console.log(isSameParent(arr, 6, 8)); // false
}

// 최상위 부모 노드를 찾는 재귀 함수
function find(arr, n) {
  if (arr[n] === n) return n;

  return (arr[n] = find(arr, arr[n]));
}

// 두 개의 노드를 같은 부모 노드로 병합하는 함수
function union(arr, a, b) {
  a = find(arr, a);
  b = find(arr, b);

  // 두 노드 중 부모 노드 값이 더 작은 값으로 합친다
  if (a < b) arr[b] = a;
  else arr[a] = b;
}

// 2개의 노드가 같은 부모 노드를 가졌는지 확인하는 함수
function isSameParent(arr, a, b) {
  a = find(arr, a);
  b = find(arr, b);

  if (a === b) return true;
  else return false;
}

main(8);