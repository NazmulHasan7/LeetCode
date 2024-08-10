// 671. Second Minimum Node In a Binary Tree
package Easy;
import java.util.TreeSet;

public class Easy_671_Second_Minimum_Node_In_a_Binary_Tree {
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
    public static int findSecondMinimumValue(TreeNode root) {
        TreeSet<Integer> set = new TreeSet<>();
        inOrder(root, set);
        if (set.size() < 2) return -1;
        set.pollFirst();
        return set.first();
    }
    private static void inOrder(TreeNode root, TreeSet<Integer> set) {
        if (root == null) return;
        inOrder(root.left, set);
        set.add(root.val);
        inOrder(root.right, set);
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        int[] arr = new int[]{2,2,2147483647};
        for (int num : arr)
            root = insertIntoBST(root, num);
        System.out.println(findSecondMinimumValue(root));
    }
}
