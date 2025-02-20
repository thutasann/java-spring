package KeyPatterns.Prefix.Examples.Easy;

/**
 * Sum of a Subarray using Prefix Sum
 * - Given an array `nums` and a range `[L, R]`,
 * - find the sum of elements from `nums[L]` to `nums[R]`
 */
public class SubarraySum {
    public static void main(String[] args) {
        int[] nums = { 2, 4, 6, 8, 10 };
        System.out.println(subArraySum(nums, 1, 3));
    }

    private static int subArraySum(int[] nums, int L, int R) {
        int n = nums.length;
        int[] prefix = new int[n];
        prefix[0] = nums[0];

        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] + nums[i];
        }

        return (L == 0) ? prefix[R] : prefix[R] - prefix[L - 1];
    }
}
