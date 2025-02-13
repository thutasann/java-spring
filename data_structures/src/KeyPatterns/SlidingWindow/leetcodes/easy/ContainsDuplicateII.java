package KeyPatterns.SlidingWindow.leetcodes.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * Contains Duplicate II
 * Given an integer array nums and an integer k, return true if there are two
 * distinct indices i and j in the array such that nums[i] == nums[j] and abs(i
 * - j) <= k.
 */
public class ContainsDuplicateII {
    public static void main() {
        int[] nums = { 1, 2, 3, 1 };
        int k = 3;
        System.out.println("\nContains Nearby Duplicate => " + containsNearByDuplicate(nums, k));
    }

    public static boolean containsNearByDuplicate(int[] nums, int k) {
        Map<Integer, Integer> indexMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (indexMap.containsKey(nums[i])) {
                if (i - indexMap.get(nums[i]) <= k) {
                    return true;
                }
            }
            indexMap.put(nums[i], i);
        }

        return false;
    }

}
