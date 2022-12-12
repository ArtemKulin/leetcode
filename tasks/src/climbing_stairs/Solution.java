package climbing_stairs;

public class Solution {
    public int climbStairs(int n) {
        if (n <= 1) {
            return 1;
        }

        int rewindTwo = 1;
        int rewindOne = 2;
        int count = 2;

        for (int i = 2; i < n; i++) {
            count = rewindTwo + rewindOne;
            rewindTwo = rewindOne;
            rewindOne = count;
        }

        return count;
    }
}