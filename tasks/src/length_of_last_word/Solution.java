package length_of_last_word;

public class Solution {
    public int lengthOfLastWord(String s) {
        String[] strings = s.split(" ");
        int lastWord = strings.length - 1;
        return strings[lastWord].length();
    }
}
