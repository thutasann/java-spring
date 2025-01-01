import { logger } from '../core';
import { Stack } from './class';

export function StackImpl() {
	logger.info('Stack');
	const numberStack = new Stack<number>();

	numberStack.push(10);
	numberStack.push(20);
	numberStack.push(30);
	numberStack.print(); // Output: 10 -> 20 -> 30

	console.log('Peek:', numberStack.peek()); // Output: Peek: 30

	numberStack.pop();
	numberStack.print(); // Output: 10 -> 20

	console.log('Size:', numberStack.size()); // Output: Size: 2

	console.log('Search 10:', numberStack.search(10)); // Output: Search 10: 2
	console.log('Search 50:', numberStack.search(50)); // Output: Search 50: -1

	numberStack.clear();
	console.log('Is Empty:', numberStack.isEmpty()); // Output: Is Empty: true
}
