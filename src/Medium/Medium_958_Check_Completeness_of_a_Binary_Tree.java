// 958. Check Completeness of a Binary Tree
package Medium;

import java.util.LinkedList;
import java.util.Queue;

public class Medium_958_Check_Completeness_of_a_Binary_Tree {
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
    public static boolean isCompleteTree(TreeNode root) {
        if (root == null) return true;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        boolean nullFound = false;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) {
                nullFound = true;
            } else {
                if (nullFound) return false;
                queue.add(node.left);
                queue.add(node.right);
            }
        } return true;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        System.out.println(isCompleteTree(root));
    }
}
