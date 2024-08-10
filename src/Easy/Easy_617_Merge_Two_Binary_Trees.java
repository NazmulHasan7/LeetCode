// 617. Merge Two Binary Trees
package Easy;
import java.util.LinkedList;
import java.util.Queue;

public class Easy_617_Merge_Two_Binary_Trees {
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
    public static TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null) return root2;
        if (root2 == null) return root1;

        root1.left = mergeTrees(root1.left, root2.left);
        root1.val = root1.val + root2.val;
        root1.right = mergeTrees(root1.right, root2.right);
        return root1;
    }
    public static TreeNode mergeTreesIterative(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) return null;
        if (root1 == null || root2 == null)
            return root1 == null ? root2 : root1;

        Queue<TreeNode[]> queue = new LinkedList<>();
        queue.add(new TreeNode[]{root1, root2});

        while (!queue.isEmpty()) {
            int size = queue.size();

            while (size-- != 0) {
                TreeNode[] nodes = queue.poll();
                TreeNode r1 = nodes[0], r2 = nodes[1];

                if (r1 != null && r2 != null)
                    r1.val += r2.val;

                if (r1.left == null && r2.left != null)
                    r1.left = r2.left;
                else if (r1.left != null && r2.left != null)
                    queue.add(new TreeNode[]{r1.left, r2.left});

                if (r1.right == null && r2.right != null)
                    r1.right = r2.right;
                else if (r1.right != null && r2.right != null)
                    queue.add(new TreeNode[]{r1.right, r2.right});
            }
        } return root1;
    }
    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(3);
        root1.left = new TreeNode(1);
        root1.right = new TreeNode(8);

        TreeNode root2 = new TreeNode(5);
        root2.left = new TreeNode(1);
        root2.right = new TreeNode(8);
        root2.right.left = new TreeNode(10);
        System.out.println(mergeTrees(root1, root2).val);
    }
}
