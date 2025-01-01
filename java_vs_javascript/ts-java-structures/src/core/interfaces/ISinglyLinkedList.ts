import { SinglyNode } from '../../linked-list/singly-linked-list/class';

/**
 * Singly Linked List
 */
export interface ISinglyLinkedList<T> {
	/**
	 * Add a node to the end of teh list
	 * @param value - value
	 */
	append(value: T): void;
	/**
	 * Add a node to the beginning of the list
	 * @param value - value
	 */
	prepend(value: T): void;
	/**
	 * Add a node at a specific idnex
	 * @param value - value
	 * @param index - index
	 */
	insertAt(value: T, index: number): void;
	/**
	 * Delete a node by value
	 * @param value - value
	 */
	delete(value: T): void;
	/**
	 * Delete a node at specific index
	 * @param index - index
	 */
	deleteAt(index: number): void;
	/**
	 * Find a node by value
	 * @param value - value
	 */
	find(value: T): SinglyNode<T> | null;
	/**
	 * Get the node at a specific index
	 * @param index - index
	 */
	get(index: number): T | null;
	/**
	 *  Check if the list is empty
	 */
	isEmpty(): boolean;
	/**
	 * Get the size of the list
	 */
	getSize(): number;
	/**
	 * Print the list
	 */
	print(): void;
	/**
	 * Clear the list
	 */
	clear(): void;
	/**
	 * Reverse the list
	 */
	reverse(): void;
}
