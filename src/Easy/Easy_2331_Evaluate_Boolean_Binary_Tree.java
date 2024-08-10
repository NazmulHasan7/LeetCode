// 2331. Evaluate Boolean Binary Tree
package Easy;

public class Easy_2331_Evaluate_Boolean_Binary_Tree {
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
    public static boolean evaluateTree(TreeNode root) {
        if (root.val == 0) return false;
        if (root.val == 1) return true;
        if (root.val == 2)
            return evaluateTree(root.left) || evaluateTree(root.right);
        if (root.val == 3)
            return evaluateTree(root.left) && evaluateTree(root.right);
        return false;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(0);
        System.out.println(evaluateTree(root));
    }
}
