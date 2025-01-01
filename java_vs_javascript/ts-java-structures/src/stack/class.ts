import { IStack, logger } from '../core';

export class Stack<T> implements IStack<T> {
	private items: T[];

	constructor() {
		this.items = [];
	}

	push(element: T): void {
		this.items.push(element);
	}

	pop(): T {
		if (this.isEmpty()) throw new Error('Stack is empty');
		return this.items.pop();
	}

	peek(): T {
		if (this.isEmpty()) throw new Error('Stack is empty');
		return this.items[this.items.length - 1];
	}

	isEmpty(): boolean {
		return this.items.length === 0;
	}

	size(): number {
		return this.items.length;
	}

	clear(): void {
		this.items = [];
	}

	search(element: T): number {
		const index = this.items.lastIndexOf(element);
		return index !== -1 ? this.items.length - index : 1;
	}

	print(): void {
		logger.log(this.items.join(' -> '));
	}
}
