// 103. Binary Tree Zigzag Level Order Traversal
package Medium;
import java.util.Collections;
import java.util.Queue;
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;
import java.util.ArrayDeque;

public class Medium_103_Binary_Tree_Zigzag_Level_Order_Traversal {
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
    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> answer = new ArrayList<>();
        if (root == null) return answer;

        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);

        boolean rev = false;
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> row = new ArrayList<>();

            while (size-- > 0) {
                TreeNode node;
                if (rev) {
                    node = queue.pollLast();
                    if (node.right != null) queue.addFirst(node.right);
                    if (node.left != null) queue.addFirst(node.left);
                } else {
                    node = queue.pollFirst();
                    if (node.left != null) queue.addLast(node.left);
                    if (node.right != null) queue.addLast(node.right);
                }
                row.add(node.val);
            }
            rev = !rev;
            answer.add(row);
        } return answer;
    }
    public static List<List<Integer>> zigzagLevelOrderBetter(TreeNode root) {
        List<List<Integer>> answer = new ArrayList<>();
        if (root == null) return answer;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        boolean rev = false;
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> row = new ArrayList<>();
            while (size-- > 0) {
                TreeNode node = queue.poll();
                row.add(node.val);
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            if (rev) Collections.reverse(row);
            answer.add(row);
            rev = !rev;
        } return answer;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(9);
        root.right = new TreeNode(0);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(1);
        System.out.println(zigzagLevelOrder(root));
        System.out.println(zigzagLevelOrderBetter(root));
    }
}
