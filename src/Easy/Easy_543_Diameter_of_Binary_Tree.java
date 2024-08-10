// 543. Diameter of Binary Tree
package Easy;

public class Easy_543_Diameter_of_Binary_Tree {
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
    static int diameter = 0;
    public static int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return diameter;
    }
    private static int dfs(TreeNode root) {
        if (root == null) return 0;
        int leftHeight = dfs(root.left);
        int rightHeight = dfs(root.right);
        diameter = Math.max(diameter, leftHeight + rightHeight);
        // Return the maximum depth
        return 1 + Math.max(leftHeight, rightHeight);
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        int[] arr = new int[]{2,4,7,5,6};
        for (int num : arr)
            root = insertIntoBST(root, num);
        System.out.println(diameterOfBinaryTree(root));
    }
}
