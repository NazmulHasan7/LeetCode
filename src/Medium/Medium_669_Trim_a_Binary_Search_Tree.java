// 669. Trim a Binary Search Tree
package Medium;

public class Medium_669_Trim_a_Binary_Search_Tree {
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
    public static TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null) return null;
        if (root.val < low) // Perform Trim operation on right subtree
            return trimBST(root.right, low, high);
        if (root.val > high) // Perform trim operation on left subtree
            return trimBST(root.left, low, high);

        root.left = trimBST(root.left, low, high);
        root.right = trimBST(root.right, low, high);
        return root;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root = insertIntoBST(root, 10);
        root = insertIntoBST(root, 10);
        root = insertIntoBST(root, 25);
        root = insertIntoBST(root, 8);
        root = insertIntoBST(root, 12);
        root = insertIntoBST(root, 12);
        root = trimBST(root, 10, 20);
        System.out.println(root.val);
    }
}
