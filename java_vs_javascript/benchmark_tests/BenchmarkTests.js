// @ts-check
const fs = require('fs');
const path = require('path');

class BenchmarkTests {
	/**
	 * Time: 1227 ms
	 */
	loopSample() {
		console.log('\n==> Loop Sample');
		const start = Date.now();
		let sum = 0;
		for (let i = 0; i < 1_000_000_000; i++) {
			sum += i;
		}
		const end = Date.now();
		console.log(`Time: ${end - start} ms`);
	}

	/**
	 * Sum: 49999995000000
	 * Time: 404 ms
	 */
	memoryIntensiveSample() {
		console.log('\n==> Memory Intensive Sample');
		const start = Date.now();
		const numbers = [];
		for (let i = 0; i < 10_000_000; i++) {
			numbers.push(i);
		}
		const sum = numbers.reduce((acc, num) => acc + num, 0);
		const end = Date.now();
		console.log('Sum:', sum);
		console.log('Time:', end - start, 'ms');
	}

	/**
	 * Time: 99ms
	 */
	IOIntensiveTask() {
		console.log('\n==> IO Intensive Sample');
		const filePath = path.join(__dirname, 'largeFileJS.txt');
		const start = Date.now();
		fs.writeFileSync(filePath, 'This is a benchmark test.\n'.repeat(1_000_000));
		const content = fs.readFileSync(filePath, 'utf-8');
		const end = Date.now();
		console.log('Time: ', end - start, ' ms');
	}

	/**
	 * 9.902 ms
	 */
	stringConcat() {
		console.time('stringConcat');
		let str = '';
		for (let i = 0; i < 1e5; i++) {
			str += 'a';
		}
		console.timeEnd('stringConcat');
	}

	/**
	 * 491.172ms
	 */
	arraySort() {
		console.time('SortJS');
		const array = Array.from({ length: 1e6 }, () => Math.random());
		array.sort((a, b) => b - a);
		console.timeEnd('SortJS');
	}
}

const benchmarkTests = new BenchmarkTests();
