// 1510. Stone Game IV
package Hard;

public class Hard_1510_Stone_Game_IV {
    public static boolean winnerSquareGame(int n) {
        Boolean[] dp = new Boolean[n+1];
        return solve(dp, n);
    }
    private static boolean solve(Boolean[] dp, int n) {
        if (n <= 0) return false; // the player cannot move

        if (dp[n] != null) return dp[n];

        for (int i = 1; i*i <= n; i++) {
            // think in terms of alice's perspective
            // alice chooses a square number
            // now bob has to choose a square number between n - alice's number
            // if bob cannot make a move -> alice wins
            int opponent = n - i*i;
            if (!solve(dp, opponent))
                return dp[n] = true;
        }
        return dp[n] = false;
    }
    public static void main(String[] args) {
        System.out.println(winnerSquareGame(1));
        System.out.println(winnerSquareGame(2));
        System.out.println(winnerSquareGame(4));
    }
}
