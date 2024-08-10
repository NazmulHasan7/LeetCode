// 98. Validate Binary Search Tree
package Medium;
import java.util.Stack;

public class Medium_98_Validate_Binary_Search_Tree {
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
    public static boolean isValidBST(TreeNode root) {
        // An in-order traversal of valid BST should be sorted
        if (root == null) return true;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root, prevNode = null;

        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
            if (prevNode != null && prevNode.val > current.val)
                return false;
            prevNode = current;
            current = current.right;
        }
        return true;
    }
    static TreeNode prev;
    public static boolean isValidBSTBetter(TreeNode root) {
        if (root == null) return true;

        if (!isValidBSTBetter(root.left))
            return false;

        if (prev != null && root.val <= prev.val)
            return false;
        prev = root;

        if (!isValidBSTBetter(root.right))
            return false;
        return true;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(15);
        root = insertIntoBST(root, 10);
        root = insertIntoBST(root, 20);
        root = insertIntoBST(root, 25);
        root = insertIntoBST(root, 8);
        root = insertIntoBST(root, 12);
        root = insertIntoBST(root, 13);
        System.out.println(isValidBST(root));
        System.out.println(isValidBSTBetter(root));
    }
}
