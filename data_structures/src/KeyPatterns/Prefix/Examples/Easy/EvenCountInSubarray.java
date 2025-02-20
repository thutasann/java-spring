package KeyPatterns.Prefix.Examples.Easy;

/**
 * Find Even Numbers in a Subarray
 * - Given an array `nums`,
 * count the number of even numbers in a subarray `[L,R]`
 */
public class EvenCountInSubarray {
    public static void main(String[] args) {
        int[] nums = { 2, 1, 4, 6, 5 };
        System.out.println(countEvenNumbers(nums, 1, 3));
    }

    private static int countEvenNumbers(int[] nums, int L, int R) {
        int n = nums.length;
        int[] prefix = new int[n];
        prefix[0] = (nums[0] % 2 == 0) ? 1 : 0;
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] + ((nums[i] % 2 == 0) ? 1 : 0);
        }
        return (L == 0) ? prefix[R] : prefix[R] - prefix[L - 1];
    }
}
