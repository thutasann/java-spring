package KeyPatterns.SlidingWindow;

/**
 * A variable-sized sliding window dynamically expands and shrinks based on
 * conditions instead of having a fixed length like in the standard sliding
 * window technique.
 * 
 * - Use Two Pointers (start and end) to track the window.
 * - Expand the window (end++) until it meets a condition.
 * - Shrink the window (start++) when the condition is exceeded.
 * - Keep track of the minimum/maximum result depending on the problem.
 */
public class VariableSizedSlideWindow {
    public static void Examples() {
        largestSubArraySum();
        smallestSubArrayWithSum();
    }

    public static void smallestSubArrayWithSum() {
        int[] arr = { 2, 3, 1, 2, 4, 3 };
        int target = 7;
        System.out.println("\n(Variable Sized) Smallest SubArray Sum ==> ");
        int start = 0, windowSum = 0, minLength = Integer.MAX_VALUE;

        for (int end = 0; end < arr.length; end++) {
            windowSum += arr[end];

            while (windowSum >= target) {
                minLength = Math.min(minLength, end - start + 1);
                windowSum -= arr[start]; // remove the left most element
                start++; // move the window forward
            }
        }
        int answer = (minLength == Integer.MAX_VALUE) ? -1 : minLength;
        System.out.println("answer ==> " + answer);
    }

    /**
     * Given an array and an integer X, find the largest sum of a subarray that does
     * not exceed X.
     * - Expand the window until the sum exceeds X.
     * - If the sum is greater than X, shrink the window from the last (start++)
     * - Track the maximum valid sum.
     */
    public static void largestSubArraySum() {
        System.out.println("\n(Variable Sized) Largest SubArray Sum ==> ");
        int[] arr = { 4, 3, 1, 2, 5, 8 };
        int x = 10;

        int start = 0, windowSum = 0, maxSum = 0;

        for (int end = 0; end < arr.length; end++) {
            windowSum += arr[end]; // Expand window

            while (windowSum > x) { // shrink window if sum exceeds x
                windowSum -= arr[start];
                start++;
            }

            maxSum = Math.max(maxSum, windowSum); // Track max sum
        }

        System.out.println("maxSum ==> " + maxSum);
    }
}
