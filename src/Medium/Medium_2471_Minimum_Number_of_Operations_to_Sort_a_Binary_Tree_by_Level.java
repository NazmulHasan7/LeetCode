// 2471. Minimum Number of Operations to Sort a Binary Tree by Level
package Medium;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Medium_2471_Minimum_Number_of_Operations_to_Sort_a_Binary_Tree_by_Level {
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

    private static int getSwapCount(int[] arr, int n) {
        int[] sortedArr = arr.clone();
        Arrays.sort(sortedArr);

        HashMap<Integer, Integer> indexMap = new HashMap<>();
        for (int i=0; i<n; i++)
            indexMap.put(arr[i], i);

        int swaps = 0;

        for (int i=0; i<n; i++) {
            if (arr[i] != sortedArr[i]) {
                // Mismatch with the sorted array -> Need to swap
                int arrIdx = indexMap.get(sortedArr[i]);
                int temp = arr[i];
                arr[i] = sortedArr[i];
                arr[arrIdx] = temp;
                indexMap.put(temp, arrIdx);
                swaps++;
            }
        }
        return swaps;
    }

    public static int minimumOperations(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int swapCount = 0;

        while (!queue.isEmpty()) {
            int n = queue.size();
            int[] level = new int[n];
            int idx = 0;

            while (n-- > 0) {
                TreeNode node = queue.poll();
                level[idx++] = node.val;

                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }

            swapCount += getSwapCount(level, level.length);
        }
        return swapCount;
    }
}
