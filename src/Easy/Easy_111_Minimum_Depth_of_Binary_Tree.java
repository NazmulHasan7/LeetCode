// 111. Minimum Depth of Binary Tree
package Easy;
import java.util.Queue;
import java.util.LinkedList;

public class Easy_111_Minimum_Depth_of_Binary_Tree {
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
    public static int minDepth(TreeNode root) {
        if (root == null) return 0;
        // Case 1: the current node has no left child
        if (root.left == null)
            return 1 + minDepth(root.right);
        // Case 2: the current node has no right child
        if (root.right == null)
            return 1 + minDepth(root.left);
        return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    }
    public static int minDepthBFS(TreeNode root) {
        if (root == null) return 0;
        int depth = 1;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                TreeNode node = queue.poll();
                if (node.left == null && node.right == null)
                    return depth;
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            depth++;
        } return 0;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        int[] arr = new int[]{2,4,7,5,6};
        for (int num : arr)
            root = insertIntoBST(root, num);
        System.out.println(minDepth(root));
        System.out.println(minDepthBFS(root));
    }
}
