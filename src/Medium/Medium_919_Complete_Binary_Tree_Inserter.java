// 919. Complete Binary Tree Inserter
package Medium;
import java.util.LinkedList;
import java.util.Queue;

public class Medium_919_Complete_Binary_Tree_Inserter {
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
    static class CBTInserter {
        TreeNode root;
        Queue<TreeNode> incompleteNodes;

        public CBTInserter(TreeNode root) {
            this.root = root;
            this.incompleteNodes = new LinkedList<>();
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);

            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);

                if (node.left == null || node.right == null) {
                    // An incomplete node is found
                    incompleteNodes.add(node);
                }
            }
        }
        public int insert(int val) {
            TreeNode newNode = new TreeNode(val);
            TreeNode currentParent = incompleteNodes.peek();

            if (currentParent.left == null) {
                currentParent.left = newNode;
            } else if (currentParent.right == null) {
                currentParent.right = newNode; // Now the current parent has both the child
                // so, it is no more an incomplete node
                incompleteNodes.poll();
            }
            // the new node is definitely an incomplete node
            incompleteNodes.add(newNode);
            return currentParent.val;
        }
        public TreeNode get_root() {
            return this.root;
        }
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        CBTInserter cbti = new CBTInserter(root);
        cbti.insert(3);
        cbti.insert(4);
        System.out.println(cbti.get_root());
    }
}
