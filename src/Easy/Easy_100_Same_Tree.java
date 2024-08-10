// 100. Same Tree
package Easy;
import java.util.LinkedList;
import java.util.Queue;

public class Easy_100_Same_Tree {
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
    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null)
            return true;
        else if (p == null || q == null || p.val != q.val)
            return false;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
    // BFS Traversal
    public static boolean isSameTreeIterative(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        else if (p == null || q == null) return false;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(p);
        queue.add(q);

        while (!queue.isEmpty()) {
            TreeNode tp = queue.poll();
            TreeNode tq = queue.poll();

            if(tp == null && tq == null) continue;
            else if (tp == null || tq == null) return false;
            else if (tp.val != tq.val) return false;

            queue.add(tp.left);
            queue.add(tq.left);
            queue.add(tp.right);
            queue.add(tq.right);
        }
        return true;
    }
    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(4);
        int[] arr = new int[]{2,7,1,3};
        for (int num : arr)
            root1 = insertIntoBST(root1, num);

        TreeNode root2 = new TreeNode(4);
        arr = new int[]{2,7,1,5};
        for (int num : arr)
            root2 = insertIntoBST(root2, num);
        System.out.println(isSameTree(root1, root2));
        System.out.println(isSameTreeIterative(root1, root2));
    }
}
