// 863. All Nodes Distance K in Binary Tree
package Medium;
import java.util.*;

public class Medium_863_All_Nodes_Distance_K_in_Binary_Tree {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public static List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        // to keep track of the parent
        HashMap<Integer, TreeNode> childParent = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        childParent.put(root.val, null);

        // populate the child parent map
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i=0; i<size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    childParent.put(node.left.val, node);
                    queue.add(node.left);
                }
                if (node.right != null) {
                    childParent.put(node.right.val, node);
                    queue.add(node.right);
                }
            }
        }

        HashSet<Integer> visited = new HashSet<>();
        queue.add(target);

        while (!queue.isEmpty() && k > 0) {
            k--;
            int size = queue.size();
            for (int i=0; i<size; i++) {
                TreeNode node = queue.poll();
                TreeNode parent = childParent.get(node.val);
                visited.add(node.val);

                if (node.left != null && !visited.contains(node.left.val))
                    queue.add(node.left); // will help to get the kth distant nodes in left
                if (node.right != null && !visited.contains(node.right.val))
                    queue.add(node.right); // will help to get the kth distant nodes in right
                if (parent != null && !visited.contains(parent.val))
                    queue.add(parent); // will help to get the kth distant nodes in parent [upward direction]
            }
        }
        List<Integer> answer = new ArrayList<>();
        while (!queue.isEmpty()) answer.add(queue.poll().val);
        return answer;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        System.out.println(distanceK(root, root.left, 2));
    }
}
