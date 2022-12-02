package determine_if_two_strings_are_close;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Solution {
    public boolean closeStrings(String word1, String word2) {
        return compareMaps(collectToMap(word1), collectToMap(word2));
    }

    private boolean compareMaps(Map<String, Integer> map1, Map<String, Integer> map2) {
        if (map1.keySet().equals(map2.keySet())) {
            return sortedValues(map1.values()).equals(sortedValues(map2.values()));
        } else {
            return false;
        }
    }

    private Map<String, Integer> collectToMap(String word) {
        return word
                .codePoints()
                .mapToObj(c -> String.valueOf((char)c))
                .collect(Collectors.toMap(String::valueOf, i -> 1, Integer::sum));
    }

    private List<Integer> sortedValues(Collection<Integer> values) {
        return values
                .stream()
                .sorted()
                .toList();
    }
}
