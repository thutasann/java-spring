package neetcode_150.src;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given an array of strings `strs`, group the anagrams together.
 * You can return the answer in any order.
 */
public class GroupAnagrams {
    public static void main(String[] args) {
        System.out.println("\nGroup Anagrams ==> ");
        String[] strs = { "eat", "tea", "tan", "ate", "nat", "bat" };
        List<List<String>> ans = groupAnagrams(strs);
        System.out.println(ans);
    }

    private static List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0) {
            return new ArrayList<>();
        }

        Map<String, List<String>> ansMap = new HashMap<>();
        int[] count = new int[26];

        for (String s : strs) {
            Arrays.fill(count, 0);
            for (char c : s.toCharArray()) {
                count[c - 'a']++;
            }

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 26; i++) {
                sb.append("#").append(count[i]);
            }
            String key = sb.toString();

            ansMap.putIfAbsent(key, new ArrayList<>());
            ansMap.get(key).add(s);
        }

        return new ArrayList<>(ansMap.values());
    }
}
