type Throttle = (...args: any[]) => void;

/**
 * Throttle Function Execution
 * - The `throttle` function limits how often a function can run.
 * - if a function is called repeatedly within the interval, only the first call in that period is executed.
 */
function throttle<T extends Throttle>(func: T, limit: number): T {
  let lastCall = 0;

  return function (...args: Parameters<T>) {
    const now = Date.now();
    if (now - lastCall >= limit) {
      lastCall = now;
      func(...args);
    }
  } as T;
}

const log = throttle(() => console.log('Throttled Call'), 1000);
setInterval(log, 100);
