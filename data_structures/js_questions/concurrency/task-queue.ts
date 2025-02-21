/**
 * Queueing Tasks (FIFO Execution)
 * @description
 * - Execute tasks one after another in a first-in, first-out (FIFO) order≈
 * - A `TaskQueue` class maintains a queue of asynchronous tasks.
 * - The `enqueue` method add tasks to the queue.
 * - The `run` method ensures tasks execute sequentially without overlap
 */
class TaskQueue {
  private queue: (() => Promise<void>)[] = [];
  private executing: boolean = false;

  enqueue(task: () => Promise<void>): void {
    this.queue.push(task);
    this.run();
  }

  private async run(): Promise<void> {
    if (this.executing) return;
    this.executing = true;

    while (this.queue.length) {
      await this.queue.shift()?.();
    }

    this.executing = false;
  }
}

const queue = new TaskQueue();
queue.enqueue(
  () =>
    new Promise((res) =>
      setTimeout(() => {
        console.log('Task 1 done');
        res();
      }, 1000)
    )
);
queue.enqueue(
  () =>
    new Promise((res) =>
      setTimeout(() => {
        console.log('Task 2 Done');
        res();
      }, 500)
    )
);
