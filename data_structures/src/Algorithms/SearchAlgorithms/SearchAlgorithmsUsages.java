package Algorithms.SearchAlgorithms;

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

    public void interpolationSearchUsage() {
        System.out.println("\n==> Interpolation Search Usage ");
        int[] array = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        int index = this.searchAlgorithms.interpolationSearch(array, 8);
        System.out.println("index ==> " + index);
    }
}
