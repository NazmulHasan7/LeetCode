// 449. Serialize and Deserialize BST
package Medium;
import java.util.Queue;
import java.util.LinkedList;

public class Medium_449_Serialize_and_Deserialize_BST {
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
    static class Codec {
        // Encodes a tree to a single string. BFS
        public String serialize(TreeNode root) {
            if (root == null) return " ";
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            StringBuilder sb = new StringBuilder();

            while (!queue.isEmpty()) {
                TreeNode current = queue.poll();
                if (current != null) {
                    sb.append(current.val).append(" ");
                    queue.add(current.left);
                    queue.add(current.right);
                } else {
                    sb.append("null ");
                }
            } return sb.toString();
        }
        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if (data == null || data.equals(" ")) return null;
            String[] nodes = data.split(" ");
            TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));

            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);

            int index = 1, n = nodes.length;
            while (index < n) {
                TreeNode parent = queue.poll();
                // Add left node to the parent node
                if (!nodes[index].equals("null")) {
                    parent.left = new TreeNode(Integer.parseInt(nodes[index]));
                    queue.add(parent.left);
                }
                index++;
                // Add right node to the parent node
                if (index < n && !nodes[index].equals("null")) {
                    parent.right = new TreeNode(Integer.parseInt(nodes[index]));
                    queue.add(parent.right);
                }
                index++;
            } return root;
        }
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);

        Codec c = new Codec();
        System.out.println(c.serialize(root));
        System.out.println(c.deserialize(c.serialize(root)).val);
    }
}
