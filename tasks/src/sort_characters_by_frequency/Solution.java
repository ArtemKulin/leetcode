package sort_characters_by_frequency;

import java.util.Comparator;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class Solution {
    public String frequencySort(String s) {
        StringBuilder result = new StringBuilder();
        s
                .codePoints()
                .mapToObj(c -> String.valueOf((char) c))
                .collect(Collectors.toMap(String::valueOf, i -> 1, Integer::sum))
                .entrySet()
                .stream()
                .sorted(Entry.comparingByValue(Comparator.reverseOrder()))
                .forEach(value -> result.append(value.getKey().repeat(value.getValue())));
        return result.toString();
    }
}