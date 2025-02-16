package KeyPatterns.Prefix.Examples;

/**
 * Basic Prefix Sum
 * 
 * @apiNote
 *          - Problem: Given an array, find the sum of elements from index `l`
 *          to `r`.
 */
public class BasicPrefixSum {
    public static void main(String[] args) {
        System.out.println("\nBasic Prefix Sum ===> ");

        int[] nums = { 2, 4, 5, 1, 6 };
        int[] prefix = computePrefixSum(nums);
        System.out.println(rangeSum(prefix, 1, 3)); // Output: 10 (4+5+1)
    }

    private static int[] computePrefixSum(int[] nums) {
        int n = nums.length;
        int[] prefix = new int[n];
        prefix[0] = nums[0];

        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] + nums[i];
        }

        return prefix;
    }

    private static int rangeSum(int[] prefix, int l, int r) {
        if (l == 0) {
            return prefix[r];
        }
        return prefix[r] - prefix[l - 1];
    }
}
