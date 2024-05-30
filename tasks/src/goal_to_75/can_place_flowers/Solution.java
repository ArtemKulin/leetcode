package goal_to_75.can_place_flowers;

public class Solution {
    
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (flowerbed.length == 1 && flowerbed[0] == 0) {
            return true;
        }
        
        int count = 0;
        for (int i = 0; i < flowerbed.length - 1; i++) {
            if (i == 0 && flowerbed[i] == 0 && flowerbed[i + 1] == 0) {
                count++;
                flowerbed[i] = 1;
            }
            if (flowerbed[i] == 0
              && flowerbed[i + 1] == 0
            ) {
                count++;
                flowerbed[i + 1] = 1;
            }
            if (flowerbed[i] == 1
              && flowerbed[i + 1] == 1) {
                count--;
            }
        }
        return count >= n;
    }
}