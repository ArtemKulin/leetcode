import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Write a function to find the longest common prefix string amongst an array of strings.
 *
 * If there is no common prefix, return an empty string "".
 *
 *
 *
 * Example 1:
 *
 * Input: strs = ["flower","flow","flight"]
 * Output: "fl"
 * Example 2:
 *
 * Input: strs = ["dog","racecar","car"]
 * Output: ""
 * Explanation: There is no common prefix among the input strings.
 *
 *
 * Constraints:
 *
 * 1 <= strs.length <= 200
 * 0 <= strs[i].length <= 200
 * strs[i] consists of only lower-case English letters.
 */


public class LongestCommonPrefix {

    public static void main(String[] args) {
        String str1 = "cir";
        String str2 = "car";
        //String str3 = "cat";


        String[] arr = {str1, str2};
        System.out.println(findLowerString(arr));
        System.out.println(longestCommonPrefix(arr));

    }


    public static String longestCommonPrefix(String[] strs) {
        String lowerString = findLowerString(strs);
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < lowerString.length(); i++) {
            int counter = 0;
            for (String str : strs) {
                if (str.charAt(i) == lowerString.charAt(i)) {
                    counter++;
                }
            }
            if (counter == strs.length) {
                result.append(lowerString.charAt(i));
            } else {
                break;
            }
        }
        return result.toString();
    }

    public static String findLowerString(String[] strs) {
        Map<Integer, String> map = new HashMap<>();
        Arrays.stream(strs).forEach(el -> map.put(el.length(), el));
        int count = Integer.MAX_VALUE;
        for(Integer key: map.keySet()) {
            if (key < count) {
                count = key;
            }
        }
        return map.get(count);
    }
}
