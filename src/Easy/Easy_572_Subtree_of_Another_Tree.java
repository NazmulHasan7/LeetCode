// 572. Subtree of Another Tree
package Easy;

public class Easy_572_Subtree_of_Another_Tree {
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
    public static boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (subRoot == null) return true;
        if (root == null) return false;
        if (isSameTree(root, subRoot)) return true;
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }
    public static boolean isSameTree(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) return true;
        if (root1 == null || root2 == null) return false;
        if (root1.val != root2.val) return false;
        return isSameTree(root1.left, root2.left) && isSameTree(root1.right, root2.right);
    }
    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(4);
        int[] arr = new int[]{2,7,1,3};
        for (int num : arr)
            root1 = insertIntoBST(root1, num);

        TreeNode root2 = new TreeNode(4);
        arr = new int[]{2,7,1,3};
        for (int num : arr)
            root2 = insertIntoBST(root2, num);
        System.out.println(isSubtree(root1, root2));
    }
}
