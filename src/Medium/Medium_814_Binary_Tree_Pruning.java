// 814. Binary Tree Pruning
package Medium;
import java.util.Objects;

public class Medium_814_Binary_Tree_Pruning {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    private static boolean hasOne(TreeNode root) {
        if (root == null) return false;
        if (root.val == 1) return true;
        return hasOne(root.left) || hasOne(root.right);
    }
    private static void dfs(TreeNode root) {
        if(root == null) return;
        if (!hasOne(root.left))
            root.left = null;
        if (!hasOne(root.right))
            root.right = null;

        dfs(root.left);
        dfs(root.right);
    }
    public static TreeNode pruneTree(TreeNode root) {
        dfs(root);
        if(root.left == null && root.right == null && root.val == 0)
            return null;
        return root;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = null;
        root.right = new TreeNode(0);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(1);
        System.out.println(Objects.requireNonNull(pruneTree(root)).val);
    }
}
