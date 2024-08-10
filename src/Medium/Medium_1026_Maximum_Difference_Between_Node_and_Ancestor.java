// 1026. Maximum Difference Between Node and Ancestor
package Medium;

public class Medium_1026_Maximum_Difference_Between_Node_and_Ancestor {
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
    private static int maxDiff = 0;
    public static int maxAncestorDiff(TreeNode root) {
        findMax(root, root.val, root.val);
        return maxDiff;
    }
    private static void findMax(TreeNode root, int min, int max) {
        if (root == null) return;
        max = Math.max(root.val, max);
        min = Math.min(root.val, min);
        maxDiff = Math.max(maxDiff, max-min);

        if (root.left != null)
            findMax(root.left, min, max);
        if (root.right != null)
            findMax(root.right, min, max);
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        int[] arr = new int[]{2,4,7,5,6};
        for (int num : arr)
            root = insertIntoBST(root, num);
        System.out.println(maxAncestorDiff(root));
    }
}
