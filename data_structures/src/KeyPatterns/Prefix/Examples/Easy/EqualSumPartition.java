package KeyPatterns.Prefix.Examples.Easy;

public class EqualSumPartition {
    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 4, 5, 5 };
        System.out.println(canPartition(nums));
    }

    private static boolean canPartition(int[] nums) {
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }

        if (totalSum % 2 != 0) {
            return false;
        }

        int target = totalSum / 2;
        int prefixSum = 0;

        for (int num : nums) {
            prefixSum += num;
            if (prefixSum == target)
                return true;
        }

        return false;
    }
}
