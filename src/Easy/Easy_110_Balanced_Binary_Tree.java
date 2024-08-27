// 110. Balanced Binary Tree
package Easy;

public class Easy_110_Balanced_Binary_Tree {
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
    public static boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        return checkForBalance(root) != -1;
    }
    private static int checkForBalance(TreeNode root) {
        if (root == null) return 0;
        int leftHeight = checkForBalance(root.left);
        int rightHeight = checkForBalance(root.right);

        if (leftHeight == -1 || rightHeight == -1)
            return -1;
        if (Math.abs(leftHeight - rightHeight) > 1)
            return -1;
        return Math.max(leftHeight, rightHeight) + 1;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(isBalanced(root));
    }
}
