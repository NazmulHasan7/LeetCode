// 1372. Longest ZigZag Path in a Binary Tree
package Medium;

public class Medium_1372_Longest_ZigZag_Path_in_a_Binary_Tree {
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
    private static int answer;
    public static int longestZigZag(TreeNode root) {
        answer = 0;
        solve(root.left, true, 1);
        solve(root.right, false, 1);
        return answer;
    }
    private static void solve(TreeNode root, boolean isLeft, int length) {
        if (root == null) return;

        answer = Math.max(answer, length);
        if (isLeft) {
            solve(root.right, false, length + 1);
            solve(root.left, true, 1);
        } else {
            solve(root.left, true, length + 1);
            solve(root.right, false, 1);
        }
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(1);
        root.right.left = new TreeNode(1);
        root.right.right = new TreeNode(1);
        root.right.right.left = new TreeNode(1);
        root.right.right.right = new TreeNode(1);
        root.right.right.left.right = new TreeNode(1);
        root.right.right.left.right.right = new TreeNode(1);
        System.out.println(longestZigZag(root));
    }
}
