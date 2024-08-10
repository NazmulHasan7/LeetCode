// 662. Maximum Width of Binary Tree
package Medium;
import java.util.LinkedList;
import java.util.Queue;

public class Medium_662_Maximum_Width_of_Binary_Tree {
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
    static class Pair {
        TreeNode node;
        int position;
        public Pair (TreeNode node, int position) {
            this.node = node;
            this.position = position;
        }
    }
    public static int widthOfBinaryTree(TreeNode root) {
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(root, 1));
        int maxWidth = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            int start = 0, end = 0;
            // Assign each node a position value
            // Left Nodes - root position * 2
            // Odd Nodes - root position * 2 + 1
            for (int index = 0; index < size; index++) {
                Pair p = queue.poll();
                if (index == 0) start = p.position;
                if (index == size - 1) end = p.position;

                if (p.node.left != null)
                    queue.add(new Pair(p.node.left, p.position * 2));
                if (p.node.right != null)
                    queue.add(new Pair(p.node.right, p.position * 2 + 1));
            }
            maxWidth = Math.max(maxWidth, end-start+1);
        } return maxWidth;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(1);
        System.out.println(widthOfBinaryTree(root));
    }
}
