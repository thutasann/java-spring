package neetcode_150.src;

import java.util.HashSet;

/**
 * Longest Consecutive Sequence
 * - Given an unsorted array of integers `nums`, return the length of the
 * consecutive elements sequence
 * - You must write an algorithm that runs in `O(n)` time
 */
public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        int[] nums = { 100, 4, 200, 1, 3, 2 };
        System.out.println("Brute Force : " + bruteForce(nums));

        System.out.println("Optimal : " + longestConsecutive(nums));
    }

    /**
     * Optimal Solution
     * 
     * @param nums
     * @return
     */
    private static int longestConsecutive(int[] nums) {
        if (nums.length == 0 || nums == null) {
            return 0;
        }

        HashSet<Integer> numsSet = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            numsSet.add(nums[i]);
        }

        int longestSub = 0;

        for (int num : numsSet) {
            if (numsSet.contains(num - 1)) {
                continue;
            } else {
                int currentNum = num;
                int currentSub = 1;

                while (numsSet.contains(currentNum + 1)) {
                    currentNum++;
                    currentSub++;
                }

                longestSub = Math.max(longestSub, currentSub);
            }
        }

        return longestSub;
    }

    /**
     * Just Testing BruteForce
     * 
     * @param nums
     * @return
     */
    private static int bruteForce(int[] nums) {
        int maxLength = 0;

        for (int num : nums) {
            if (!contains(nums, num - 1)) {
                int currentNum = num;
                int currentStreak = 1;

                while (contains(nums, currentNum + 1)) {
                    currentNum++;
                    currentStreak++;
                }

                maxLength = Math.max(maxLength, currentStreak);
            }
        }

        return maxLength;
    }

    private static boolean contains(int[] nums, int target) {
        for (int num : nums) {
            if (num == target) {
                return true;
            }
        }
        return false;
    }

}
