type Task<T> = (() => Promise<T>)[];
type Limit = number;

async function limitConcurrency<T>(tasks: Task<T>, limit: Limit): Promise<T[]> {
  const results: Promise<T>[] = [];
  const executing: Set<Promise<T>> = new Set();

  for (const task of tasks) {
    const promise = task().then((res) => {
      executing.delete(promise);
      return res;
    });

    executing.add(promise);
    results.push(promise);

    if (executing.size >= limit) {
      await Promise.race(executing);
    }
  }

  return Promise.all(results);
}

const tasks: (() => Promise<string>)[] = [
  () => new Promise((res) => setTimeout(() => res('Task 1 Done'), 1000)),
  () => new Promise((res) => setTimeout(() => res('Task 2 Done'), 500)),
  () => new Promise((res) => setTimeout(() => res('Task 3 Done'), 800)),
];

limitConcurrency(tasks, 2).then(console.log);
