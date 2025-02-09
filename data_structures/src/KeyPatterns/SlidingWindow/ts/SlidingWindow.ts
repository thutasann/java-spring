/**
 * Sliding Window Problems, Solutions, Practices in typescript
 */
class SlidingWindow {
  main() {
    this.maxSumOptimized();
    this.longestSubStringWithoutRepeatingCharacter();
    this.smallestSubArrayWithGivenSum();
    this.longestSubstringWithKDistinct();
    this.easyDynamicWindowSum();
    this.dynamicWindowDistinct();
    this.longestSubArrayWithSum();
  }

  longestSubArrayWithSum() {
    console.log('\nLongest Subarray with Sum ==> ');
    const arr = [3, 1, 2, 1, 1, 1, 1, 2];
    const S = 5;
    let windowStart = 0,
      windowSum = 0,
      maxLength = 0;

    for (let windowEnd = 0; windowEnd < arr.length; windowEnd++) {
      windowSum += arr[windowEnd];

      while (windowSum >= S) {
        windowSum -= arr[windowStart];
        windowStart++;
      }

      maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
    }
    console.log('maxLength ==>', maxLength);
  }

  dynamicWindowDistinct() {
    console.log('\nDynamic Window Distinct ==> ');
    const str = 'aabacbebebe';
    const maxDistinct = 2;
    let widnowStart = 0;
    const charFrequencyMap = new Map<string, number>();

    for (let windowEnd = 0; windowEnd < str.length; windowEnd++) {
      const rightChar = str.charAt(windowEnd);
      charFrequencyMap.set(rightChar, (charFrequencyMap.get(rightChar) || 0) + 1);

      while (charFrequencyMap.size > maxDistinct) {
        console.log(
          `Current window with more than ${maxDistinct} distinct characters : ${str.substring(widnowStart, windowEnd)}`
        );
        const leftChar = str.charAt(widnowStart);
        charFrequencyMap.set(leftChar, (charFrequencyMap.get(leftChar) || 0) - 1);
        if (charFrequencyMap.get(leftChar) == 0) {
          charFrequencyMap.delete(leftChar);
        }
        widnowStart++;
      }
    }
  }

  easyDynamicWindowSum() {
    console.log('\n(Easy) Dynamic Window Sum ==> ');
    const arr = [1, 2, 3, 4, 5];
    const target = 8;
    let windowStart = 0,
      windowSum = 0;

    for (let windowEnd = 0; windowEnd < arr.length; windowEnd++) {
      windowSum += arr[windowEnd];

      while (windowSum >= target) {
        console.log(`Current WindowSum >= ${target} : ${windowSum}`);
        windowSum -= arr[windowStart];
        windowStart++;
      }
    }
  }

  longestSubstringWithKDistinct() {
    console.log('\nLongest SubString with K Distinct Character ==> ');
    const str = 'araaci';
    const k = 2;
    let windowStart = 0,
      maxLength = 0;
    const charFrequencyMap = new Map<string, number>();

    for (let windowEnd = 0; windowEnd < str.length; windowEnd++) {
      const rightChar = str.charAt(windowEnd);
      charFrequencyMap.set(rightChar, (charFrequencyMap.get(rightChar) || 0) + 1);

      while (charFrequencyMap.size > k) {
        const leftChar = str.charAt(windowStart);
        charFrequencyMap.set(leftChar, (charFrequencyMap.get(leftChar) || 0) - 1);
        if (charFrequencyMap.get(leftChar) == 0) {
          charFrequencyMap.delete(leftChar);
        }
        windowStart++;
      }

      maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
    }
    console.log('maxLength ==> ', maxLength);
  }

  smallestSubArrayWithGivenSum() {
    console.log('\nSmallest Subarray with given sum ==> ');
    const arr = [2, 1, 5, 2, 3, 2];
    const target = 7;
    let windowStart = 0,
      windowSum = 0,
      minLength = Number.MAX_VALUE;

    for (let windowEnd = 0; windowEnd < arr.length; windowEnd++) {
      windowSum += arr[windowEnd];

      while (windowSum >= target) {
        minLength = Math.min(minLength, windowEnd - windowStart + 1);
        windowSum -= arr[windowStart];
        windowStart++;
      }
    }

    const result = minLength === Number.MAX_VALUE ? 0 : minLength;
    console.log('result', result);
  }

  longestSubStringWithoutRepeatingCharacter() {
    console.log('\nLongest SubString without repeating Character ==> ');
    const str = 'abcabcbb';
    let windowStart = 0;
    let maxLength = 0;
    const charIndexMap = new Map<string, number>();

    for (let windowEnd = 0; windowEnd < str.length; windowEnd++) {
      const rightChar = str.charAt(windowEnd);

      if (charIndexMap.has(rightChar)) {
        windowStart = Math.max(windowStart, (charIndexMap.get(rightChar) || 0) + 1);
      }

      charIndexMap.set(rightChar, windowEnd);
      maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
    }
    console.log('maxLength', maxLength);
  }

  maxSumOptimized() {
    console.log('\nMax Sum Optimized ==> ');
    const arr = [1, 4, 2, 10, 2, 3, 1, 0, 20];
    const k = 4;
    const n = arr.length;

    if (n <= k) {
      console.log('Invalid');
    }

    let maxSum = 0;
    for (let i = 0; i < k; i++) {
      maxSum += arr[i];
    }

    let windowSum = maxSum;
    for (let i = k; i < n; i++) {
      windowSum += arr[i] - arr[i - k];
      maxSum = Math.max(maxSum, windowSum);
    }

    console.log('maxSum ==> ', maxSum);
  }
}

const slidingWindow = new SlidingWindow();
slidingWindow.main();
