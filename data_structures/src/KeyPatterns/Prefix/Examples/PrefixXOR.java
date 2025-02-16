package KeyPatterns.Prefix.Examples;

public class PrefixXOR {
    public static void main(String[] args) {
        int[] nums = { 3, 8, 2, 6, 4 };
        int[] prefixXor = computePrefixXor(nums);
        System.out.println(rangeXor(prefixXor, 1, 4));
    }

    private static int[] computePrefixXor(int[] nums) {
        int n = nums.length;
        int[] prefixXOR = new int[n];
        prefixXOR[0] = nums[0];

        for (int i = 1; i < n; i++) {
            prefixXOR[i] = prefixXOR[i - 1] ^ nums[i];
        }

        return prefixXOR;
    }

    private static int rangeXor(int[] prefixXor, int l, int r) {
        if (l == 0) {
            return prefixXor[r];
        }
        return prefixXor[r] ^ prefixXor[l - 1];
    }
}
