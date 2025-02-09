const fiboMemo = new Map([
  [0, 0],
  [1, 1],
]);

function fibonacci(num: number): number {
  if (num < 0) return 0;
  if (fiboMemo.has(num)) return fiboMemo.get(num) || 0;
  const result = fibonacci(num - 1) + fibonacci(num - 2);
  fiboMemo.set(num, result);
  return result;
}
console.log(fibonacci(10));
console.log(fibonacci(0));
console.log(fibonacci(1));
