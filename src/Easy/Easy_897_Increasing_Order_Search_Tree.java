// 897. Increasing Order Search Tree
package Easy;
import java.util.Stack;

public class Easy_897_Increasing_Order_Search_Tree {
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
    static TreeNode newTree = new TreeNode();
    static TreeNode newRoot = newTree;
    public static TreeNode increasingBST(TreeNode root) {
        inOrder(root);
        return newRoot.right;
    }
    public static void inOrder(TreeNode root) {
        if (root == null) return;
        inOrder(root.left);
        newTree.right = new TreeNode(root.val);
        System.out.print(root.val + " ");
        newTree = newTree.right;
        inOrder(root.right);
    }
    public static TreeNode increasingBSTIterative(TreeNode root) {
        if (root == null) return null;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode newRoot = null, prevNode = null;
        TreeNode current = root;

        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
            if (newRoot == null) {
                newRoot = new TreeNode(current.val);
                prevNode = newRoot;
            } else {
                prevNode.right = new TreeNode(current.val);
                prevNode = prevNode.right;
            }
            current = current.right;
        } return newRoot;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        int[] arr = new int[]{3,6,2,4,-1,8,1,-1,-1,-1,7,9};
        for (int num : arr)
            root = insertIntoBST(root, num);

        TreeNode answer = increasingBST(root);
        System.out.println("\n" + answer.val);
        answer = increasingBSTIterative(root);
        System.out.println(answer.val);
    }
}
