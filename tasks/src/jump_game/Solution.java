package jump_game;

public class Solution {
    public boolean canJump(int[] nums) {
        if(nums == null || nums.length == 0) return false;
        if(nums.length == 1) return true;

        int end = nums.length - 1;
        for(int i = nums.length - 2; i >= 0; i--) {
            int steps = end - i;
            if(nums[i] >= steps) {
                end = i;
            }
        }
        if (end == 0) return true;
        else return false;
    }
}