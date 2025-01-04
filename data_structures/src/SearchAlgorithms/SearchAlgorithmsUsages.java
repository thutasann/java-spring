package SearchAlgorithms;

public class SearchAlgorithmsUsages {

    private SearchAlgorithms searchAlgorithms = new SearchAlgorithms();

    public void linearSearchUsage() {
        System.out.println("\n==> Linear Search Usage ");
        int[] array = { 9, 1, 8, 2, 7, 3, 6, 4, 5 };
        int index = this.searchAlgorithms.linearSearch(array, 1);
        System.out.println("Result --> " + index);
    }

    public void binarySearchUsage() {
        System.out.println("\n==> Binary Search Usage ");
        int array[] = new int[10000];
        int target = 55;

        for (int i = 0; i < array.length; i++) {
            array[i] = i;
        }

        int index = this.searchAlgorithms.binarySearch(array, target);
        System.out.println("Result --> " + index);
    }
}
