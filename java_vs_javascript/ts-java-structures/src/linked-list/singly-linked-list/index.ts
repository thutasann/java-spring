import { logger } from '../../core';
import { SinglyLinkedList } from './class';

export function SinglyLinkedListImpl() {
	logger.info('Singly Linked List');
	const numberList = new SinglyLinkedList<number>();

	numberList.append(10);
	numberList.append(20);
	numberList.append(30);
	numberList.print(); // Output: 10 -> 20 -> 30

	numberList.prepend(5);
	numberList.print(); // Output: 5 -> 10 -> 20 -> 30

	numberList.insertAt(15, 2);
	numberList.print(); // Output: 5 -> 10 -> 15 -> 20 -> 30

	numberList.delete(20);
	numberList.print(); // Output: 5 -> 10 -> 15 -> 30

	numberList.deleteAt(1);
	numberList.print(); // Output: 5 -> 15 -> 30

	logger.log('Find 10:' + numberList.find(10)); // Output: Find 10: null
	logger.log('Get index 1:' + numberList.get(1)); // Output: Get index 1: 15

	numberList.reverse();
	numberList.print(); // Output: 30 -> 15 -> 5

	numberList.clear();
	numberList.print(); // Output: 30 -> 15 -> 5
}
