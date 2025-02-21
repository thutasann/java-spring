async function slowTask1() {
  await new Promise((res) => setTimeout(res, 2000));
  return 'Task 1 done';
}

async function slowTask2() {
  await new Promise((res) => setTimeout(res, 3000));
  return 'Task 2 done';
}

async function main() {
  const t1 = await slowTask1();
  const t2 = await slowTask2();
  console.log(t1, t2);
}

async function main_2() {
  await new Promise((res) => setTimeout(res, 100));
  console.log('main 2');
}

async function main_3() {
  const [t1, t2] = await Promise.all([slowTask1(), slowTask2()]);
  console.log(t1, t2);
}

main();
main_2();
main_3();
