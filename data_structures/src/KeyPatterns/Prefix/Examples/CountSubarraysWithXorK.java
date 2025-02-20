package KeyPatterns.Prefix.Examples;

import java.util.HashMap;
import java.util.Map;

public class CountSubarraysWithXorK {
    public static void main(String[] args) {
        int[] nums = { 4, 2, 2, 6, 4 };
        System.out.println(countSubarraysWithXorK(nums, 6)); // Output: 4
    }

    private static int countSubarraysWithXorK(int[] nums, int k) {
        Map<Integer, Integer> prefixXorCount = new HashMap<>();
        prefixXorCount.put(0, 1);
        int prefixXor = 0, count = 0;

        for (int num : nums) {
            prefixXor ^= num;
            count += prefixXorCount.getOrDefault(prefixXor ^ k, 0);
            prefixXorCount.put(prefixXor, prefixXorCount.getOrDefault(prefixXor, 0) + 1);
        }

        return count;
    }
}
