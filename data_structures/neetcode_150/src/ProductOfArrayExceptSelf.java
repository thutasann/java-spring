package neetcode_150.src;

import java.util.Arrays;

/**
 * Product of Array Except Self
 * 
 * @apiNote
 *          - Given an intger array `nums`, return an array such that
 *          `answers[i]` is equal to the product of all the elements of `nums`
 *          except `nums[i]`
 *          - The product of any prefix or suffix of nums is guaranteed to fit
 *          in a 32-bit integer.
 *          - You must write an algorithm that runs in `O(n)` time and without
 *          using the division operation.
 * @example
 *          - Inputs: nums = [1 , 2, 3, 4]
 *          - Output: [24, 12, 8, 6]
 * @explain
 *          - index | nums[i] | product of all elements except nums[i]
 *          - 0 | 1 | 2 * 3 * 4 = 24
 */
public class ProductOfArrayExceptSelf {
    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 4 };
        System.out.println("Brute Force ==> " + Arrays.toString(bruteForce(nums)));
        System.out.println("Prefix PostFix ==> " + Arrays.toString(productExceptSelf(nums)));
    }

    private static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        Arrays.fill(result, 1);

        int pre = 1, post = 1;

        for (int i = 0; i < n; i++) {
            result[i] = pre;
            pre *= nums[i];
        }

        for (int i = n - 1; i >= 0; i--) {
            result[i] *= post;
            post *= nums[i];
        }

        return result;
    }

    /**
     * Brute Force Approach (Incorrect Approach)
     */
    private static int[] bruteForce(int[] nums) {
        System.out.println("\nBrute Force Approach ==> ");
        int n = nums.length;
        int[] ans = new int[n];

        for (int i = 0; i < n; i++) {
            int product = 1;
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    product *= nums[j];
                }
            }
            ans[i] = product;
        }

        return ans;
    }
}
