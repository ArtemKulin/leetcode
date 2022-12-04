package first_missing_positive;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Solution {
    public int firstMissingPositive(int[] nums) {
        Set<Integer> collect = Arrays
                .stream(nums)
                .boxed()
                .collect(Collectors.toCollection(TreeSet::new));
        int counter = 1;
        while (counter < Integer.MAX_VALUE) {
            if (!collect.contains(counter)) {
                break;
            }
            counter++;
        }
        return counter;
    }
}

