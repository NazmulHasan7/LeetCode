// 1379. Find a Corresponding Node of a Binary Tree in a Clone of That Tree
package Easy;

public class Easy_1379_Find_a_Corresponding_Node_of_a_Binary_Tree_in_a_Clone_of_That_Tree {
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
    public static TreeNode dfs(TreeNode original, TreeNode cloned, TreeNode target) {
        if (cloned == null) return null;
        if (original == target) return cloned;

        TreeNode left = dfs(original.left, cloned.left, target);
        if (left != null) return left;

        TreeNode right = dfs(original.right, cloned.right, target);
        if (right != null) return right;
        return null;
    }
    public static final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        return dfs(original, cloned, target);
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(5);
        System.out.println(getTargetCopy(root, root, root.left).val);
    }
}
