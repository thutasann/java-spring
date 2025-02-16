package KeyPatterns.Prefix.Examples;

/**
 * Running Sum (Simple Prefix Sum)
 * - Problem: Convert an array into its running sum (prefix sum).
 * - Approach: Directly modify an array to store cumulative sum.
 */
public class RunningSum {
    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 4 };
        int[] result = runningSum(nums);
        for (int r : result) {
            System.out.println("result ==> " + r);
        }
    }

    private static int[] runningSum(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i - 1];
        }
        return nums;
    }
}
