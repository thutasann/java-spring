package SearchAlgorithms;

public class SearchAlgorithmsUsages {

    private SearchAlgorithms searchAlgorithms = new SearchAlgorithms();

    public void linearSearchUsage() {
        System.out.println("\n==> Linear Search Usage ");
        int[] array = { 9, 1, 8, 2, 7, 3, 6, 4, 5 };
        int index = this.searchAlgorithms.linearSearch(array, 1);
        System.out.println("Result --> " + index);
    }
}
