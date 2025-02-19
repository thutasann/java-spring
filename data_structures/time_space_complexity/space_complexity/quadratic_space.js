/**
 * Quadratic Space - O(n²)
 * @description
 * - Nested structures increase memory usage.
 * @param {number} n
 */
function matrix(n) {
  let arr = new Array(n).fill().map(() => new Array(n).fill(0));
  return arr;
}
console.log(matrix(3));
