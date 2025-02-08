package KeyPatterns.SlidingWindow.practice;

import java.util.HashMap;
import java.util.Map;

public class VariableSizedSlidingWindowPractice {
    public static void main(String[] args) {
        System.out.println("\nVariabled-Size Sliding Window Practice ==> ");
        smallestSubArrayWithGivenSum();
        longestSubstringWithKDistinct();
        dynamicWindowSum();
        dynamicWindowDistinct();
        longestSubArrayWithSum();
        minimumWindowSubstring();
        longestSubStringWithoutRepeatingCharacter();
    }

    public static void longestSubStringWithoutRepeatingCharacter() {
        System.out.println("\nLongest SubString without repeating character ==> ");
        String str = "abcabcbb";
        int windowStart = 0, maxLength = 0;
        Map<Character, Integer> charIndexMap = new HashMap<>();

        for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
            char rightChar = str.charAt(windowEnd);

            if (charIndexMap.containsKey(rightChar)) {
                windowStart = Math.max(windowStart, charIndexMap.get(rightChar) + 1);
            }

            charIndexMap.put(rightChar, windowEnd);
            maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
        }

        System.out.println("maxLength ==> " + maxLength);
    }

    /**
     * Minimum Window Substring
     * - Given a string `s` and a string `t`, return the minimum window in `s` which
     * contain all the characters in `t`. if there is no such window in `s` that
     * covers all characters in `t`, return empty string.
     * 
     * Approach
     * - Use Two Maps: One for counting characters in t (tMap) and one for the
     * current window (windowMap)
     * - Expand the window: Move (windowEnd) to include more characters until all
     * characters from t are included.
     * - Shrink the window: Once all characters are include, try to minimize the
     * window size by moving windowStart.
     * - Track the Minimum Window: Update the minimum window size when a valid
     * window is found.
     */
    public static void minimumWindowSubstring() {
        System.out.println("\nMinimum Window Substring ==> ");
        String s = "ADOBECODEBANC";
        String t = "ABC";
        if (s.length() == 0 || t.length() == 0) {
            System.out.println("Invalid Inputs");
        }

        Map<Character, Integer> tMap = new HashMap<>();
        for (char c : t.toCharArray()) {
            tMap.put(c, tMap.getOrDefault(c, 0) + 1);
        }

        Map<Character, Integer> windowMap = new HashMap<>();
        int windowStart = 0, minLength = Integer.MAX_VALUE, minStart = 0;
        int matches = 0;

        for (int windowEnd = 0; windowEnd < s.length(); windowEnd++) {
            char rightChar = s.charAt(windowEnd);
            windowMap.put(rightChar, windowMap.getOrDefault(rightChar, 0) + 1);

            if (tMap.containsKey(rightChar) && windowMap.get(rightChar).equals(tMap.get(rightChar))) {
                matches++;
            }

            while (matches == tMap.size()) {

                if (windowEnd - windowStart + 1 < minLength) {
                    minLength = windowEnd - windowStart + 1;
                    minStart = windowStart;
                }

                char leftChar = s.charAt(windowStart);
                windowMap.put(leftChar, windowMap.getOrDefault(leftChar, 0) - 1);

                if (tMap.containsKey(leftChar) && windowMap.get(leftChar) < tMap.get(leftChar)) {
                    matches--;
                }

                windowStart++;
            }
        }

        String ans = minLength == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLength);
        System.out.println("ans ==> " + ans);
    }

    /**
     * Longest Subarray with Sum at Most `S`
     * - Given an array of positive integers and a positive integer `S`, find the
     * length of the longest subarray that sums to at most `S`
     * 
     * Approach
     * - Initialize: Start with two pointers (`windowstart` and `windowEnd`) and a
     * variable to keep track of the current sum (`windowSum`)
     * - Expand the Window: Iterate over the array with `windowEnd` to add element
     * to `windowSum`
     * - Shrink the Window: if the windowSum exceeds S, increment windowStart to
     * reduce the sum until it is less than or equal to S
     * - Track maximum length: During each valid window, calculate the window's
     * length and update maxLength found
     */
    public static void longestSubArrayWithSum() {
        System.out.println("\nLongest Subarray with Sum at Most S ==> ");
        int[] arr = { 3, 1, 2, 1, 1, 1, 1, 2 };
        int S = 5;

        int windowStart = 0, windowSum = 0, maxLength = 0;

        for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
            windowSum += arr[windowEnd];

            while (windowSum >= S) {
                windowSum -= arr[windowStart];
                windowStart++;
            }

            maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
        }

        System.out.println("maxLength ==> " + maxLength);
    }

    public static void dynamicWindowDistinct() {
        System.out.println("\nDynamic Window Distinct ==> ");
        String str = "aabacbebebe";
        int maxDistinct = 2;
        int windowStart = 0;
        HashMap<Character, Integer> charFrequencyMap = new HashMap<>();

        for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
            char rightChar = str.charAt(windowEnd);
            charFrequencyMap.put(rightChar, charFrequencyMap.getOrDefault(rightChar, 0) + 1);

            while (charFrequencyMap.size() > maxDistinct) {
                System.out.println("Current window with more than " + maxDistinct + " distinct characters: "
                        + str.substring(windowStart, windowEnd));
                char leftChar = str.charAt(windowStart);
                charFrequencyMap.put(leftChar, charFrequencyMap.get(leftChar) - 1);
                if (charFrequencyMap.get(leftChar) == 0) {
                    charFrequencyMap.remove(leftChar);
                }
                windowStart++;
            }
        }
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
