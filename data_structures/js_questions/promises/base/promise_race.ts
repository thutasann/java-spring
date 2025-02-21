const task_a = new Promise((resolve) => setTimeout(() => resolve('A done'), 1000));
const task_b = new Promise((resolve) => setTimeout(() => resolve('B done'), 2000));
const task_c = new Promise((resolve) => setTimeout(() => resolve('C done'), 1500));

Promise.race([task_a, task_b, task_c]).then(console.log);
