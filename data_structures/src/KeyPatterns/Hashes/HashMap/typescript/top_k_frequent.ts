function topKFrequent(nums: number[], k: number): number[] {
  const freqMap = new Map<number, number>();

  for (const num of nums) {
    freqMap.set(num, (freqMap.get(num) || 0) + 1);
  }

  /**
   * Min Heap (Priority Queue) to keep track of top k frequent elements
   * - [num, frequency]
   */
  const minHeap: [number, number][] = [];

  for (const [num, frequency] of freqMap) {
    minHeap.push([num, frequency]);
    minHeap.sort((a, b) => a[1] - b[1]);

    if (minHeap.length > k) {
      minHeap.shift();
    }
  }

  return minHeap.map(([num]) => num);
}

const nums = [1, 1, 1, 2, 2, 3];
const k = 2;
console.log(topKFrequent(nums, k));
