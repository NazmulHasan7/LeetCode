// 173. Binary Search Tree Iterator
package Medium;
import java.util.Queue;
import java.util.LinkedList;

public class Medium_173_Binary_Search_Tree_Iterator {
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
    static class BSTIterator {
        Queue<Integer> queue;
        public BSTIterator(TreeNode root) {
            queue = new LinkedList<>();
            inOrderTraverse(root);
        }
        public void inOrderTraverse(TreeNode root) {
            if (root == null) return;
            inOrderTraverse(root.left);
            queue.add(root.val);
            inOrderTraverse(root.right);
        }
        public int next() {
            if (!queue.isEmpty()) return queue.poll();
            else return Integer.MIN_VALUE;
        }
        public boolean hasNext() {
            return !queue.isEmpty();
        }
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(15);
        root = insertIntoBST(root, 10);
        root = insertIntoBST(root, 10);
        root = insertIntoBST(root, 25);
        root = insertIntoBST(root, 8);
        root = insertIntoBST(root, 12);
        root = insertIntoBST(root, 12);
        BSTIterator bst = new BSTIterator(root);
        System.out.println(bst.hasNext());
        System.out.println(bst.next());
    }
}
