package KeyPatterns.SlidingWindow.practice;

import java.util.HashMap;
import java.util.Map;

public class VariableSizedSlidingWindowPractice {
    public static void main(String[] args) {
        System.out.println("\nVariabled-Size Sliding Window Practice ==> ");
        smallestSubArrayWithGivenSum();
        longestSubstringWithKDistinct();
        dynamicWindowSum();
    }

    public static void dynamicWindowSum() {
        System.out.println("\n(Easy) Dynamic Window Sum ==> ");
        int[] arr = { 1, 2, 3, 4, 5 };
        int targetSum = 8;
        int windowStart = 0, windowSum = 0;

        for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
            windowSum += arr[windowEnd];

            while (windowSum >= targetSum) {
                System.out.println("Current window sum >= " + targetSum + ": " + windowSum);
                windowSum -= arr[windowStart];
                windowStart++;
            }
        }
    }

    /**
     * Longest SubString with K Distinct Character
     * Problem Statement
     * - Given s string, find the length of the longest substring
     * that contains no more than `k` distinct characters
     * 
     * Approach
     * - Using a sliding window approach with two pointers, expanding the end and
     * counting distinct characters using a hash map
     * - When the number of the distinct character exceeds `k` shrink the window
     * from the start until the condition is met again
     * 
     * Explanation
     * - Initialization: Use a hash map to track the frequency of characters in the
     * current window
     * - Expand window: Add the character the `windowEnd` to the map
     * - Shrink Window: if the size of the map (distinct characters) exceeds `k`,
     * increment `windowStart` and decrement the frequency of the character at
     * `windowStart` until the condition is met.
     */
    public static void longestSubstringWithKDistinct() {
        System.out.println("\nLongest SubString with K Distinct Character ==> ");
        String s = "araaci";
        int k = 2;
        int windowStart = 0, maxLength = 0;
        Map<Character, Integer> charFrequencyMap = new HashMap<>();

        for (int windowEnd = 0; windowEnd < s.length(); windowEnd++) {
            char rightChar = s.charAt(windowEnd);
            charFrequencyMap.put(rightChar, charFrequencyMap.getOrDefault(rightChar, 0) + 1);

            while (charFrequencyMap.size() > k) {
                char leftChar = s.charAt(windowStart);
                charFrequencyMap.put(leftChar, charFrequencyMap.get(leftChar) - 1);
                if (charFrequencyMap.get(leftChar) == 0) {
                    charFrequencyMap.remove(leftChar);
                }
                windowStart++;
            }

            maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
        }
        System.out.println("maxLength ==> " + maxLength);
    }

    /**
     * Smallest Subarray with Given Sum
     * Problem Statement
     * - Given an array of positive integers, find the length of the
     * smallest subarray whose sum is greater than or equal to a given
     * target sum
     * 
     * Approach
     * - Use a sliding window that expands by moving its end forward to increase the
     * sum.
     * - Once the sum is greater than or equal to the target, try to shrink the
     * window from the start to find the smallest possible subarray that still meets
     * the condition.
     * 
     * Explanation
     * - Initialization : Start with `windowStart` at the beginning of the array and
     * initialize `windowSum` to 0 and `minLength` to the large value
     * - Expand Window : Iterate over `windowEnd` to add elements to the
     * `windowSum`.
     * - Shrink Window : Once windowSum is greater than or equal to `targetSum`,
     * update minLength and try to make the window smaller from the start by
     * removing elements and updating windowSum
     */
    public static void smallestSubArrayWithGivenSum() {
        System.out.println("\nSmallest Sub Array with Given Sum ==> ");
        int[] arr = { 2, 1, 5, 2, 3, 2 };
        int targetSum = 7;
        int windowStart = 0, windowSum = 0, minLength = Integer.MAX_VALUE;

        for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
            windowSum += arr[windowEnd];

            while (windowSum >= targetSum) {
                minLength = Math.min(minLength, windowEnd - windowStart + 1);
                windowSum -= arr[windowStart];
                windowStart++;
            }
        }

        int result = minLength == Integer.MAX_VALUE ? 0 : minLength;
        System.out.println("result ==> " + result);
    }
}
