// 1008. Construct Binary Search Tree from Preorder Traversal
package Medium;

public class Medium_1008_Construct_Binary_Search_Tree_from_Preorder_Traversal {
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
    public static TreeNode bstFromPreorder(int[] preorder) {
        TreeNode root = new TreeNode(preorder[0]);
        for (int i=1; i<preorder.length; i++)
            root = insertIntoBST(root, preorder[i]);
        return root;
    }
    public static void main(String[] args) {
        int[] arr = new int[]{8,5,1,7,10,12};
        System.out.println(bstFromPreorder(arr).val);
    }
}
