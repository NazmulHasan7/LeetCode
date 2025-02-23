// 1028. Recover a Tree From Preorder Traversal
package Hard;
import java.util.ArrayList;
import java.util.List;

public class Hard_1028_Recover_a_Tree_From_Preorder_Traversal {
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
    private static int index;
    public static TreeNode recoverFromPreorder(String traversal) {
        index = 0;
        return solve(traversal.toCharArray(), 0, traversal.length());
    }
    private static TreeNode solve(char[] crr, int depth, int n) {
        // out of bound
        if (index >= n) return null;

        // count the dash to get the depth
        int dashCount = 0;
        while (index < n && crr[index] == '-') {
            dashCount++;
            index++;
        }
        // since the expected depth and the count depth is not the same we are at the wrong position
        if (dashCount != depth) {
            // since we are backtracking, need to reset the index to its previous position
            index -= dashCount;
            return null;
        }

        int value = 0;
        while (index < n && Character.isDigit(crr[index])) {
            value = (value * 10) + (crr[index] - '0');
            index++;
        }
        // create a new tree node
        TreeNode node = new TreeNode(value);
        // recursively build the left subtree
        node.left = solve(crr, depth+1, n);
        // recursively build the right subtree
        node.right = solve(crr, depth+1, n);
        return node;
    }


    // Optimized Approach
    public static TreeNode recoverFromPreorderOpt(String traversal) {
        int n = traversal.length();
        // store the last nodes of the depth
        List<TreeNode> nodesAtDepth = new ArrayList<>();

        int index = 0;
        while (index < n) {
            int depth = 0;
            while (index < n && traversal.charAt(index) == '-') {
                index++;
                depth++;
            }

            int value = 0;
            while (index < n && Character.isDigit(traversal.charAt(index))) {
                value = (value * 10) + (traversal.charAt(index) - '0');
                index++;
            }

            TreeNode node = new TreeNode(value);

            if (depth < nodesAtDepth.size())
                // update with the latest node
                nodesAtDepth.set(depth, node);
            else nodesAtDepth.add(depth, node);

            // connect with the parent
            if (depth > 0) { // if not the root node
                TreeNode parent = nodesAtDepth.get(depth - 1);
                if (parent.left == null) parent.left = node;
                else parent.right = node;
            }
        }
        return nodesAtDepth.getFirst();
    }
    public static void main(String[] args) {
        System.out.println(recoverFromPreorder("1-2--3--4-5--6--7"));
        System.out.println(recoverFromPreorder("1-2--3---4-5--6---7"));
        System.out.println(recoverFromPreorder("1-401--349---90--88"));
    }
}
