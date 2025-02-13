package KeyPatterns.SlidingWindow.leetcodes.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * Subarray sums equals K
 * - Given an array of integers nums and an integer k, return the total number
 * of subarrays whose sum equals to k.
 * - A subarray is a contiguous non-empty sequence of elements within an array.
 */
public class SubarraySumEqualsK {
    public static void main() {
        System.out.println("\nSubarray Sum Equals K ==> ");
        int[] nums = { 1, 1, 1 };
        int k = 2;
        System.out.println("Total Subarrays: " + subarraySum(nums, k));
    }

    public static int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> prefixSumCounts = new HashMap<>();
        prefixSumCounts.put(0, 1);
        int prefixSum = 0;
        int count = 0;

        for (int num : nums) {
            prefixSum += num;

            if (prefixSumCounts.containsKey(prefixSum - k)) {
                count += prefixSumCounts.get(prefixSum - k);
            }

            prefixSumCounts.put(prefixSum, prefixSumCounts.getOrDefault(prefixSum, 0) + 1);
        }

        return count;
    }
}
