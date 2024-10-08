// 877. Stone Game
package Medium;
import java.util.Arrays;

public class Medium_877_Stone_Game {
    public boolean stoneGame(int[] piles) {
        return true;
    }
    public static boolean stoneGameDP(int[] piles) {
        int n = piles.length;
        int[][] dp = new int[n+1][n+1];
        for(int[] d : dp) Arrays.fill(d,-1);
        // true -> Alice's turn, false -> Bob's turn
        int aliceScore = maxAliceScore(dp, piles, 0, n-1, true);

        int sum = 0;
        for (int p : piles) sum += p;
        return aliceScore > sum - aliceScore;
    }
    private static int maxAliceScore(int[][] dp, int[] piles, int start, int end, boolean aliceTurn) {
        if (start > end) return 0;
        if (dp[start][end] != -1) return dp[start][end];

        if (aliceTurn) {
            // Alice's turn: maximize her score by picking from start or end
            int fromStart = piles[start] + maxAliceScore(dp, piles, start+1, end, false);
            int fromEnd = piles[end] + maxAliceScore(dp, piles, start, end-1, false);
            dp[start][end] = Math.max(fromEnd, fromStart);
        } else {
            // Bobs initial goal is to make alice's future score as low as possible
            int fromStart = maxAliceScore(dp, piles, start+1, end, true);
            int fromEnd = maxAliceScore(dp, piles, start, end-1, true);
            dp[start][end] = Math.min(fromStart, fromEnd);
        }
        return dp[start][end];
    }
    public static void main(String[] args) {
        System.out.println(stoneGameDP(new int[]{5,3,4,5}));
        System.out.println(stoneGameDP(new int[]{3,7,2,3}));
    }
}
