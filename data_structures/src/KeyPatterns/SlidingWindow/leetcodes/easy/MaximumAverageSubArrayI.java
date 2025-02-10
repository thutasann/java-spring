package KeyPatterns.SlidingWindow.leetcodes.easy;

/**
 * Maximum Average Subarray I
 * You are given an integer array nums consisting of n elements, and an integer
 * k.
 * Find a contiguous subarray whose length is equal to k that has the maximum
 * average value and return this value.Any answer with a calculation error less
 * than 10-5 will be accepted.
 */
public class MaximumAverageSubArrayI {
    public static void main() {
        System.out.println("\nMaximum Average Sub Array ==> ");
        int[] nums = { 1, 12, -5, -6, 50, 3 };
        int k = 4;
        System.out.println("Max Average: " + findMaxAverage(nums, k));
    }

    private static double findMaxAverage(int[] arr, int k) {
        double maxSum = 0, windowSum = 0;

        for (int i = 0; i < k; i++) {
            maxSum += arr[i];
        }
        windowSum = maxSum;

        for (int i = k; i < arr.length; i++) {
            windowSum += arr[i] - arr[i - k];
            maxSum = Math.max(maxSum, windowSum);
        }

        return maxSum / k;
    }
}
