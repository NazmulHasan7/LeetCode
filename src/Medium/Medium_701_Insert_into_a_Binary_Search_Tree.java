// 701. Insert into a Binary Search Tree
package Medium;

public class Medium_701_Insert_into_a_Binary_Search_Tree {
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
    public static TreeNode insertIntoBSTBetter(TreeNode root, int val) {
        if (root == null)
            root = new TreeNode(val);
        else if (val <= root.val)
            root.left = insertIntoBST(root.left, val);
        else
            root.right = insertIntoBST(root.right, val);
        return root;
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
    public static void main(String[] args) {
        //4,2,7,1,3
        TreeNode root = new TreeNode(4);
        int[] arr = new int[]{2,7,1,3};
        for (int num : arr)
            root = insertIntoBST(root, num);
        System.out.println(root.val);
    }
}
