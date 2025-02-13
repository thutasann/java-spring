package KeyPatterns.SlidingWindow.leetcodes.easy;

/**
 * Maximum Number of Vowels in a Substring of Given Length
 * Given a string s and an integer k, return the maximum number of vowel letters
 * in any substring of s with length k.
 */
public class MaximumVowelsInSubstring {
    public static void main() {
        String s = "abciiidef";
        int k = 3;
        System.out.println("\nMaximum Number of Vowels ==> " + maxVowels(s, k));
    }

    public static int maxVowels(String s, int k) {
        int maxVowels = 0, currentVowels = 0;
        int n = s.length();

        for (int i = 0; i < k; i++) {
            if (isVowel(s.charAt(i))) {
                currentVowels++;
            }
        }

        maxVowels = currentVowels;

        for (int i = k; i < n; i++) {
            if (isVowel(s.charAt(i))) {
                currentVowels++;
            }

            if (isVowel(s.charAt(i - k))) {
                currentVowels--;
            }

            maxVowels = Math.max(maxVowels, currentVowels);
        }

        return maxVowels;
    }

    private static boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}
