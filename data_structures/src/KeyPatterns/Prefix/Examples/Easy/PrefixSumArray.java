package KeyPatterns.Prefix.Examples.Easy;

import java.util.Arrays;

public class PrefixSumArray {
    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 4, 5 };
        System.out.println(Arrays.toString(computePrefixSum(nums)));
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
}
