// 102. Binary Tree Level Order Traversal
package Medium;
import java.util.*;

public class Medium_102_Binary_Tree_Level_Order_Traversal {
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
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> answer = new ArrayList<>();
        if (root == null) return answer;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int size = queue.size();

            while (size-- > 0) {
                TreeNode node = queue.poll();
                level.add(node.val);
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            answer.add(level);
        } return answer;
    }
    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(4);
        int[] arr = new int[]{2,7,1,3};
        for (int num : arr)
            root1 = insertIntoBST(root1, num);

        List<List<Integer>> list = levelOrder(root1);
        for (List<Integer> level : list)
            System.out.println(Arrays.toString(level.toArray()));
    }
}
