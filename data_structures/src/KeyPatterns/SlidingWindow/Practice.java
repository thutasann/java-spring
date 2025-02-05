package KeyPatterns.SlidingWindow;

import java.util.ArrayList;
import java.util.Arrays;
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
        mergeTwoSortedArrays();
        moveZeroToEnd();
        System.out.println("\n(Two Pointers) TwoSum Sorted ==> " + Arrays.toString(TwoSumSorted()));
    }

    /**
     * (Two Pointers) Two Sum Sorted
     */
    public static int[] TwoSumSorted() {
        System.out.println("\n(Two Pointers) TwoSum Sorted");
        int[] nums = { 1, 2, 3, 5, 8, 10 };
        int target = 10;
        int left = 0, right = nums.length - 1;

        while (left < right) {
            int sum = nums[left] + nums[right];

            if (sum == target) {
                return new int[] { nums[left], nums[right] };
            }

            if (sum < target) {
                left++;
            } else {
                right--;
            }
        }

        return new int[] { -1, -1 };
    }

    /**
     * (Two Pointers) Move Zeros to End
     */
    public static void moveZeroToEnd() {
        System.out.println("\n(Two Pointers) Move Zeros to End ==> ");
        int[] nums = { 0, 1, 0, 3, 12 };
        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            if (nums[right] != 0) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
            }
        }
        System.out.println(Arrays.toString(nums));
    }

    /**
     * (Two Pointers) Merge Two Sorted Arrays
     */
    public static void mergeTwoSortedArrays() {
        System.out.println("\n(Two Pointers)Merge Two Sorted Arrays");
        int[] nums1 = { 1, 3, 5 };
        int[] nums2 = { 2, 4, 6 };

        class Helper {
            static int[] merge(int[] nums1, int[] nums2) {
                int n = nums1.length, m = nums2.length;
                int[] result = new int[n + m];
                int i = 0, j = 0, k = 0;

                while (i < n && j < m) {
                    if (nums1[j] < nums2[j]) {
                        result[k++] = nums1[i++];
                    } else {
                        result[k++] = nums2[j++];
                    }
                }

                while (i < n) {
                    result[k++] = nums1[i++];
                }

                while (j < m) {
                    result[k++] = nums2[j++];
                }

                return result;
            }
        }
        System.out.println(Arrays.toString(Helper.merge(nums1, nums2)));
    }

    /**
     * (Two Pointers) Remove Duplicates
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

        class Helper {
            static List<Integer> maxSlidingWindow(int arr[], int k) {
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

        List<Integer> max_sliding_result = Helper.maxSlidingWindow(arr, k);
        System.out.println("max_sliding_result ==> " + max_sliding_result);
    }

}
