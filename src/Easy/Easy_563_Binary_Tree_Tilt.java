// 563. Binary Tree Tilt
package Easy;

public class Easy_563_Binary_Tree_Tilt {
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
    private static int tiltSum;
    public static int findTilt(TreeNode root) {
        tiltSum = 0;
        solve(root);
        return tiltSum;
    }
    private static int solve(TreeNode root) {
        if (root == null) return 0;
        int left = solve(root.left);
        int right = solve(root.right);
        tiltSum += Math.abs(left - right);
        return left + right + root.val;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        System.out.println(findTilt(root));
    }
}
