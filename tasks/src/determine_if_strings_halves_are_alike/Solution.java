package determine_if_strings_halves_are_alike;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public boolean halvesAreAlike(String s) {
        int firstCounter = 0;
        int secondCounter = 0;
        List<Character> chars = new ArrayList<>();
        chars.add('a');
        chars.add('e');
        chars.add('i');
        chars.add('o');
        chars.add('u');

        String first = s.substring(0, s.length()/2).toLowerCase();
        String second = s.substring(s.length()/2).toLowerCase();
        for (int i = 0; i < first.length(); i++) {
            if (chars.contains(first.charAt(i))) {
                firstCounter++;
            }
            if (chars.contains(second.charAt(i))) {
                secondCounter++;
            }
        }
        return firstCounter == secondCounter;
    }
}
