package KeyPatterns.Prefix.Practices;

/**
 * Sum of All Subarrays
 * - Problem: Given an array `nums`, find the sum of all possible subarrays.
 */
public class SumOfAllSubarrays {
    public static void main(String[] args) {
        int[] nums = { 1, 2, 3 };
        System.out.println(sumAllArrays(nums));
    }

    public static long sumAllArrays(int[] nums) {
        int n = nums.length;
        long totalSum = 0;
        long[] prefix = new long[n];
        prefix[0] = nums[0];

        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] + nums[i];
        }

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                totalSum += (i == 0) ? prefix[j] : (prefix[j] - prefix[i - 1]);
            }
        }

        return totalSum;
    }
}
