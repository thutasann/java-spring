import { PQueue, Task } from '.';

function got(url: string): Promise<string> {
  return new Promise((resolve) => {
    setTimeout(() => {
      resolve(`Fetched ${url}`);
    }, 1000);
  });
}

async function getUnicornTask(): Promise<Task<string>> {
  return () =>
    new Promise((resolve) => {
      setTimeout(() => {
        resolve('Unicorn task completed');
      }, 1500);
    });
}

const queue = new PQueue({ concurrency: 1 });

(async () => {
  await queue.add(() => got('https://sindresorhus.com'));
  console.log('Done: sindresorhus.com');
})();

(async () => {
  await queue.add(() => got('https://avajs.dev'));
  console.log('Done: avajs.dev');
})();

(async () => {
  const task = await getUnicornTask();
  await queue.add(task);
  console.log('Done: Unicorn task');
})();
