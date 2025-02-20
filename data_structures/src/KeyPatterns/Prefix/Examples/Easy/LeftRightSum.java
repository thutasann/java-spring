package KeyPatterns.Prefix.Examples.Easy;

public class LeftRightSum {
    public static void main(String[] args) {
        int[] nums = { 1, 7, 3, 6, 5, 6 };
        System.out.println(findEquilibriumIndex(nums));
    }

    private static int findEquilibriumIndex(int[] nums) {
        int totalSum = 0, leftSum = 0;

        for (int num : nums) {
            totalSum += num;
        }

        for (int i = 0; i < nums.length; i++) {
            if (leftSum == totalSum - leftSum - nums[i]) {
                return i;
            }
            leftSum += nums[i];
        }

        return -1;
    }
}
