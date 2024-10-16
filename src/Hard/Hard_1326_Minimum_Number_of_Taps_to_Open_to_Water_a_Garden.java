// 1326. Minimum Number of Taps to Open to Water a Garden
package Hard;

import java.util.Arrays;

public class Hard_1326_Minimum_Number_of_Taps_to_Open_to_Water_a_Garden {
    // Recursion + Memoization -> MLE Memory Limit Exceeded
    public static int minTaps(int n, int[] ranges) {
        int[][] arr = new int[n+1][2];

        for (int i=0; i<=n; i++) {
            // each tap can water i-range to i=range
            arr[i][0] = Math.max(0, i-ranges[i]); // start
            arr[i][1] = Math.min(n, i+ranges[i]); // end
        }
        Arrays.sort(arr, (a, b) -> a[0] - b[0]);

        int[][] dp = new int[n+1][n+1];
        for(int[] d : dp)
            Arrays.fill(d, -1);
        int result = solve(dp, arr, 0, 0, n);
        return result >= (int)1E9 ? -1 : result;
    }
    private static int solve(int[][] dp, int[][] arr, int idx, int maxEnd, int n) {
        if (maxEnd >= n) return 0; // garden covered, no need to open any other tap

        if (idx >= arr.length || arr[idx][0] > maxEnd) // out of bound or current tap cannot cover till next start point
            return (int)1E9;

        if (dp[idx][maxEnd] != -1) return dp[idx][maxEnd];

        int skip = solve(dp, arr, idx+1, maxEnd, n);
        int open = 1 + solve(dp, arr, idx+1, Math.max(maxEnd, arr[idx][1]), n);

        return dp[idx][maxEnd] = Math.min(open, skip);
    }
    public static int minTapsOptimized(int n, int[] ranges) {
        // Array to store the farthest point that each tap can cover
        int[] maxRange = new int[n + 1];

        // Fill the maxRange array: maxRange[i] will store the farthest point that tap i can water
        for (int i = 0; i <= n; i++) {
            int start = Math.max(0, i - ranges[i]);
            int end = Math.min(n, i + ranges[i]);
            maxRange[start] = Math.max(maxRange[start], end);
        }

        // Initialize variables
        int tapsOpen = 0, currentEnd = 0, farthest = 0;
        // Iterate over the garden
        for (int i = 0; i <= n; i++) {
            // If we reach a point that cannot be watered, return -1
            if (i > farthest) return -1;

            // Extend the farthest point covered if necessary
            farthest = Math.max(farthest, maxRange[i]);
            // If we reach the current end of the watered range, open another tap
            if (i == currentEnd) {
                tapsOpen++;
                currentEnd = farthest;

                if (currentEnd >= n) break;
            }
        }
        return tapsOpen;
    }
    public static void main(String[] args) {
        System.out.println(minTaps(5, new int[]{3,4,1,1,0,0}));
        System.out.println(minTaps(3, new int[]{0,0,0,0}));
    }
}
