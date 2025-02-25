/**
 * Queue Node to store Data and the Next Node Reference
 */
class QueueNode<T> {
  /**
   * Node Value
   */
  value: T;
  /**
   * Next Node Reference
   */
  next: QueueNode<T> | null = null;

  constructor(value: T) {
    this.value = value;
  }
}

/**
 * Queue Class implementing a basic queue using a linkedin list
 */
export class Queue<T> {
  private head: QueueNode<T> | null = null;
  private tail: QueueNode<T> | null = null;
  private length: number = 0;

  /**
   * Add Element to the end of the queue
   * @param value - value to be added
   */
  enqueue(value: T): void {
    const newNode = new QueueNode(value);

    if (this.tail) {
      this.tail.next = newNode;
    }
    this.tail = newNode;

    if (!this.head) {
      this.head = newNode;
    }
    this.length++;
  }

  /**
   * Remove and return the element from the front of the queue
   */
  dequeue(): T | null {
    if (!this.head) {
      return null;
    }

    const value = this.head.value;
    this.head = this.head.next;
    if (!this.head) {
      this.tail = null;
    }

    this.length--;
    return value;
  }

  /**
   * Return the element at the front of the queue without removing it
   */
  peek(): T | null {
    return this.head ? this.head.value : null;
  }

  /**
   * Check if the queue is empty
   */
  isEmpty(): boolean {
    return this.length === 0;
  }

  /**
   * Get the current size of the queue
   */
  size(): number {
    return this.length;
  }
}
