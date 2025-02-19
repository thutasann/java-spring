/**
 * Linear Time - O(n)
 * @description
 * - Time grows proportionally with input size
 * @param {number[]} arr
 */
function printAll(arr) {
  for (let i = 0; i < arr.length; i++) {
    console.log('arr --> ', arr[i]);
  }
}
printAll([1, 2, 3]);
