package KeyPatterns.Prefix.Examples;

/**
 * Count of Even Numbers in a Range
 * - Problem : Find the count of even numbers in a subarray [l, r]
 */
public class CountEvenNumbers {
    public static void main(String[] args) {
        int[] nums = { 2, 4, 5, 1, 6, 3 };
        int[] prefixEven = computeEvenPrefix(nums);
        System.out.println(countEvens(prefixEven, 1, 4));
    }

    private static int countEvens(int[] prefixEven, int l, int r) {
        if (l == 0) {
            return prefixEven[r];
        }
        return prefixEven[r] - prefixEven[l - 1];
    }

    private static int[] computeEvenPrefix(int[] nums) {
        int n = nums.length;
        int[] prefixEven = new int[n];
        prefixEven[0] = (nums[0] % 2 == 0) ? 1 : 0;

        for (int i = 1; i < n; i++) {
            prefixEven[i] = prefixEven[i - 1] + (nums[i] % 2 == 0 ? 1 : 0);
        }

        return prefixEven;
    }
}
