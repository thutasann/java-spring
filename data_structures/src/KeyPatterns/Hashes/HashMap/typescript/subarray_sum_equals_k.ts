function subArraySum(nums: number[], k: number): number {
  const prefixMap = new Map<number, number>();
  prefixMap.set(0, 1);
  let count = 0,
    prefixSum = 0;

  for (const num of nums) {
    prefixSum += num;
    count += prefixMap.get(prefixSum - k) || 0;
    prefixMap.set(prefixSum, (prefixMap.get(prefixSum) || 0) + 1);
  }

  return count;
}
console.log(subArraySum([1, 1, 1], 2));
