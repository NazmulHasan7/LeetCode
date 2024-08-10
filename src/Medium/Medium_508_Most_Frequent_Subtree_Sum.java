// 508. Most Frequent Subtree Sum
package Medium;
import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Arrays;

public class Medium_508_Most_Frequent_Subtree_Sum {
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
    static HashMap<Integer, Integer> map = new HashMap<>();
    static List<Integer> arr = new ArrayList<>();
    static int maxFreq = 0;
    public static int[] findFrequentTreeSum(TreeNode root) {
        dfs(root);
        int[] answer = new int[arr.size()];
        for (int i=0; i<answer.length; i++)
            answer[i] = arr.get(i);
        return answer;
    }
    private static int dfs(TreeNode root) {
        if (root == null) return 0;
        int sum = root.val + dfs(root.left) + dfs(root.right);
        int freq = map.getOrDefault(sum,0) + 1;

        if (freq > maxFreq) {
            maxFreq = freq;
            arr.clear();
            arr.add(sum);
        } else if (freq == maxFreq) {
            arr.add(sum);
        }
        map.put(sum, freq);
        return sum;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(9);
        root.right = new TreeNode(0);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(1);
        System.out.println(Arrays.toString(findFrequentTreeSum(root)));
    }
}
