package KeyPatterns.Prefix.Examples;

public class SubArrayXor {
    public static void main(String[] args) {
        int[] nums = { 4, 8, 2, 10 };
        System.out.println(xorInRange(nums, 2, 4));
    }

    public static int xorInRange(int[] nums, int L, int R) {
        int n = nums.length;
        int[] prefix = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            prefix[i] = prefix[i - 1] ^ nums[i - 1];
        }

        return prefix[R] ^ prefix[L - 1];
    }
}
