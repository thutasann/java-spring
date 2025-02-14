package KeyPatterns.SlidingWindow.leetcodes.easy;

/**
 * Longest Continuous Increasing Subsequence
 * Given an unsorted array of integers nums, return the length of the longest
 * continuous increasing subsequence (i.e. subarray). THe subsequence must be
 * strictly increasing.
 */
public class LongestContinuousIncreasingSubsequence {
    public static void main() {
        int[] nums = { 1, 3, 5, 4, 7 };
        System.out.println("Length of LCIS: " + findLengthOfLCIS(nums));
    }

    public static int findLengthOfLCIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int maxLength = 1;
        int currentLength = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                currentLength++;
            } else {
                currentLength = 1;
            }

            maxLength = Math.max(maxLength, currentLength);
        }

        return maxLength;
    }
}
