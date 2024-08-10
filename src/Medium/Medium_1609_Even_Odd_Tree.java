// 1609. Even Odd Tree
package Medium;
import java.util.Queue;
import java.util.LinkedList;

public class Medium_1609_Even_Odd_Tree {
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
    public static boolean isEvenOddTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean isEven = true;

        while (!queue.isEmpty()) {
            int size = queue.size();
            int last = isEven ? 0 : Integer.MAX_VALUE;

            while (size-- > 0) {
                TreeNode node = queue.poll();
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);

                if (isEven) { // At even level the values should be odd and strictly increasing
                    if (node.val % 2 == 0 || node.val <= last) return false;
                } else { // For odd levels values should be even and strictly decreasing
                    if (node.val % 2 == 1 || node.val >= last) return false;
                } last = node.val;
            }
            isEven = ! isEven;
        } return true;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        int[] arr = new int[]{2,4,7,5,6};
        for (int num : arr)
            root = insertIntoBST(root, num);
        System.out.println(isEvenOddTree(root));
    }
}
