package minimum_rounds_to_complete_all_tasks;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;

import static java.util.stream.Collectors.toMap;

public class Solution {
    public int minimumRounds(int[] tasks) {
        Map<Integer, Integer> taskToCount = Arrays.stream(tasks)
                .boxed()
                .collect(toMap(Function.identity(), it -> 1, Integer::sum));

        int result = 0;
        for (int counter : taskToCount.values()) {
            if (result == -1 || counter == 1) {
                result = -1;
                break;
            }

            if (counter == 2) {
                result++;
                continue;
            }

            switch (counter % 3) {
                case 0 -> {
                    while (counter != 0) {
                        counter -= 3;
                        result++;
                    }
                }
                case 1 -> {
                    while (counter != 1) {
                        counter -= 3;
                        result++;
                    }
                    result++;
                }
                case 2 -> {
                    while (counter != 2) {
                        counter -= 3;
                        result++;
                    }
                    result++;
                }
                default -> result = -1;
            }
        }
        return result;
    }
}