const filePath =
  process.platform === 'linux' ? '/dev/stdin' : process.cwd() + '/input/G5_1916_최소비용구하기.txt';
const [N, M, ...arr] = require('fs').readFileSync(filePath).toString().trim().split('\n');

class PriorityQueue {
  constructor() {
    this.heap = [];
  }

  push(element) {
    this.heap.push(element);
    this.bubbleUp();
  }

  pop() {
    const min = this.heap[0];
    const last = this.heap.pop();
    if (this.heap.length > 0) {
      this.heap[0] = last;
      this.sinkDown(0);
    }
    return min;
  }

  bubbleUp() {
    let index = this.heap.length - 1;
    while (index > 0) {
      const element = this.heap[index];
      const parentIndex = Math.floor((index - 1) / 2);
      const parent = this.heap[parentIndex];
      if (parent[1] <= element[1]) break;
      this.heap[index] = parent;
      this.heap[parentIndex] = element;
      index = parentIndex;
    }
  }

  sinkDown(index) {
    const leftChildIndex = 2 * index + 1;
    const rightChildIndex = 2 * index + 2;
    let smallest = index;
    const length = this.heap.length;

    if (leftChildIndex < length && this.heap[leftChildIndex][1] < this.heap[smallest][1]) {
      smallest = leftChildIndex;
    }

    if (rightChildIndex < length && this.heap[rightChildIndex][1] < this.heap[smallest][1]) {
      smallest = rightChildIndex;
    }

    if (smallest !== index) {
      [this.heap[index], this.heap[smallest]] = [this.heap[smallest], this.heap[index]];
      this.sinkDown(smallest);
    }
  }

  size() {
    return this.heap.length;
  }
}

console.log(
  solution(
    parseInt(N), // 정점 개수
    parseInt(M), // 간선 개수
    arr
      .pop()
      .split(' ')
      .map((v) => parseInt(v)), // 최단 거리를 구할 [출발, 도착] 정점
    arr.map((v) => v.split(' ').map((val) => parseInt(val))) // 버스 정보
  )
);

function solution(N, M, SE, edges) {
  const [S, E] = SE;
  const INF = Number.MAX_VALUE;

  const dist = new Array(N + 1).fill(INF);
  dist[S] = 0;

  const graph = Array.from({ length: N + 1 }, () => []);
  for (const [from, to, cost] of edges) {
    graph[from].push({ to, cost });
  }

  const pq = new PriorityQueue();
  pq.push([S, 0]);
  while (pq.size() > 0) {
    const [node, cost] = pq.pop();

    if (dist[node] < cost) continue;

    for (const { to, cost: nextCost } of graph[node]) {
      if (dist[to] > cost + nextCost) {
        dist[to] = cost + nextCost;
        pq.push([to, dist[to]]);
      }
    }
  }

  return dist[E];
}

//////////////////////////////

// 우선순위 큐 정렬 처리 시(O(n log n)) 메모리 초과가 발생할 수 있음 => 힙 사용하여 정렬 시(O(log n))
// const filePath = process.platform === 'linux' ? '/dev/stdin' : process.cwd() + '/input/G5_1916_최소비용구하기.txt';
// const [N, M, ...arr] = require('fs').readFileSync(filePath).toString().trim().split('\n');

// console.log(
//   solution(
//     parseInt(N), // 정점 개수
//     parseInt(M), // 간선 개수
//     arr.pop().split(' ').map(v => parseInt(v)), // 최단 거리를 구할 [출발, 도착] 정점
//     arr.map(v => v.split(' ').map(val => parseInt(val))) // 버스 정보
//   )
// );

// function dijkstra(N, M, SE, edges) {
//   const [S, E] = SE;
//   const INF = Number.MAX_VALUE;

//   const dist = new Array(N + 1).fill(INF);
//   dist[S] = 0;

//   const graph = Array.from({ length: N + 1 }, () => []);
//   for (const [from, to, cost] of edges) {
//     graph[from].push({ to, cost });
//   }

//   const pq = [{ node: S, cost: 0 }];
//   while (pq.length) {
//     pq.sort((a, b) => a.cost - b.cost);
//     const { node, cost } = pq.shift();

//     if (dist[node] < cost) continue;

//     for (const { to, cost: nextCost } of graph[node]) {
//       if (dist[to] > cost + nextCost) {
//         dist[to] = cost + nextCost;
//         pq.push({ node: to, cost: dist[to] });
//       }
//     }
//   }

//   return dist[E];
// }

// function solution(N, M, SE, edges) {
//   return dijkstra(N, M, SE, edges);
// }
