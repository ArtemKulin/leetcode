package leaf_similar_trees;

public class Solution {
    StringBuilder first = new StringBuilder();
    StringBuilder second = new StringBuilder();

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        addValuesToSum(first, root1);
        addValuesToSum(second, root2);
        return first.toString().equals(second.toString());
    }

    private void addValuesToSum(StringBuilder sb, TreeNode root) {
        if (root != null) {
            if (root.left == null && root.right == null) {
                sb.append(root.val);
            } else if (root.right == null) {
                addValuesToSum(sb, root.left);
            } else if (root.left == null) {
                addValuesToSum(sb, root.right);
            } else {
                addValuesToSum(sb, root.right);
                addValuesToSum(sb, root.left);
            }
        }
    }
}
