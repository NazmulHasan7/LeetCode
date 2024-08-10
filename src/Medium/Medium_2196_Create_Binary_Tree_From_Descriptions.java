// 2196. Create Binary Tree From Descriptions
package Medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Objects;

public class Medium_2196_Create_Binary_Tree_From_Descriptions {
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
    public static TreeNode createBinaryTree(int[][] descriptions) {
        HashMap<Integer, TreeNode> map = new HashMap<>();
        HashSet<Integer> childrenSet = new HashSet<>();

        for (int[] desc : descriptions) {
            int parent = desc[0];
            int child  = desc[1];
            int isLeft = desc[2];
            childrenSet.add(child);

            TreeNode current = map.getOrDefault(parent, new TreeNode(parent));
            map.put(parent, current);

            if (isLeft == 1) {
                current.left = map.getOrDefault(child, new TreeNode(child));
                map.put(child, current.left);
            } else {
                current.right = map.getOrDefault(child, new TreeNode(child));
                map.put(child, current.right);
            }
        }

        for (int[] desc : descriptions)
            if (!childrenSet.contains(desc[0]))
                return map.get(desc[0]);
        return null;
    }
    public static void main(String[] args) {
        System.out.println(Objects.requireNonNull(createBinaryTree(new int[][]{
                {20, 15, 1}, {20, 17, 0}, {50, 20, 1}, {50, 80, 0}, {80, 19, 1}})).val);
    }
}
