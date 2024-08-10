// 129. Sum Root to Leaf Numbers
package Medium;

public class Medium_129_Sum_Root_to_Leaf_Numbers {
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
    static int sum = 0;
    public static int sumNumbers(TreeNode root) {
        dfs(root, 0);
        return sum;
    }
    private static void dfs(TreeNode root, int pathSum) {
        // preorder traversal, root -> left -> right
        if (root == null) return;

        pathSum = pathSum * 10 + root.val;
        if (root.left == null && root.right == null)
            sum += pathSum;

        dfs(root.left, pathSum);
        dfs(root.right, pathSum);
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(9);
        root.right = new TreeNode(0);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(1);
        System.out.println(sumNumbers(root));
    }
}
