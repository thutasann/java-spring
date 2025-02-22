package KeyPatterns.Hashes.HashMap.java;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeating {
    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(longestSubString(s));
    }

    private static int longestSubString(String s) {
        Map<Character, Integer> charMap = new HashMap<>();
        int maxLength = 0, left = 0;

        for (int right = 0; right < s.length(); right++) {
            if (charMap.containsKey(s.charAt(right))) {
                left = Math.max(left, charMap.getOrDefault(s.charAt(right), 0) + 1);
            }
            charMap.put(s.charAt(right), right);
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}
