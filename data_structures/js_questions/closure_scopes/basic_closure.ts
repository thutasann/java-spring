/**
 * A Closure is a function that remembers the variables
 * from its lexical scope even when executed outside that scope.
 * - The `count` variabled is enclosed in the inner function.
 * - Even after createCounter has finished executing, the returned function retians access to count
 */
function createCounter(): () => number {
  let counter = 0;

  return function () {
    return counter++;
  };
}

const counter = createCounter();
console.log('counter()', counter());
console.log('counter()', counter());
console.log('counter()', counter());
