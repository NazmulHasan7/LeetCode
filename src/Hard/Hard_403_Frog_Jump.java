// 403. Frog Jump
package Hard;
import java.util.HashMap;

public class Hard_403_Frog_Jump {
    private static HashMap<Integer, Integer> map;

    public static boolean canCross(int[] stones) {
        if (stones[1] != 1) return false;
        map = new HashMap<>();
        int n = stones.length;

        for (int i=0; i<n; i++)
            map.put(stones[i], i);

        return solve(stones, 1, n, 1, new Boolean[n+1][n+1]);
    }

    private static boolean solve(int[] stones, int idx, int n, int prevJump, Boolean[][] dp) {
        if (idx == n-1) return true; // reached the end of the river
        if (idx >= n) return false; // out of bound

        if (dp[idx][prevJump] != null) return dp[idx][prevJump];

        // the frog can jump k-1, k, k+1 units
        boolean answer = false;
        for (int nextJump = prevJump-1; nextJump <= prevJump+1; nextJump++) {
            if (nextJump > 0) {
                // since the frog can only jump in the forward direction
                int nextStone = stones[idx] + nextJump;
                if (map.containsKey(nextStone)) // get the index of next jump
                    answer = solve(stones, map.get(nextStone), n, nextJump, dp);
                if (answer) break;
            }
        }
        return dp[idx][prevJump] = answer;
    }
    public static void main(String[] args) {
        System.out.println(canCross(new int[]{0,1,3,5,6,8,12,17}));
        System.out.println(canCross(new int[]{0,1,2,3,4,8,9,11}));
    }
}
