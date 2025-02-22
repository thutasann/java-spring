function longestSubStringWithoutRepeating(str: string) {
  const charMap = new Map<string, number>();
  let maxLength = 0,
    left = 0;

  for (let right = 0; right < str.length; right++) {
    if (charMap.has(str.charAt(right))) {
      left = Math.max(left, (charMap.get(str.charAt(right)) || 0) + 1);
    }
    charMap.set(str.charAt(right), right);
    maxLength = Math.max(maxLength, right - left + 1);
  }

  return maxLength;
}

const result = longestSubStringWithoutRepeating('abcabcbb');
console.log('result', result);
