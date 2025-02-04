package KeyPatterns.SlidingWindow;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeMap;

/**
 * Sliding Window Practice
 */
public class Practice {
    public static void Examples() {
        System.out.println("\n(Practice) Sliding Window  ==> ");
        maxSlidingWindowUsage();
        hasPairWithSum();
        removeDuplicates();
    }

    /**
     * (Two Pointers)
     */
    public static void removeDuplicates() {
        System.out.println("\n(Two Pointers) Remove Duplicates");
        int[] nums = { 1, 1, 2, 3, 3, 4, 5 };
        int slow = 0;
        for (int fast = 0; fast < nums.length; fast++) {
            if (nums[fast] != nums[slow]) {
                slow++;
                nums[slow] = nums[fast];
            }
        }
        int ans = slow + 1;
        System.out.println("ans ==> " + ans);
    }

    /**
     * (Two Pointers) has Pair Sum
     * Finding a Pair with a Given Sum (Sorted Array)
     */
    public static void hasPairWithSum() {
        System.out.println("\n(Two Pointers) has Pair with Sum ==> ");
        int[] nums = { 1, 2, 3, 5, 8, 10 };
        int target = 10;

        class Helper {
            boolean solution() {
                int left = 0, right = nums.length - 1;

                while (left < right) {
                    int sum = nums[left] + nums[right];
                    if (sum == target)
                        return true;

                    if (sum < target)
                        left++;
                    else
                        right--;
                }

                return false;
            }
        }

        Helper helper = new Helper();
        System.out.println(helper.solution());
    }

    /**
     * Given an array and an integer K, find the maximum for each and every
     * contiguous subarray of size K.
     */
    public static void maxSlidingWindowUsage() {
        int[] arr = { 2, 3, 7, 9, 5, 1, 6, 4, 3 };
        int k = 3;
        List<Integer> max_sliding_result = maxSlidingWindow(arr, k);
        System.out.println("max_sliding_result ==> " + max_sliding_result);
    }

    private static List<Integer> maxSlidingWindow(int arr[], int k) {
        List<Integer> ans = new ArrayList<>();
        TreeMap<Integer, Integer> treeMap = new TreeMap<>(Collections.reverseOrder());

        for (int i = 0; i < k; i++) {
            treeMap.put(arr[i], i);
        }

        ans.add(treeMap.firstKey());

        for (int i = k; i < arr.length; i++) {
            treeMap.put(arr[i], i);
            treeMap.remove(arr[i - k]);
            ans.add(treeMap.firstKey());
        }

        return ans;
    }
}
