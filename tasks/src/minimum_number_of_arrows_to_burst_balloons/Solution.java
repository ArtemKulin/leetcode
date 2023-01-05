package minimum_number_of_arrows_to_burst_balloons;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public int findMinArrowShots(int[][] points) {
        // Sort the balloons by the end position of the arrow
        Arrays.sort(points, Comparator.comparingInt(a -> a[1]));

        // Initialize the number of arrows needed to 1
        int result = 1;
        // Set the index of the previously burst balloon to 0
        int previous = 0;

        // Iterate through all balloons
        for(int current = 1; current < points.length; current++){
            // If the start position of the current balloon is after the end position of the arrow that burst the previous balloon,
            // then a new arrow is needed to burst the current balloon
            if(points[current][0] > points[previous][1]){
                result++;
                // Update the index of the previously burst balloon
                previous = current;
            }
        }
        return result;
    }
}
