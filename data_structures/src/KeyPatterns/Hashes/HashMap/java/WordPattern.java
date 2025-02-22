package KeyPatterns.Hashes.HashMap.java;

import java.util.HashMap;
import java.util.Map;

/**
 * Word Pattern
 * - Given a pattern string `pattern` and a string `s`, determine if `s` follows
 * the same pattern.
 * - Each letter in `pattern` maps to exactly one unique word in `s`.
 * - Each unique word in `s` maps to exactly one letter in `pattern`.
 * 
 * ## Example
 * - Input: pattern = "abba", s = "dog cat cat dog"
 * - 'a' -> "dog"
 * - 'b' -> "cat"
 * - 'b' -> "cat"
 * - 'a' -> "dog" // consistent
 */
public class WordPattern {
    public static void main(String[] args) {
        System.out.println(wordPattern("abba", "dog cat cat dog"));
    }

    private static boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        if (pattern.length() != words.length) {
            return false;
        }

        Map<Character, String> charToWord = new HashMap<>();
        Map<String, Character> wordToChar = new HashMap<>();

        for (int i = 0; i < pattern.length(); i++) {
            char ch = pattern.charAt(i);
            String word = words[i];

            if (charToWord.containsKey(ch) && !charToWord.get(ch).equals(word)) {
                return false;
            }
            if (wordToChar.containsKey(word) && wordToChar.get(word) != ch) {
                return false;
            }

            charToWord.put(ch, word);
            wordToChar.put(word, ch);
        }

        return true;
    }
}
