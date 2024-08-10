// 530. Minimum Absolute Difference in BST
package Easy;
import java.util.Stack;

public class Easy_530_Minimum_Absolute_Difference_in_BST {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(){}
        public TreeNode(int value){this.val = value;}
        public TreeNode(int value, TreeNode left, TreeNode right) {
            this.val = value;
            this.left = left;
            this.right = right;
        }
    }
    public static TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null)
            root = new TreeNode(val);
        else if (val <= root.val)
            root.left = insertIntoBST(root.left, val);
        else
            root.right = insertIntoBST(root.right, val);
        return root;
    }
    static int minDiff = Integer.MAX_VALUE;
    static TreeNode prevNode = null;
    public static int minDiffInBST(TreeNode root) {
        inOrder(root);
        return minDiff;
    }
    public static void inOrder(TreeNode root) {
        if (root == null) return;
        inOrder(root.left);
        if (prevNode != null)
            minDiff = Math.min(minDiff, root.val-prevNode.val);
        prevNode = root;
        inOrder(root.right);
    }
    public static int minDiffInBSTIterative(TreeNode root) {
        int minDistance = Integer.MAX_VALUE;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode prevNode = null, current = root;

        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
            if (prevNode != null)
                minDistance = Math.min(minDistance, current.val - prevNode.val);
            prevNode = current;
            current = current.right;
        }
        return minDistance;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        int[] arr = new int[]{2,6,1,3};
        for (int a : arr)
            insertIntoBST(root, a);
        System.out.println(minDiffInBST(root));
        System.out.println(minDiffInBSTIterative(root));
    }
}
