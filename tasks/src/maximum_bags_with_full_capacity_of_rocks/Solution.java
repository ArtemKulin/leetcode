package maximum_bags_with_full_capacity_of_rocks;

import java.util.Arrays;

public class Solution {
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        int result = 0;

        int[] temp = new int[capacity.length];
        for (int i = 0; i < capacity.length; i++) {
            temp[i] = capacity[i] - rocks[i];
        }
        Arrays.sort(temp);
        for (int j : temp) {
            additionalRocks = additionalRocks - j;
            if (additionalRocks < 0) {
                break;
            } else {
                result++;
            }
        }
        return result;
    }
}
