package neetcode_150.src;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Design an algorithm to encode a list of strings to a string.
 * The encoded string is then sent over the network and is decoded back to the
 * original list of strings.
 */
public class EncodeDecodeString {
    public static void main(String[] args) {
        List<String> original = Arrays.asList("hello", "world", "java", "encoding");

        String encoded = encode(original);
        System.out.println("Encoded: " + encoded);

        List<String> decoded = decode(encoded);
        System.out.println("Decoded: " + decoded);
    }

    public static String encode(List<String> strs) {
        if (strs.size() == 0) {
            return Character.toString((char) 258);
        }
        String separate = Character.toString((char) 257);
        StringBuilder sb = new StringBuilder();
        for (String s : strs) {
            sb.append(s);
            sb.append(separate);
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    public static List<String> decode(String s) {
        if (s.equals(Character.toString((char) 258))) {
            return new ArrayList<>();
        }
        String separate = Character.toString((char) 257);
        return Arrays.asList(s.split(separate, -1));
    }
}
