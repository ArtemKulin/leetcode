package valid_palindrome;

import java.util.Locale;

public class Solution {
    public boolean isPalindrome(String s) {
        if (s.isEmpty()) {
            return true;
        }

        String onlyLetters = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        char[] chars = onlyLetters.toCharArray();
        int lastIndex = chars.length - 1;
        boolean result = true;
        for (int i = 0; i < chars.length; i++) {
            if(chars[i] != chars[lastIndex - i]) {
                result = false;
                break;
            }
        }
        return result;
    }
}