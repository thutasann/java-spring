package KeyPatterns.Prefix.Examples.Easy;

public class SmallestIndexWithSum {
    public static void main(String[] args) {
        int[] nums = { 3, 1, 4, 2, 8 };
        System.out.println(findSmallestIndex(nums, 7));
    }

    private static int findSmallestIndex(int[] nums, int target) {
        int n = nums.length;
        int[] prefix = new int[n];
        prefix[0] = nums[0];

        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] + nums[i];
            if (prefix[i] >= target) {
                return i;
            }
        }

        return -1;
    }
}
