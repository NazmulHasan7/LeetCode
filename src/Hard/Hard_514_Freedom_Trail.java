// 514. Freedom Trail
package Hard;
import java.util.Arrays;

public class Hard_514_Freedom_Trail {
    public static int findRotateSteps(String ring, String key) {
        int[][] dp = new int[ring.length()+1][key.length()+1];
        for (int[] d : dp)
            Arrays.fill(d, Integer.MAX_VALUE);
        return solve(dp, ring.toCharArray(), key.toCharArray(), 0, 0);
    }
    private static int solve(int[][] dp, char[] ring, char[] key, int ringIndex, int keyIndex) {
        if (keyIndex >= key.length)
            return 0; // out of bound

        if (dp[ringIndex][keyIndex] != Integer.MAX_VALUE)
            return dp[ringIndex][keyIndex];

        int answer = Integer.MAX_VALUE;
        for (int i=0; i<ring.length; i++) {
            if (key[keyIndex] == ring[i]) {
                int antiClockWise = Math.abs(ringIndex - i);
                int clockWise = ring.length - antiClockWise;
                answer = Math.min(answer, 1 + Math.min(antiClockWise, clockWise) + solve(dp, ring, key, i, keyIndex+1));
            }
        }
        return dp[ringIndex][keyIndex] = answer;
    }
    public static void main(String[] args) {
        System.out.println(findRotateSteps("godding", "gd"));
        System.out.println(findRotateSteps("godding", "godding"));
    }
}
