package KeyPatterns.SlidingWindow.practice;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class IterationAndManipulation {
    public static void main(String[] args) {
        System.out.println("\n Iteration and Manipulation");
        fixedWindowSize();
        maxSumSubarray();
        minSumSubArray();
        averageOfSubarrays();
        countCharacterInWindows();
        averageTemperature();
        maxProductSubarray();
        slidingWindowMaximum();
        stockAnalysis();
        airQualityMeasure();
    }

    /**
     * - System receives AQI (Air Quality Index) every hour
     * - Calculate the maximum AQI over a sliding window of 3 hours to provide
     * timely alarts when air quality deteriorates significantly.
     */
    public static void airQualityMeasure() {
        System.out.println("\nAir Quanity Measure ==> ");
        int[] aqiReadings = { 50, 55, 60, 65, 70, 75, 80, 85, 90, 95, 100 };
        int k = 3;
        int threshold = 80;
        int[] maxAqiWindow = new int[aqiReadings.length - k + 1];
        int windowMax = Integer.MIN_VALUE;

        for (int windowStart = 0; windowStart <= aqiReadings.length - k; windowStart++) {
            for (int i = windowStart; i < windowStart + k; i++) {
                windowMax = Math.max(windowMax, aqiReadings[i]);
            }
            maxAqiWindow[windowStart] = windowMax;

            if (windowMax > threshold) {
                System.out.println("Alert: High AQI of " + windowMax + " detected from hour " + (windowStart + 1)
                        + " to hour " + (windowStart + k));
            }
        }
    }

    /**
     * - Initialize a result array to store the maximum prices for each window.
     * - Use a loop to slide a window of size `k` (e.g., 3 days) across the array.
     * - For each position of the window, determine the maximum price and store it
     * in the result array.
     * - Using a Deque to optimize the process of maintaining the maximum valus as
     * the window slides.
     */
    public static void stockAnalysis() {
        System.out.println("\nStock Analysis Sliding Window Maximum ==> ");
        int[] prices = { 1, 3, -1, -3, 5, 3, 6, 7 };
        int k = 3;
        Deque<Integer> deque = new ArrayDeque<>();
        int[] result = new int[prices.length - k + 1];

        for (int i = 0; i < prices.length; i++) {
            // remove elements not from the sliding window
            if (!deque.isEmpty() && deque.peek() < i - k + 1) {
                deque.poll();
            }

            // remove all elements smaller than the current element
            while (!deque.isEmpty() && prices[deque.peekLast()] < prices[i]) {
                deque.pollLast();
            }

            // add current element at the back of the queue
            deque.offer(i);

            if (i >= k - 1) {
                result[i - k + 1] = prices[deque.peek()];
            }
        }
        System.out.println("Maximum stock prices in each sliding window: " + Arrays.toString(result));
    }

    public static void slidingWindowMaximum() {
        System.out.println("\nSliding Window Maximum of Size K ==> ");
        int[] arr = { 1, 3, -1, -3, 5, 3, 6, 7 };
        int k = 3;
        int[] result = new int[arr.length - k];
        int maxIndex = -1;

        for (int windowStart = 0; windowStart < arr.length - k; windowStart++) {
            if (maxIndex < windowStart) {
                maxIndex = windowStart;
                for (int i = windowStart; i < windowStart + k; i++) {
                    if (arr[i] > arr[maxIndex]) {
                        maxIndex = i;
                    }
                }
            } else if (arr[windowStart + k - 1] > arr[maxIndex]) {
                maxIndex = windowStart + k - 1;
            }
            result[windowStart] = arr[maxIndex];
        }
        System.out.println("Maximum values in each sliding window: " + Arrays.toString(result));
    }

    public static void maxProductSubarray() {
        System.out.println("\nMaximum Product Subarray of Size k");
        int[] arr = { 1, 5, 2, 3, 7 };
        int k = 3;
        int maxProduct = Integer.MIN_VALUE;
        int windowProduct = 1;

        for (int i = 0; i < k; i++) {
            windowProduct *= arr[i];
        }
        maxProduct = windowProduct;

        for (int windowStart = 1; windowStart <= arr.length - k; windowStart++) {
            windowProduct = windowProduct / arr[windowStart - 1] * arr[windowStart + k - 1];
            maxProduct = Math.max(maxProduct, windowProduct);
        }

        System.out.println("Maximum product of subarray of size " + k + "is: " + maxProduct);
    }

    public static void averageTemperature() {
        System.out.println("\nAverage Temperature ==> ");
        double[] temperatures = { 73.4, 75.0, 71.8, 74.2, 76.3, 72.0, 69.8 };
        int k = 3;
        double[] result = { 73.4, 75.0, 71.8, 74.2, 76.3, 72.0, 69.8 };
        double windowSum = 0;

        for (int i = 0; i < k; i++) {
            windowSum += temperatures[i];
        }

        for (int windowStart = 0; windowStart <= temperatures.length - k; windowStart++) {
            result[windowStart] = windowSum / k;
            if (windowStart + k < temperatures.length) {
                windowSum = windowSum - temperatures[windowStart] + temperatures[windowStart + k];
            }
        }

        System.out.println("Average temperatures over " + k + " days: " + Arrays.toString(result));
    }

    public static void countCharacterInWindows() {
        System.out.println("\nCount character in windows ==> ");
        String str = "aabcdaaeef";
        char target = 'a';
        int k = 4;
        int[] result = new int[str.length() - k + 1];
        int count = 0;

        for (int i = 0; i < k; i++) {
            if (str.charAt(i) == target) {
                count++;
            }
        }

        for (int windowStart = 0; windowStart <= str.length() - k; windowStart++) {
            result[windowStart] = count;

            // Checks if the character entering the right end of the window is the target
            if (windowStart + k < str.length() && str.charAt(windowStart + k) == target) {
                count++;
            }

            // Checks if the character leaving the left end of the window is the target.
            if (str.charAt(windowStart) == target) {
                count--;
            }
        }
        System.out.println(
                "Occurrences of '" + target + "' in each window of size " + k + ": " + Arrays.toString(result));
    }

    public static void averageOfSubarrays() {
        System.out.println("\nAverage of sub arrays ==> ");
        int[] arr = { 1, 3, 2, 6, -1, 4, 1, 8, 2 };
        int k = 5;
        double[] result = new double[arr.length - k + 1];
        int windowSum = 0;

        for (int i = 0; i < k; i++) {
            windowSum += arr[i];
        }

        for (int windowStart = 1; windowStart <= arr.length - k; windowStart++) {
            result[windowStart] = windowSum / k;
            if (windowStart + k < arr.length) {
                windowSum = windowSum - arr[windowStart] + arr[windowStart + k];
            }
        }

        System.out.println("Averages of subarrays of size " + k + ": " + Arrays.toString(result));

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