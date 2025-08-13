// 2385. Amount of Time for Binary Tree to Be Infected
package Medium;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class Medium_2385_Amount_of_Time_for_Binary_Tree_to_Be_Infected {
    // Similar to - 863. All Nodes Distance K in Binary Tree
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public static int amountOfTime(TreeNode root, int start) {
        // keep track of parent node
        HashMap<Integer, TreeNode> childParentMap = new HashMap<>();
        childParentMap.put(root.val, null);

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        TreeNode startNode = null;

        // populate the child parent map
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i=0; i<size; i++) {
                TreeNode node = queue.poll();
                if (node.val == start)
                    startNode = node;
                if (node.left != null) {
                    childParentMap.put(node.left.val, node);
                    queue.add(node.left);
                }
                if (node.right != null) {
                    childParentMap.put(node.right.val, node);
                    queue.add(node.right);
                }
            }
        }

        HashSet<Integer> visited = new HashSet<>();
        queue.add(startNode);
        int time = -1;

        while (!queue.isEmpty()) {
            time++;
            int size = queue.size();
            for (int i=0; i<size; i++) {
                TreeNode node = queue.poll();
                TreeNode parentNode = childParentMap.get(node.val);
                visited.add(node.val);

                if (node.left != null && !visited.contains(node.left.val))
                    queue.add(node.left);
                if (node.right != null && !visited.contains(node.right.val))
                    queue.add(node.right);
                if (parentNode != null && !visited.contains(parentNode.val))
                    queue.add(parentNode);
            }
        }
        return time;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        System.out.println(amountOfTime(root, 3));
    }
}
