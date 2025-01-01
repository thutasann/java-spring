export interface IStack<T> {
	/**
	 * Push an item onto the stack
	 * @param element - item to be pushed
	 */
	push(element: T): void;
	/**
	 * Remove and return the Top Item from the stack
	 */
	pop(): T | undefined;
	/**
	 * Return the top item from the stack without removing it
	 */
	peek(): T | undefined;
	/**
	 * Check if the stack is empty
	 */
	isEmpty(): boolean;
	/**
	 * Return the size of the stack
	 */
	size(): number;
	/**
	 * Clear the Stack
	 */
	clear(): void;
	/**
	 * Search for an element and return its position from the top
	 * @param element - element to be searched
	 */
	search(element: T): number;
	/**
	 * Print all items in the stack
	 */
	print(): void;
}
