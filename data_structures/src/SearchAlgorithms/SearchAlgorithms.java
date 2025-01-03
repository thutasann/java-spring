package SearchAlgorithms;

/**
 * Search Algorithms
 */
public class SearchAlgorithms {
    /**
     * Linear Search
     * 
     * @param array
     * @param value
     */
    public int linearSearch(int[] array, int value) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == value) {
                return i;
            }
        }
        return -1;
    }
}
