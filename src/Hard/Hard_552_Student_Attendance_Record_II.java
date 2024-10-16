// 552. Student Attendance Record II
package Hard;
import java.util.Arrays;

public class Hard_552_Student_Attendance_Record_II {
    // Recursion + Memoization -> O(n*2*3) = O(n) for both time and space
    private static final int M = 1000000007;
    public static int checkRecord(int n) {
        int[][][] dp = new int[n + 1][2][3];
        for (int[][] dr : dp)
            for (int[] dc : dr)
                Arrays.fill(dc, -1);
        return solve(dp, n, 0, 0);
    }
    private static int solve(int[][][] dp, int n, int absent, int consLate) {
        if (absent >= 2) return 0; // student cannot be absent for more than a day
        if (consLate >= 3) return 0; // student cannot be consecutive late for 3 or more days
        if (n == 0) return 1; // days length reached

        if (dp[n][absent][consLate] != -1)
            return dp[n][absent][consLate];

        int A = solve(dp, n - 1, absent + 1, 0) % M; // Absent, reset consecutive late
        int L = solve(dp, n - 1, absent, consLate + 1) % M; // Late, increase consecutive late
        int P = solve(dp, n - 1, absent, 0) % M; // Present, reset consecutive late

        return dp[n][absent][consLate] = ((A + L) % M + P) % M;
    }
    // Tabulation Approach -> Just converted the Recursion code to the Tabulation code
    public static int checkRecordTabulation(int n) {
        int[][][] dp = new int[n+1][2][3];
        // Base case: when n = 0, days = 0
        for (int A=0; A<=1; A++)
            for (int L=0; L<=2; L++)
                dp[0][A][L] = 1;

        for (int i=1; i<=n; i++) {
            for (int A=0; A<=1; A++) {
                for (int L=0; L<=2; L++) {
                    int present = dp[i-1][A][0] % M;
                    int absent = A + 1 <= 1 ? dp[i-1][A+1][0] % M : 0;
                    int late = L + 1 <= 2 ? dp[i-1][A][L+1] % M : 0;

                    dp[i][A][L] = ((present + absent) % M + late) % M;
                }
            }
        } return dp[n][0][0];
    }
    public static void main(String[] args) {
        System.out.println(checkRecord(2));
        System.out.println(checkRecord(1));
        System.out.println(checkRecord(10101));
    }
}
