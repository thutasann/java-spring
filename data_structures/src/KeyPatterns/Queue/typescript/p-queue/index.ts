export type Task<T> = () => Promise<T>;

export class PQueue<T = any> {
  private concurrency: number;
  private queue: Task<T>[] = [];
  private activeCount = 0;

  constructor({ concurrency = 1 } = {}) {
    if (concurrency < 1) {
      throw new Error('Concurrency must be atleast 1');
    }
    this.concurrency = concurrency;
  }

  private next(): void {
    if (this.queue.length === 0 || this.activeCount >= this.concurrency) {
      return;
    }

    const task = this.queue.shift()!;
    this.activeCount++;

    task()
      .then(() => {
        this.activeCount--;
        this.next();
      })
      .catch((err) => {
        console.error('Task error: ', err);
        this.activeCount--;
        this.next();
      });
  }

  add(task: Task<T>): Promise<T> {
    return new Promise<T>((resolve, reject) => {
      const runTask = async () => {
        try {
          const result = await task();
          resolve(result);
        } catch (error) {
          reject(error);
        }
      };

      this.queue.push(runTask as unknown as Task<T>);
      this.next();
    });
  }
}
