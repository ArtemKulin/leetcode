package range_sum_of_bst;

public class Solution {
    private int result = 0;

    public int rangeSumBST(TreeNode root, int low, int high) {
        addToResult(root, low, high);
        return result;
    }

    private void addToResult(TreeNode node, int low, int high) {
        if (node != null) {
            if (low <= node.val && node.val <= high)
                result += node.val;
            if (low < node.val)
                addToResult(node.left, low, high);
            if (node.val < high)
                addToResult(node.right, low, high);
        }
    }
}