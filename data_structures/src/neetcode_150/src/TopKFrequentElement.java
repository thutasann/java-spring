package neetcode_150.src;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Top K Frequent Elements
 * 
 * Given an integer array `nums` and integer `k`, return the `k`
 * most frequent
 * elements.
 * 
 * @apiNote
 *          - [1,1,1,2,2,3], k = 2
 *          - k = 2 which means we need to return the top two elements
 *          - 1 = 3 times
 *          - 2 = 2 times
 *          - 3 = 1 times
 *          - ans : [1,2]
 */
public class TopKFrequentElement {
    public static void main(String[] args) {
        System.out.println("\nTop K Frequent Element ==> ");
        int[] nums = { 1, 1, 1, 2, 2, 3 };
        int k = 2;
        System.out.println(Arrays.toString(topKFrequent(nums, k)));
    }

    private static int[] topKFrequent(int[] nums, int k) {
        if (nums.length == k) {
            return nums;
        }
        Map<Integer, Integer> countMap = new HashMap<>();

        for (int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        Queue<Integer> heap = new PriorityQueue<>((a, b) -> countMap.get(a) - countMap.get(b));

        for (int n : countMap.keySet()) {
            heap.add(n);
            if (heap.size() > k) {
                heap.poll();
            }
        }

        int[] ans = new int[k];

        for (int i = 0; i < k; i++) {
            ans[i] = heap.poll();
        }

        return ans;
    }
}
