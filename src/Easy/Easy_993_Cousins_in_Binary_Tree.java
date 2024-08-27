// 993. Cousins in Binary Tree
package Easy;
import java.util.LinkedList;
import java.util.Queue;

public class Easy_993_Cousins_in_Binary_Tree {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public static boolean isCousins(TreeNode root, int x, int y) {
        if (x == y) return false;
        TreeNode parentX = null, parentY = null;
        int heightX = -1, heightY = -1;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int height = 0;
        while (!queue.isEmpty()) {
            height++;
            int size = queue.size();
            while (size-- > 0) {
                TreeNode current = queue.poll();
                if (current.left != null) {
                    queue.add(current.left);
                    if (current.left.val == x) {
                        parentX = current;
                        heightX = height;
                    } else if (current.left.val == y) {
                        parentY = current;
                        heightY = height;
                    }
                }
                if (current.right != null) {
                    queue.add(current.right);
                    if (current.right.val == x) {
                        parentX = current;
                        heightX = height;
                    } else if (current.right.val == y) {
                        parentY = current;
                        heightY = height;
                    }
                }
            }
            if (heightX != -1 && heightY != -1) {
                return parentX != parentY && heightX == heightY;
            } else if (heightX != -1 || heightY != -1) {
                return false;
            }
        } return false;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(5);
        System.out.println(isCousins(root, 4, 5));
    }
}
