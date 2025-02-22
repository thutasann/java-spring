package KeyPatterns.Hashes.HashMap.java;

import java.util.HashMap;
import java.util.Map;

/**
 * Isomorphic Strings
 * - Two Strings `s` and `t` are isomorphic
 * - if characters in `s` can be replaced to get `t`
 */
public class IsomorphicStrings {
    public static void main(String[] args) {
        System.out.println(isIsomorphic("egg", "add"));
    }

    private static boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Character> sToT = new HashMap<>();
        Map<Character, Character> tTos = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char sc = s.charAt(i);
            char tc = t.charAt(i);

            if (sToT.containsKey(sc) && sToT.get(sc) != tc)
                return false;
            if (tTos.containsKey(tc) && tTos.get(tc) != sc)
                return false;

            sToT.put(sc, tc);
            tTos.put(tc, sc);
        }

        return true;
    }
}
