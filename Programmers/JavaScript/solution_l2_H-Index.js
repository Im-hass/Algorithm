function solution(citations) {
  // citations : 과학자가 발표한 논문의 인용 횟수
  // citations.lenght : 과학자가 발표한 논문의 개수
  // h번 이상 인용된 논문이 h편 이상이고 나머지 논문이 h번 이하 인용되었다면 h의 최댓값이 H-Index

  citations.sort((a, b) => b - a); // 내림차순 정렬
  
  let hIdx = 0; // h번 이상 인용된 논문의 개수
  for (let i = 0; i < citations.length; i++) { // i = h번 이하 인용된 논문의 개수
      if(citations[i] > i) hIdx++; // 인용수가 논문수 보다 클 경우
      else break;
  }
  
  return hIdx;
}