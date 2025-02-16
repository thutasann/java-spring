package KeyPatterns.Prefix.Practices;

public class EquilibriumIndex {
    public static void main(String[] args) {
        int[] nums = { 1, 7, 3, 6, 5, 6 };
        System.out.println(findEquilibrium(nums));
    }

    private static int findEquilibrium(int[] nums) {
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
