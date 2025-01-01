import { ISinglyLinkedList, logger } from '../../core';

/**
 * Singly LinkedList Node
 */
export class SinglyNode<T> {
	/**
	 * Node Value
	 */
	value: T;
	/**
	 * Next Pointer
	 */
	next: SinglyNode<T> | undefined;

	/**
	 * Singly Linked List Node
	 * @param value - node value
	 */
	constructor(value: T) {
		this.value = value;
		this.next = null;
	}
}

/**
 * Singly Linked List
 */
export class SinglyLinkedList<T> implements ISinglyLinkedList<T> {
	private head: SinglyNode<T> | null;
	private size: number;

	constructor() {
		this.head = null;
		this.size = 0;
	}

	append(value: T): void {
		const newNode = new SinglyNode(value);
		if (!this.head) {
			this.head = newNode;
		} else {
			let current = this.head;
			while (current.next) {
				current = current.next;
			}
			current.next = newNode;
		}
		this.size++;
	}

	prepend(value: T): void {
		const newNode = new SinglyNode(value);
		newNode.next = this.head;
		this.head = newNode;
		this.size++;
	}

	insertAt(value: T, index: number): void {
		if (index > 0 && index <= this.size) {
			let current = this.head;
			let newNode = new SinglyNode(value);
			let count = 0;

			// traverse to the index
			while (count < index - 1) {
				current = current.next;
				count++;
			}

			newNode.next = current.next;
			current.next = newNode;
			this.size++;
		} else if (index === 0) {
			this.prepend(value);
		} else {
			console.log('Index out of bounds');
		}
	}

	delete(value: T): void {
		if (!this.head) return;

		if (this.head.value === value) {
			/** Move the head pointer to the next node (this.head.next), */
			this.head = this.head.next;
			this.size--;
			return;
		}

		/**
		 * current pointer starting at the head
		 * - Continue as long as the next node exists and its value does not match the value to be deleted.
		 * - If the loop ends, current will point to the node right before the node to be deleted
		 */
		let current = this.head;

		while (current.next && current.next.value !== value) {
			current = current.next;
		}

		if (current.next) {
			/** Update current.next to skip the node to be deleted and point to the one after it (current.next.next). */
			current.next = current.next.next;
			this.size--;
		}
	}

	deleteAt(index: number): void {
		if (index < 0 || index >= this.size) return;

		let current = this.head;

		if (index === 0) {
			this.head = this.head.next;
		} else {
			let count = 0;
			let prev: SinglyNode<T> | null = null;

			while (count < index) {
				prev = current;
				current = current.next;
				count++;
			}

			if (prev) {
				prev.next = prev.next.next;
			}
		}
		this.size--;
	}

	find(value: T): SinglyNode<T> {
		let current = this.head;
		while (current) {
			if (current.value === value) {
				return current;
			}
			current = current.next;
		}
		return null;
	}

	get(index: number): T | null {
		if (index < 0 || index >= this.size) return null;

		let current = this.head;
		let count = 0;

		while (count < index) {
			current = current.next;
			count++;
		}

		return current.value;
	}

	isEmpty(): boolean {
		return this.size === 0;
	}

	getSize(): number {
		return this.size;
	}

	print(): void {
		const values: T[] = [];
		let current = this.head;
		while (current) {
			values.push(current.value);
			current = current.next;
		}
		logger.log(values.join(' -> '));
	}

	clear(): void {
		this.head = null;
		this.size = 0;
	}

	reverse(): void {
		let prev: SinglyNode<T> | null = null;
		let current = this.head;
		let next: SinglyNode<T> | null = null;

		while (current) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}

		this.head = prev;
	}
}
