package KeyPatterns.SlidingWindow;

import java.util.Arrays;

public class SlidingWindow {
    /**
     * Sliding Window
     */
    public static void Examples() {
        System.out.println("\nSliding Window");
        PrintSubArrays();
        SubArrayExtractInJava();
        PrintSubString();
        ExtractSubString();
        WindowSlideSample();
        maxSumTwoNestedLoop();
        maxSumOptmized();
        VariableSizedSlideWindow.Examples();
    }

    public static void maxSumOptmized() {
        System.out.println("\nMax Sum Optimized ==> ");
        int[] arr = { 1, 4, 2, 10, 2, 3, 1, 0, 20 };
        int k = 4;
        int n = arr.length;

        if (n <= k) {
            System.out.println("Invalid");
        }

        int max_sum = 0;
        for (int i = 0; i < k; i++) {
            max_sum += arr[i];
        }

        int window_sum = max_sum;
        for (int i = k; i < n; i++) {
            window_sum += arr[i] - arr[i - k];
            max_sum = Math.max(max_sum, window_sum);
        }
        System.out.println("maxSum ==> " + max_sum);
    }

    /**
     * [1, 4, 2, 10] => 17 => 17 > Integer.MIN_VALUE
     * [4, 2, 10, 2] => 18 => 18 > 17
     * [2, 10, 2, 3] => 18 => 17 < 18
     * [10, 2, 3, 1] => 16 => 16 < 18
     * [2, 3, 1, 0] => 6 => 6 < 18
     * [3, 1, 0, 20] => 24 => 24 > 18
     */
    public static void maxSumTwoNestedLoop() {
        System.out.println("\nMax Sum Two Nested Loop ==> ");
        int[] arr = { 1, 4, 2, 10, 2, 3, 1, 0, 20 };
        int k = 4;
        int n = arr.length;

        int maxSum = Integer.MIN_VALUE;

        // 9 - 4 + 1 = 6;
        for (int i = 0; i < n - k + 1; i++) {
            int currentSum = 0;
            for (int j = 0; j < k; j++) {
                currentSum = currentSum + arr[i + j];
            }
            maxSum = Math.max(currentSum, maxSum);
        }

        System.out.println("maSum ==> " + maxSum);
    }

    /** Window Slide Sample */
    public static void WindowSlideSample() {
        System.out.println("\nWindow Slide Sample ==> ");
        int[] arr = { 1, 2, 3, 4, 5 };
        int k = 3;

        int n = arr.length;
        if (n < k) {
            return;
        }

        // Initialize window
        System.out.println("Initialize Window : ");
        for (int i = 0; i < k; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        // Slide the window
        for (int i = k; i < n; i++) {
            System.out.println("Slide: Remove " + arr[i - k] + ", Add " + arr[i]);
        }

        System.out.println("Window Sliding complete.");
    }

    /** Find Maximum Sum SubArray */
    public static void findMaxSumSubArray() {
        System.out.println("\nFind Max Sum of a SubArray");
        int[] arr = { 2, 1, 5, 0, 1, 2, 3, 0, 2, 1 };
        int subArraySize = 3;

        int maxSum;
        int windowSum = 0;

        for (int i = 0; i < subArraySize; i++) {
            windowSum += arr[i];
        }
        maxSum = windowSum;

        for (int i = subArraySize; i < arr.length; i++) {
            windowSum += arr[i] - arr[i - subArraySize];
            maxSum = Math.max(maxSum, windowSum);
        }
        System.out.println("maxSum ==> " + maxSum);
    }

    /**
     * arr = [1,2,3]
     * [1], [2], [3]
     * [1,2], [2,3], [1,2,3]
     * [1,3] is not a subarray (because its not contiguous)
     */
    public static void PrintSubArrays() {
        System.out.println("\nSub Arrrays ==> ");
        int[] arr = { 1, 2, 3 };
        int n = arr.length;
        for (int start = 0; start < n; start++) {
            for (int end = start; end < n; end++) {
                for (int i = start; i <= end; i++) {
                    System.out.print(arr[i] + " ");
                }
                System.out.println();
            }
        }
    }

    /** Sub Array Extract in Java */
    public static void SubArrayExtractInJava() {
        System.out.println("\nSub Arrray Extract in Java ==> ");
        int[] arr = { 1, 2, 3, 4, 5 };
        int[] subArr = Arrays.copyOfRange(arr, 1, 4);
        System.out.println(Arrays.toString(subArr));
    }

    /** Print SubString */
    public static void PrintSubString() {
        System.out.println("\nPrint SubString ==> ");
        char[] str = { 'a', 'b', 'c' };
        int n = str.length;

        for (int start = 0; start < n; start++) {
            for (int end = start; end < n; end++) {
                for (int i = 0; i <= end; i++) {
                    System.out.print(str[i]);
                }
                System.out.println();
            }
        }
    }

    /** Extract SubString */
    public static void ExtractSubString() {
        System.out.println("\nExtract SubString ==> ");

        class Helper {
            char[] extract(char[] str, int start, int end) {
                char[] subStr = new char[end - start];
                int index = 0;
                for (int i = start; i < end; i++) {
                    subStr[index++] = str[i];
                }
                return subStr;
            }
        }

        Helper helper = new Helper();
        char str[] = { 'h', 'e', 'l', 'l', 'o' };
        char[] substr = helper.extract(str, 1, 4);
        for (char c : substr) {
            System.out.print(c + "\n");
        }
    }
}
