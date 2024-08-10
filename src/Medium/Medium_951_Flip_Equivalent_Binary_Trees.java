// 951. Flip Equivalent Binary Trees
package Medium;

public class Medium_951_Flip_Equivalent_Binary_Trees {
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
    public static boolean flipEquiv(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) return true;
        if (root1 == null || root2 == null) return false;
        if (root1.val != root2.val) return false;

        // Case 1: If the subtrees are same then no flip is required
        if (flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right))
            return true;
            // Case 2: Swap the nodes and check if the subtrees are same
        else if (flipEquiv(root1.left, root2.right) && flipEquiv(root1.right, root2.left))
            return true;
        return false;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(9);
        root.right = new TreeNode(0);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(1);
        TreeNode root2 = root;
        System.out.println(flipEquiv(root, root2));
    }
}
