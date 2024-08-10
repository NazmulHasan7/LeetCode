// 99. Recover Binary Search Tree
package Medium;

public class Medium_99_Recover_Binary_Search_Tree {
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
    static TreeNode swapNode1 = null, swapNode2 = null, prev = null;
    public static void inOrder(TreeNode root) {
        if (root == null) return;
        inOrder(root.left);
        if (prev != null && prev.val > root.val) {
            if (swapNode1 == null)
                swapNode1 = prev;
            swapNode2 = root;
        }
        prev = root;
        inOrder(root.right);
    }
    public static void recoverTree(TreeNode root) {
        inOrder(root);
        int temp = swapNode1.val;
        swapNode1.val = swapNode2.val;
        swapNode2.val = temp;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(4);
        root.right = new TreeNode(3);
        recoverTree(root);
    }
}
