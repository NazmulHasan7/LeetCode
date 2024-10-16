// 1406. Stone Game III
package Hard;
import java.util.Arrays;

public class Hard_1406_Stone_Game_III {
    // Recursion + Memoization -> TC & SC -> O(n)
    public static String stoneGameIII(int[] stoneValue) {
        int n = stoneValue.length;
        int[] dp = new int[n+1];
        Arrays.fill(dp, Integer.MIN_VALUE);

        int aliceScore = aliceScore(dp, stoneValue, 0, n);
        if (aliceScore > 0) return "Alice";
        else if (aliceScore < 0) return "Bob";
        return "Tie";
    }
    private static int aliceScore(int[] dp, int[] stones, int idx, int n) {
        // The function returns the score of Alice in terms of Bob
        if (idx >= n) return 0;

        if (dp[idx] != Integer.MIN_VALUE)
            return dp[idx];

        // returns as -> draw a tree diagram -> the sign changes for each recursive call
        // + Alice's turn, - for Bob's turn
        // Alice has 3 options to pick
        int pickOne = stones[idx] - aliceScore(dp, stones, idx+1, n);
        int pickTwo = Integer.MIN_VALUE, pickThree = Integer.MIN_VALUE;
        if (idx + 1 < n)
            pickTwo = stones[idx] + stones[idx+1] - aliceScore(dp, stones, idx+2, n);
        if (idx + 2 < n)
            pickThree = stones[idx] + stones[idx+1] + stones[idx+2] - aliceScore(dp, stones, idx+3, n);

        return dp[idx] = Math.max(pickOne, Math.max(pickTwo, pickThree));
    }
    // Tabulation Approach
    public static String stoneGameIIITabulation(int[] stoneValue) {
        int n = stoneValue.length;
        int[] dp = new int[n+1];

        for (int i=n-1; i>=0; i--) {
            dp[i] = stoneValue[i] - dp[i+1];
            if (i+2 <= n)
                dp[i] = Math.max(dp[i], stoneValue[i] + stoneValue[i+1] - dp[i+2]);
            if (i+3 <= n)
                dp[i] = Math.max(dp[i], stoneValue[i] + stoneValue[i+1] + stoneValue[i+2] - dp[i+3]);
        }
        int diff = dp[0];
        if (diff > 0) return "Alice";
        else if (diff < 0) return "Bob";
        return "Tie";
    }
    public static void main(String[] args) {
        System.out.println(stoneGameIII(new int[]{1,2,3,7}));
        System.out.println(stoneGameIII(new int[]{1,2,3,-9}));
        System.out.println(stoneGameIII(new int[]{1,2,3,6}));
    }
}
