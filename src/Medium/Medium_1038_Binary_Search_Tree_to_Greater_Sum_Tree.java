// Medium 1038. Binary Search Tree to Greater Sum Tree
package Medium;

public class Medium_1038_Binary_Search_Tree_to_Greater_Sum_Tree {
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
    static int sum = 0;
    public static TreeNode bstToGst(TreeNode root) {
        // Reverse inOrder traversal
        if (root == null) return null;
        root.right = bstToGst(root.right);
        sum += root.val;
        root.val = sum;
        root.left = bstToGst(root.left);
        return root;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(15);
        root = insertIntoBST(root, 10);
        root = insertIntoBST(root, 10);
        root = insertIntoBST(root, 25);
        root = insertIntoBST(root, 8);
        root = insertIntoBST(root, 12);
        root = insertIntoBST(root, 12);
        root = bstToGst(root);
        System.out.println(root.val);
    }
}
