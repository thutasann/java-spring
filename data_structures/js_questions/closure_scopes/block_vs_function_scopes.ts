/**
 * ## Block Scope vs Function Scope
 * -  Function Scope: When a variable is declared inside a function, it is only accessible within that function and cannot be used outside that function.\
 * -  Block Scope: A variable when declared inside the if or switch conditions or inside for or while loops, are accessible within that particular condition or loop. To be consise the variables declared inside the curly braces are called as within block scope.
 * - var ==> function scope that is if a variable is declared using var keyword it will be accessible throughout the function.
 * - let & const ==> block scope  that is they are accessible within that particular block.
 */
function hello() {
  if (true) {
    var a = 'Javascript';
    let b = 'C++';
    const c = 'Python';
    console.log(a);
    console.log(b);
    console.log(c);
  }
  console.log('Outside if statement');
  console.log(a);
  // console.log(b); ReferenceError: b is not defined
  // console.log(c); ReferenceError: c is not defined
}
hello();

function functionScopeTest() {
  if (true) {
    var functionScoped = "I'm inside a function";
  }
  console.log(functionScoped);
}
functionScopeTest();

function blockScopeTest() {
  if (true) {
    let blockScoped = "I'm inside a block";
    const constScoped = "I'm also inside a block";
    console.log(blockScoped); // ✅ Works
  }
  // console.log(blockScoped); ❌ Error: blockScoped is not defined
}
blockScopeTest();
