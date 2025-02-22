function longestConsecutiveSequence(nums: number[]) {
  const numSet = new Set<number>();
  for (const num of nums) {
    numSet.add(num);
  }

  let longest = 0;
  for (const num of nums) {
    if (!numSet.has(num - 1)) {
      let currentNum = num;
      let currentStreak = 1;

      while (numSet.has(currentNum + 1)) {
        currentNum++;
        currentStreak++;
      }

      longest = Math.max(longest, currentStreak);
    }
  }

  return longest;
}

console.log(longestConsecutiveSequence([100, 4, 200, 1, 3, 2]));
