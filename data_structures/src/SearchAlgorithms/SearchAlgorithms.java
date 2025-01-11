package SearchAlgorithms;

/**
 * Search Algorithms
 */
public class SearchAlgorithms {
    /**
     * Linear Search
     */
    public int linearSearch(int[] array, int value) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == value) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Binary Search
     */
    public int binarySearch(int[] array, int target) {
        int low = 0;
        int high = array.length - 1;

        while (low <= high) {
            int middle = low + (high - low) / 2;
            int value = array[middle];
            System.out.println("middle : " + middle);

            if (value < target) {
                low = middle + 1;
            } else if (value > target) {
                high = middle - 1;
            } else {
                return middle;
            }
        }

        return -1;
    }

    /**
     * Interpolation Search
     */
    public int interpolationSearch(int[] array, int target) {

        int high = array.length - 1;
        int low = 0;

        while (target >= array[low] && target <= array[high] && low <= high) {
            int probe = low + (high - low) * (target - array[low]) /
                    (array[high] - array[low]);
            System.out.println("probe ==> " + probe);

            if (array[probe] == target) {
                return probe;
            } else if (array[probe] < target) {
                low = probe + 1;
            } else {
                high = probe - 1;
            }
        }

        return -1;
    }
}
