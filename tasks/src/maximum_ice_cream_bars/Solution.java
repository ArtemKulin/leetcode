package maximum_ice_cream_bars;

import java.util.Arrays;

public class Solution {
    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        int result = 0;
        for (int cost : costs) {
            coins -= cost;
            if (coins >= 0) {
                result++;
            } else {
                break;
            }
        }
        return result;
    }
}