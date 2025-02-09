/**
 * Issue: Closure Capturing Loop Variable
 * - `var` is function-scoped, so all callbacks share the same `i`
 * - when `setTimeout` executes, `i` is already 4
 */
function delayedLog() {
  for (var i = 0; i <= 3; i++) {
    setTimeout(() => {
      console.log(i);
    }, i * 1000);
  }
}
delayedLog();

/**
 * Fix: use `let`
 * - `let` is block-scoped, createing a new `i` for each loop iteration
 */
function delayedLogFixed() {
  for (let i = 1; i <= 3; i++) {
    setTimeout(() => {
      console.log(i);
    }, i * 1000);
  }
}
delayedLogFixed();
