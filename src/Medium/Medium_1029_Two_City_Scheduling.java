// 1029. Two City Scheduling
package Medium;
import java.util.Arrays;
import java.util.Comparator;

public class Medium_1029_Two_City_Scheduling {
    // Recursion + Memoization
    public static int twoCitySchedCost(int[][] costs) {
        int n = costs.length / 2;
        int[][] dp = new int[n+1][n+1];
        for(int[] d : dp) Arrays.fill(d,-1);
        return solve(costs, dp, 0, 0, 0, n);
    }
    private static int solve(int[][] costs, int[][] dp, int idx, int personInA, int personInB, int maxPersons) {
        if (personInA == maxPersons && personInB == maxPersons)
            return 0; // all candidates are directed to the respective cities

        if (dp[personInA][personInB] != -1) return dp[personInA][personInB];

        int answer = Integer.MAX_VALUE;
        if (personInA < maxPersons) // send this candidate to city A
            answer = Math.min(answer, costs[idx][0] + solve(costs, dp, idx+1, personInA+1, personInB, maxPersons));

        if (personInB < maxPersons) // send this candidate to city B
            answer = Math.min(answer, costs[idx][1] + solve(costs, dp, idx+1, personInA, personInB+1, maxPersons));

        return dp[personInA][personInB] = answer;
    }
    // Optimized Approach
    public static int twoCitySchedCostOpt(int[][] costs) {
        Arrays.sort(costs, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                int costA = a[1] - a[0];
                int costB = b[1] - b[0];
                return costB - costA;
            }
        });
        int n = costs.length / 2;
        int answer = 0;
        for (int i=0; i<n; i++)
            answer += costs[i][0] + costs[i+n][1];

        return answer;
    }
    public static void main(String[] args) {
        System.out.println(twoCitySchedCost(new int[][]{{10,20},{30,200},{400,50},{30,20}}));
        System.out.println(twoCitySchedCost(new int[][]{{259,770},{448,54},{926,667},{184,139},{840,118},{577,469}}));
        System.out.println(twoCitySchedCost(new int[][]{{515,563},{451,713},{537,709},{343,819},{855,779},{457,60},{650,359},{631,42}}));
    }
}
