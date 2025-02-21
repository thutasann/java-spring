const taskA = new Promise((resolve) => setTimeout(() => resolve('A done'), 1000));
const taskB = new Promise((resolve) => setTimeout(() => resolve('B done'), 2000));
const taskC = new Promise((resolve) => setTimeout(() => resolve('C done'), 1500));

Promise.all([taskA, taskB, taskC]).then(console.log);
