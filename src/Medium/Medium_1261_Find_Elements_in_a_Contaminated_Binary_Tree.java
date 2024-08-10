// 1261. Find Elements in a Contaminated Binary Tree
package Medium;
import java.util.HashSet;

public class Medium_1261_Find_Elements_in_a_Contaminated_Binary_Tree {
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
    static class FindElements {
        private HashSet<Integer> set;
        public FindElements(TreeNode root) {
            set = new HashSet<>();
            set.add(0);
            root.val = 0;
            recoverTree(root);
        }
        private void recoverTree(TreeNode root) {
            if (root == null) return;
            set.add(root.val);

            if (root.left != null)
                root.left.val = root.val*2+1;

            if (root.right != null)
                root.right.val = root.val*2+2;

            recoverTree(root.left);
            recoverTree(root.right);
        }
        public boolean find(int target) {
            return set.contains(target);
        }
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(-1);
        root.left = new TreeNode(-1);
        root.right = new TreeNode(-1);
        root.left.left = new TreeNode(-1);
        root.left.right = new TreeNode(-1);
        FindElements findElements = new FindElements(root);
        System.out.println(findElements.find(1));
        System.out.println(findElements.find(3));
        System.out.println(findElements.find(5));
    }
}
