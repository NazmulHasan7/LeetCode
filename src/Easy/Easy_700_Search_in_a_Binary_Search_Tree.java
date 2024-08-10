// 700. Search in a Binary Search Tree
package Easy;

public class Easy_700_Search_in_a_Binary_Search_Tree {
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
    public static TreeNode insert(TreeNode root, int value) {
        if (root == null)
            root = new TreeNode(value);
        else if (value <= root.val)
            root.left = insert(root.left, value);
        else
            root.right = insert(root.right, value);
        return root;
    }
    public static TreeNode searchBST(TreeNode root, int val) {
        while (root != null) {
            if (root.val == val) return root;
            else if (val <= root.val) root = root.left;
            else root = root.right;
        } return null;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        int[] arr = new int[]{2,7,1,3};
        for (int num : arr)
            root = insert(root, num);

        root = searchBST(root, 2);
        if (root != null) System.out.println(root.val);
        else System.out.println("None");
        root = searchBST(root, 5);
        if (root != null) System.out.println(root.val);
        else System.out.println("None");
    }
}
