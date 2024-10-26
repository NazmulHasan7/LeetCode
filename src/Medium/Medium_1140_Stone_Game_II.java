// 1140. Stone Game II
package Medium;
import java.util.Arrays;

public class Medium_1140_Stone_Game_II {
    public static int stoneGameII(int[] piles) {
        int M = 1;
        int n = piles.length;

        int[][][] dp = new int[n+1][n+1][2];
        for (int[][] dr : dp)
            for (int[] d : dr)
                Arrays.fill(d, -1);

        return solveForAlice(dp, piles, 0, n, M, 1);
    }
    private static int solveForAlice(int[][][] dp, int[] piles, int idx, int n, int M, int aliceTurn) {
        if (idx == n) return 0; // out of bound

        if (dp[idx][M][aliceTurn] != -1)
            return dp[idx][M][aliceTurn];

        int stones = 0;
        int result = aliceTurn == 1 ? -1 : Integer.MAX_VALUE;

        for (int x=1; x<=Math.min(2*M, n-idx); x++) {
            stones += piles[idx + x - 1];
            if (aliceTurn == 1) {
                // Since we are solving for alice, we want to maximize her score
                result = Math.max(result, stones + solveForAlice(dp, piles, idx+x, n, Math.max(x, M), 0));
            } else {
                // Bob's turn, since we are solving for alice, Bob will always try to minimize alice's score
                result = Math.min(result, solveForAlice(dp, piles, idx+x, n, Math.max(x, M), 1));
            }
        } return dp[idx][M][aliceTurn] = result;
    }
    public static void main(String[] args) {
        System.out.println(stoneGameII(new int[]{2,7,9,4,4}));
        System.out.println(stoneGameII(new int[]{1,2,3,4,5,100}));
    }
}
