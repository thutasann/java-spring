/**
 * Linear Space - O(n)
 * @description
 * - Uses memoy proportional to input size.
 * @param {number} n
 */
function storeNumbers(n) {
  /** @type { number[] } */
  const arr = [];

  for (let i = 0; i < n; i++) {
    arr.push(i);
  }

  return arr;
}
