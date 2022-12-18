package daily_temperatures;

import java.util.Arrays;

public class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];
        for (int i = temperatures.length - 2; i >= 0; i--) {
            int next = i + 1;
            while (next < temperatures.length && temperatures[next] <= temperatures[i]) {
                if (res[next] == 0) {
                    next = temperatures.length;
                    break;
                }
                next += res[next];
            }
            if (next < temperatures.length) res[i] = next - i;
        }
        return res;
    }
}