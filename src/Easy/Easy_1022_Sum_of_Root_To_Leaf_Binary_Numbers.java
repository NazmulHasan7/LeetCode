// 1022. Sum of Root To Leaf Binary Numbers
package Easy;

public class Easy_1022_Sum_of_Root_To_Leaf_Binary_Numbers {
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
    public static int sumRootToLeaf(TreeNode root) {
        return getSum(root, 0);
    }
    private static int getSum(TreeNode root, int sum) {
        if (root == null) return 0;
        sum = sum * 2 + root.val;
        if (root.left == null && root.right == null)
            return sum;
        return getSum(root.left, sum) + getSum(root.right, sum);
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(0);
        root.right = new TreeNode(1);
        System.out.println(sumRootToLeaf(root));
    }
}
