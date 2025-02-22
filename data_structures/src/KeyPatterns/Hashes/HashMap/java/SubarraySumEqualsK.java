package KeyPatterns.Hashes.HashMap.java;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK {
    public static void main(String[] args) {
        int[] nums = { 1, 1, 1 };
        int k = 2;
        System.out.println(subArraySum(nums, k));
    }

    private static int subArraySum(int[] nums, int k) {
        Map<Integer, Integer> prefixMap = new HashMap<>();
        prefixMap.put(0, 1);
        int count = 0, prefixSum = 0;

        for (int num : nums) {
            prefixSum += num;
            count += prefixMap.getOrDefault(prefixSum - k, 0);
            prefixMap.put(prefixSum, prefixMap.getOrDefault(prefixSum, 0) + 1);
        }

        return count;
    }
}
