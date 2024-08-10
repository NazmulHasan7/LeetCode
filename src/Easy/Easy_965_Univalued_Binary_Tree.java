// 965. Univalued Binary Tree
package Easy;
import java.util.LinkedList;
import java.util.Queue;

public class Easy_965_Univalued_Binary_Tree {
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
    public static boolean isUnivalTree(TreeNode root) {
        return isUnival(root, root.val);
    }
    private static boolean isUnival(TreeNode root, int val) {
        if (root == null) return true;
        if (root.val != val) return false;
        return isUnival(root.left, val) && isUnival(root.right, val);
    }
    public static boolean isUnivalTreeBFS(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int val = root.val;

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.val != val) return false;
            if (node.left != null) queue.add(node.left);
            if (node.right != null) queue.add(node.right);
        } return true;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(3);
        root.right = new TreeNode(3);
        System.out.println(isUnivalTree(root));
        System.out.println(isUnivalTreeBFS(root));
    }
}
