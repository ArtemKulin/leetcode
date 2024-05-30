package goal_to_75.merge_strings_alternately;

public class Solution {
    
    public String mergeAlternately(String word1, String word2) {
        var sb = new StringBuilder();
        var length = Math.min(word1.length(), word2.length());
        for (int i = 0; i < length; i++) {
            sb.append(word1.charAt(i));
            sb.append(word2.charAt(i));
        }
        if (word1.length() > word2.length()) {
            while (length < word1.length()) {
                sb.append(word1.charAt(length));
                length++;
            }
        } else {
            while (length < word2.length()) {
                sb.append(word2.charAt(length));
                length++;
            }
        }
        return sb.toString();
    }
}
