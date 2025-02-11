package KeyPatterns.SlidingWindow.leetcodes.easy;

public class FindPivotIndex {
    public static void main() {
        System.out.println("\nFind Pivot Index ==> ");
        int[] nums = { 1, 7, 3, 6, 5, 6 };
        System.out.println("Pivot Index: " + pivotIndex(nums));
    }

    public static int pivotIndex(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int totalSum = 0;
        int leftSum = 0;

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
