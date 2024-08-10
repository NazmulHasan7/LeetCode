// 872. Leaf-Similar Trees
package Easy;
import java.util.*;

public class Easy_872_Leaf_Similar_Trees {
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
    public static boolean leafSimilar(TreeNode root1, TreeNode root2) {
        ArrayList<Integer> tree1Leaves = new ArrayList<>();
        ArrayList<Integer> tree2Leaves = new ArrayList<>();
        getLeaves(tree1Leaves, root1);
        getLeaves(tree2Leaves, root2);
        return tree1Leaves.equals(tree2Leaves);
    }
    private static void getLeaves(ArrayList<Integer> treeLeaves, TreeNode root) {
        if (root == null) return;
        getLeaves(treeLeaves, root.left);
        if (root.left == null && root.right == null)
            treeLeaves.add(root.val);
        getLeaves(treeLeaves, root.right);
    }
    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(3);
        root1.left = new TreeNode(1);
        root1.right = new TreeNode(8);

        TreeNode root2 = new TreeNode(5);
        root2.left = new TreeNode(1);
        root2.right = new TreeNode(8);
        System.out.println(leafSimilar(root1, root2));
    }
}
