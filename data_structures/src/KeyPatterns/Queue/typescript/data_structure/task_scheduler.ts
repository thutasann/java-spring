import { Queue } from './queue';

class TaskScheduler {
  private taskQueue: Queue<number>;

  constructor() {
    this.taskQueue = new Queue<number>();
  }

  addTask(taskId: number) {
    console.log(`Adding task ${taskId} to the queue.`);
    this.taskQueue.enqueue(taskId);
  }

  processTask(): void {
    if (this.taskQueue.isEmpty()) {
      console.log('No tasks to process..');
      return;
    }

    const taskId = this.taskQueue.dequeue();
    console.log(`Processing task ${taskId}`);
  }

  nextTask(): void {
    const taskId = this.taskQueue.peek();
    if (taskId === null) {
      console.log('No Task in the queue..');
    } else {
      console.log(`Next task to process is ${taskId}`);
    }
  }

  tasksCount(): void {
    console.log(`There are ${this.taskQueue.size()} tasks in the queue.`);
  }
}

const scheduler = new TaskScheduler();
scheduler.addTask(101);
scheduler.addTask(102);
scheduler.addTask(103);
scheduler.addTask(104);

scheduler.nextTask(); // Output: Next task to process is 101.

console.log(' ========== PROCESSING =========== ');

// Process tasks
scheduler.processTask(); // Output: Processing task 101.
scheduler.processTask(); // Output: Processing task 102.

scheduler.tasksCount(); // Output: There are 1 tasks in the queue.
