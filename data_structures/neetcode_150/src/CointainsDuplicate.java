package neetcode_150.src;

import java.util.HashSet;

public class CointainsDuplicate {
    public static void main(String[] arg) {
        System.out.println("\nContains Duplicate =====> ");
        int[] nums = { 1, 2, 3, 1 };
        System.out.println(containDuplicates(nums));
    }

    private static boolean containDuplicates(int[] nums) {
        HashSet<Integer> seenNumbers = new HashSet<>();

        for (int num : nums) {
            if (seenNumbers.contains(num)) {
                return true;
            }
            seenNumbers.add(num);
        }
        return false;
    }
}
