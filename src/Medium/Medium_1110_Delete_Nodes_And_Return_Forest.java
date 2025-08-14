// 1110. Delete Nodes And Return Forest
package Medium;
import java.util.*;

public class Medium_1110_Delete_Nodes_And_Return_Forest {
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
    public static List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        Set<Integer> nodesToBeDeleted = new HashSet<>();
        for (int node : to_delete)
            nodesToBeDeleted.add(node);

        List<TreeNode> forestRoots = new ArrayList<>();
        forestRoots.add(root);

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i=0; i<size; i++) {
                TreeNode node = queue.poll();

                // remove the node and add the child to the forest
                if (nodesToBeDeleted.contains(node.val)) {
                    forestRoots.remove(node);
                    if (node.left != null)
                        forestRoots.add(node.left);
                    if (node.right != null)
                        forestRoots.add(node.right);
                }
                // for BFS
                if (node.left != null) {
                    queue.add(node.left);
                    if (nodesToBeDeleted.contains(node.left.val))
                        node.left = null; // disconnect the node
                }
                if (node.right != null) {
                    queue.add(node.right);
                    if (nodesToBeDeleted.contains(node.right.val))
                        node.right = null; // disconnect the node
                }
            }
        } return forestRoots;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        System.out.println(delNodes(root, new int[]{3,5}));
    }
}
