/**
 * - The synchronous console.log("Start") executes first.
 * - The Promise executor function runs immediately, so "Inside Promise" is logged next.
 * - The promise.then() callback is added to the microtask queue.
 * - "End" is logged next (since JS doesn’t wait for then).
 * - The microtask queue is then processed, logging "Resolved Value".
 */

console.log('Start');

const promise = new Promise((resolve) => {
  console.log('Inside Promise');
  resolve('Resolved value');
});

promise.then((value) => console.log(value));

console.log('End');
