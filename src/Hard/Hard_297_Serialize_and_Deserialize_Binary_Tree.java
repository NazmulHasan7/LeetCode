// 297. Serialize and Deserialize Binary Tree
package Hard;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Hard_297_Serialize_and_Deserialize_Binary_Tree {
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
    static class Codec {
        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            if (root == null) return "n";
            return root.val + "," + serialize(root.left) + "," + serialize(root.right);
        }
        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            Queue<String> queue = new LinkedList<>(Arrays.asList(data.split(",")));
            return buildTree(queue);
        }
        private TreeNode buildTree(Queue<String> queue) {
            String str = queue.poll();
            if (str == null || str.equals("n")) return null;

            TreeNode root = new TreeNode(Integer.parseInt(str));
            root.left = buildTree(queue);
            root.right = buildTree(queue);
            return root;
        }
    }
    public static void main(String[] args) {
        Codec c = new Codec();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        System.out.println(c.serialize(root));
        System.out.println(c.deserialize(c.serialize(root)).val);
    }
}
