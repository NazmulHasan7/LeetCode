// 565. Array Nesting
package Medium;

public class Medium_565_Array_Nesting {
    public static int arrayNesting(int[] nums) {
        int n = nums.length;
        int maxLen = 0;
        // Brute Force Approach -> TC O(n^2)
        for (int k=0; k<n; k++) {
            int nextIdx = nums[k];
            int len = 1;
            while (nextIdx != k) {
                len++;
                nextIdx = nums[nextIdx];
            }
            maxLen = Math.max(maxLen, len);
        }
        return maxLen;
    }
    // Linear time -> Visited Array
    public static int arrayNestingOpt(int[] nums) {
        int n = nums.length;
        boolean[] visited = new boolean[n];
        int maxLen = 0;

        for (int k=0; k<n; k++) {
            // If the current index is already visited, means it is coming from another source
            // Meaning that the max depth would be always less than the depth starting from the source
            // so we ignore it
            if (!visited[k]) {
                visited[k] = true;
                int nextIdx = nums[k];
                int len = 1;
                while (nextIdx != k) {
                    visited[nextIdx] = true;
                    nextIdx = nums[nextIdx];
                    len++;
                }
                maxLen = Math.max(maxLen, len);
            }
        } return maxLen;
    }
    // Linear time -> Optimized Approach
    public static int arrayNestingBest(int[] nums) {
        int n = nums.length;
        int maxLen = 0;

        for (int k=0; k<n; k++) {
            if (nums[k] != -1) {
                int current = k;
                int len = 0;
                while (nums[current] != -1) {
                    len++;
                    int next = nums[current];
                    nums[current] = -1; // mark as visited
                    current = next;
                }
                maxLen = Math.max(maxLen, len);
            }
        } return maxLen;
    }
    public static void main(String[] args) {
        System.out.println(arrayNesting(new int[]{5,4,0,3,1,6,2}));
        System.out.println(arrayNesting(new int[]{0,1,2}));
    }
}
