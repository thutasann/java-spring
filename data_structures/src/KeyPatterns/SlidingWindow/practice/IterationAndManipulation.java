package KeyPatterns.SlidingWindow.practice;

public class IterationAndManipulation {
    public static void main(String[] args) {
        System.out.println("\n Iteration and Manipulation");
        fixedWindowSize();
        maxSumSubarray();
        minSumSubArray();
    }

    public static void minSumSubArray() {
        System.out.println("\nMin Sum Subarray ==> ");
        int[] arr = { 2, 1, 5, 1, 3, 2 };
        int k = 3;
        int minSum = 0;
        int windowSum = 0;
        for (int i = 0; i < k; i++) {
            windowSum += arr[i];
        }
        minSum = windowSum;

        for (int windowStart = 1; windowStart <= arr.length - k; windowStart++) {
            windowSum = windowSum - arr[windowStart - 1] + arr[windowStart + k - 1];
            minSum = Math.min(minSum, windowSum);
        }

        System.out.println("minSum ==> " + minSum);
    }

    /**
     * - Initial window (windowStart = 0): [2,1,5] ==> Initial Sum = 8
     * - First Slide (Window Start = 1):
     * - Remove `arr[0]` (2) from the sum.
     * - Add `arr[3]` (1) to the sum, which is arr[1 + 3 - 1]
     * - New Window [1, 5, 1] with sum `1 + 5 + 1 = 7`
     * 
     * - Second Slide (Window Start = 2):
     * - Remove `arr[1]` (1) from the sum.
     * - Add `arr[4]` (3) to the sum.
     * - New Widnow [5, 1, 3] with sum = `5 + 1 + 3 = 9`
     */
    public static void maxSumSubarray() {
        System.out.println("\nMax Sum Subarray ==> ");
        int[] arr = { 2, 1, 5, 1, 3, 2 };
        int k = 3;
        int maxSum = 0;
        int windowSum = 0;

        for (int i = 0; i < k; i++) {
            windowSum += arr[i];
        }
        maxSum = windowSum;

        for (int windowStart = 1; windowStart <= arr.length - k; windowStart++) {
            windowSum = windowSum - arr[windowStart - 1] + arr[windowStart + k - 1];
            maxSum = Math.max(maxSum, windowSum);
        }

        System.out.println("Max Sum ==> " + maxSum);
    }

    /**
     * `arr.length - k` ensures that the window does not extend beyond the bounds of
     * the array.
     */
    public static void fixedWindowSize() {
        System.out.println("\nFixed window Size ==>");
        int[] arr = { 1, 3, 5, 7, 9, 11, 13 };
        int k = 3;

        for (int windowStart = 0; windowStart <= arr.length - k; windowStart++) {
            int windowSum = 0;

            for (int i = windowStart; i < windowStart + k; i++) {
                windowSum += arr[i];
            }

            System.out.println("Sum of the window starting at index " + windowStart + ": " + windowSum);
        }
    }
}