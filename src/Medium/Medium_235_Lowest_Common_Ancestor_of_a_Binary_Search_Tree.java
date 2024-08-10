// 235. Lowest Common Ancestor of a Binary Search Tree
package Medium;

public class Medium_235_Lowest_Common_Ancestor_of_a_Binary_Search_Tree {
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
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // Both node values are less than root value then search in left subtree
        if (p.val <  root.val && q.val < root.val)
            return lowestCommonAncestor(root.left, p, q);
            // Both node values are greater than root value then search in right subtree
        else if (p.val > root.val && q.val > root.val)
            return lowestCommonAncestor(root.right, p, q);
            // One node is greater and the other node is lesser or node is equal to root
        else return root;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        System.out.println(lowestCommonAncestor(root, new TreeNode(2), new TreeNode(5)).val);
    }
}
