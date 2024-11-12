// 292. Nim Game
package Easy;

public class Easy_292_Nim_Game {
    // MLE
    public static boolean canWinNim(int n) {
        // Boolean[] dp = new Boolean[n+1];
        // return solve(n, dp);
        return n % 4 != 0;
    }
    private static boolean solve(int n, Boolean[] dp) {
        if (n <= 3) return true;
        if (n == 4) return false;

        if (dp[n] != null) return dp[n];
        // If the opponent cannot win in any of my moves, then I win
        return dp[n] = !solve(n-1,dp) || !solve(n-2,dp) || !solve(n-3,dp);
    }
    public static void main(String[] args) {
        System.out.println(canWinNim(4));
        System.out.println(canWinNim(1));
        System.out.println(canWinNim(2));
        System.out.println(canWinNim(5));
        System.out.println(canWinNim(8));
    }
}
