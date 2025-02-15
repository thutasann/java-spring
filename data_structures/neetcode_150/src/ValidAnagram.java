package neetcode_150.src;

/**
 * Valid Anagram
 * ## Example one
 * s: cat, t: tac ==> true
 * 
 * ## Example Two
 * s: sam, t: sat ==> false
 */
public class ValidAnagram {
    public static void main(String[] args) {
        System.out.println("\nValid Anagram ==> ");
        System.out.println(isValidAnagram("cat", "tac"));
    }

    private static boolean isValidAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] charCounts = new int[26];

        for (int i = 0; i < s.length(); i++) {
            charCounts[s.charAt(i) - 'a']++;
            charCounts[t.charAt(i) - 'a']--;
        }

        for (int count : charCounts) {
            if (count != 0) {
                return false;
            }
        }

        return true;
    }
}
