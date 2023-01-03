package delete_columns_to_make_sorted;

public class Solution {
    public int minDeletionSize(String[] strs) {
        int res = 0;
        int length = strs.length;
        int width = strs[0].length();
        for (int i = 0; i < width; i++) {
            char pre = strs[0].charAt(i);
            for (int j = 1; j < length; j++) {
                if (pre > strs[j].charAt(i)) {
                    res++;
                    break;
                }
                pre = strs[j].charAt(i);
            }
        }
        return res;
    }
}