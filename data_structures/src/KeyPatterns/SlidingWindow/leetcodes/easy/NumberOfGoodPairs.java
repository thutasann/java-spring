package KeyPatterns.SlidingWindow.leetcodes.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * Number of Good Pairs
 * Given an array of integers nums, return the number of good pairs.
 * A pair (i, j) is called good if nums[i] == nums[j] and i < j.
 */
public class NumberOfGoodPairs {
    public static void main() {
        int[] nums = { 1, 2, 3, 1, 1, 3 };
        System.out.println("\nNumber of Good Pairs ==> " + numIdenticalPairs(nums));
    }

    public static int numIdenticalPairs(int[] nums) {
        int goodPairs = 0;
        Map<Integer, Integer> countMap = new HashMap<>();

        for (int num : nums) {
            if (countMap.containsKey(num)) {
                goodPairs += countMap.get(num);
            }

            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        return goodPairs;
    }
}
