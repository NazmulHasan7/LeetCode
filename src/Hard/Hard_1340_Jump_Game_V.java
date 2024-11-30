// 1340. Jump Game V
package Hard;

public class Hard_1340_Jump_Game_V {
    public static int maxJumps(int[] arr, int d) {
        int n = arr.length;
        int maxVisits = 0;

        int[] dp = new int[n];
        for (int i=0; i<n; i++)
            maxVisits = Math.max(maxVisits, solve(dp, arr, i, d, n));

        return maxVisits;
    }
    private static int solve(int[] dp, int[] arr, int idx, int d, int n) {
        if (dp[idx] != 0) return dp[idx];

        int count = 1;
        // Go to index - 1 .......... index - d
        for (int j=idx-1; j>=Math.max(0, idx-d) && arr[idx] > arr[j]; j--)
            count = Math.max(count, 1 + solve(dp, arr, j, d, n));

        // Go to index + 1 ............ index + d
        for (int j=idx+1; j<=Math.min(n-1, idx+d) && arr[idx] > arr[j]; j++)
            count = Math.max(count, 1 + solve(dp, arr, j, d, n));

        return dp[idx] = count;
    }
    public static void main(String[] args) {
        System.out.println(maxJumps(new int[]{6,4,14,6,8,13,9,7,10,6,12},2));
        System.out.println(maxJumps(new int[]{3,3,3,3,3},3));
        System.out.println(maxJumps(new int[]{7,6,5,4,3,2,1},1));
    }
}
