// 114. Flatten Binary Tree to Linked List
package Medium;
import java.util.Stack;

public class Medium_114_Flatten_Binary_Tree_to_Linked_List {
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
    static TreeNode prevNode = null;
    public static void flattenBetter(TreeNode root) {
        if (root == null) return;
        TreeNode left = root.left;
        TreeNode right = root.right;
        root.left = null;

        flatten(left);
        flatten(right);

        root.right = left;
        TreeNode current = root;
        while(current.right != null)
            current = current.right;

        current.right = right;
    }
    public static void flatten(TreeNode root) {
        if (root == null) return;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode current = stack.pop();
            if (current.right != null)
                stack.push(current.right);

            if (current.left != null)
                stack.push(current.left);

            if (!stack.isEmpty())
                current.right = stack.peek();

            current.left = null;
        }
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        flatten(root);
        while (root != null) {
            System.out.print(root.val + " ");
            root = root.right;
        }
    }
}
