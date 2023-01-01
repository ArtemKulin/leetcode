package word_pattern;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public boolean wordPattern(String pattern, String s) {
        Map<Character, String> charToStr = new HashMap<>();
        Map<String, Character> strToChar = new HashMap<>();
        String[] arr = s.split(" ");
        if (pattern.length() != arr.length) {
           return false;
        }

        for (int i = 0; i < pattern.length(); i++) {
            char ch = pattern.charAt(i);
            String word = arr[i];

            if (!charToStr.containsKey(ch)) {
                charToStr.put(ch, word);
            }

            if (!strToChar.containsKey(word)) {
                strToChar.put(word, ch);
            }

            if (!charToStr.get(ch).equals(word) || !strToChar.get(word).equals(ch)) {
                return false;
            }
        }
        return true;
    }
}