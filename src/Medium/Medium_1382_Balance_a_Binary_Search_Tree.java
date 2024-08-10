// 1382. Balance a Binary Search Tree
package Medium;
import java.util.ArrayList;

public class Medium_1382_Balance_a_Binary_Search_Tree {
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
    public static void inOrder(TreeNode root, ArrayList<Integer> list) {
        if (root == null) return;
        inOrder(root.left, list);
        list.add(root.val);
        inOrder(root.right, list);
    }
    public static TreeNode balance(ArrayList<Integer> list, int start, int end) {
        if (start > end) return null;
        int mid = (start + end) / 2;

        TreeNode root = new TreeNode(list.get(mid));
        root.left = balance(list, start, mid-1);
        root.right = balance(list, mid+1, end);
        return root;
    }
    public static TreeNode balanceBST(TreeNode root) {
        if (root == null) return null;
        ArrayList<Integer> list = new ArrayList<>();
        inOrder(root, list);

        TreeNode newRoot = balance(list, 0, list.size()-1);
        return newRoot;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(4);
        root.right = new TreeNode(3);
        System.out.println(balanceBST(root).val);
    }
}
