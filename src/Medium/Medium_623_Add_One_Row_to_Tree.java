// 623. Add One Row to Tree
package Medium;

public class Medium_623_Add_One_Row_to_Tree {
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
    public static TreeNode addOneRow(TreeNode root, int val, int depth) {
        return helper(root, val, depth, 1);
    }
    private static TreeNode helper(TreeNode root, int val, int depth, int currentDepth) {
        if (depth == 1) {
            TreeNode newNode = new TreeNode(val);
            newNode.left = root;
            return newNode;
        }
        if (root == null) return null;

        if (currentDepth == depth-1) {
            TreeNode left = root.left;
            TreeNode right = root.right;

            root.left = new TreeNode(val);
            root.right = new TreeNode(val);

            root.left.left = left;
            root.right.right = right;
            return root;
        }
        helper(root.left, val, depth, depth+1);
        helper(root.right, val, depth, depth+1);
        return root;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root = addOneRow(root, 5, 2);
        System.out.println(root.val);
    }
}
