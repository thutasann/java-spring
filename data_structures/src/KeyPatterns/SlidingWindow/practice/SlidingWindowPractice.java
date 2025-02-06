package KeyPatterns.SlidingWindow.practice;

import java.util.HashMap;

public class SlidingWindowPractice {
    public static void main(String[] args) {
        System.out.println("Sliding Window Practice ==> ");

        int[] arr = { 2, 1, 5, 1, 3, 2 };
        int k = 3;
        System.out.println("Maximum sum of a subarray of size " + k + " is " + maxSumSubarray(arr, k));

        System.out.println("Longest SubString " + longestSubstringWithoutRepeating("abcabcbb"));
    }

    /**
     * Maximum Sum Subarray of Size K
     * - `maxSum` to store the maxium sum found
     * - `windowSum` to keep track of the current window sum
     * - `windowStart` to point to the start of the window
     * - Loop through the array using `windowEnd` to represent the end of the
     * current window.
     * - Add the current element `arr[windowEnd]` to `windowSum`
     * - Once the size of the window equals `K` (i.e., windowEnd >= k - 1), compare
     * and update maxSum if windowSum is greater
     * - Remove the element at windowStart from windowSum and increment windowStart
     * to slide the window forward.
     */
    private static int maxSumSubarray(int[] arr, int k) {
        int maxSum = 0, windowSum = 0;
        int windowStart = 0;

        for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
            windowSum += arr[windowEnd];

            if (windowEnd >= k - 1) {
                maxSum = Math.max(maxSum, windowSum);
                windowSum -= arr[windowStart];
                windowStart++;
            }
        }
        return maxSum;
    }

    /**
     * - `maxLength` to track the maximum length of the substring found.
     * - `charIndexMap` to store the index of each character to detect duplicates
     * - `windowStart` to point to the start of the window
     * - Use `windowEnd` to iterate over the string.
     * - For each character, check if it exists in charIndexMap.
     * - If it does, move windowStart to the right of the last occurrence to ensure
     * all characters in the window are unique.
     */
    private static int longestSubstringWithoutRepeating(String s) {
        int maxLength = 0;
        HashMap<Character, Integer> charIndexMap = new HashMap<>();
        int windowStart = 0;

        for (int windowEnd = 0; windowEnd < s.length(); windowEnd++) {
            char rightChar = s.charAt(windowEnd);

            if (charIndexMap.containsKey(rightChar)) {
                windowStart = Math.max(windowStart, charIndexMap.get(rightChar) + 1);
            }
            charIndexMap.put(rightChar, windowEnd);
            maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
        }

        return maxLength;
    }
}
