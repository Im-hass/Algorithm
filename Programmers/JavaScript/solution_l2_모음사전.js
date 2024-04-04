function solution(word) {
  const answer = [];
  const str = "";
  for (let i = 1; i <= 5; i++) permutation(str, i, answer);
  return answer.sort().indexOf(word) + 1;
}

function permutation(word, length, answer) {
  const vowels = [..."AEIOU"];
  if (length === word.length) {
    answer.push(word);
    return;
  }
  vowels.forEach((vowel) => {
    permutation(word + vowel, length, answer);
  });
};