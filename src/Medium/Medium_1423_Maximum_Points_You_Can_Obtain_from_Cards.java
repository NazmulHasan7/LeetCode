// 1423. Maximum Points You Can Obtain from Cards
package Medium;
import java.util.Arrays;

public class Medium_1423_Maximum_Points_You_Can_Obtain_from_Cards {
    // TC & SC -> O(n^2 * k) -> TLE, MLE
    public static int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int[][][] memo = new int[n][n][k + 1];
        for (int[][] twoD : memo) {
            for (int[] oneD : twoD) {
                Arrays.fill(oneD, -1);
            }
        }
        return solve(cardPoints, 0, n - 1, k, memo);
    }
    private static int solve(int[] card, int left, int right, int k, int[][][] memo) {
        if (k == 0) return 0;
        if (left > right) return 0;

        if (memo[left][right][k] != -1) return memo[left][right][k];

        int pickLeft = card[left] + solve(card, left + 1, right, k - 1, memo);
        int pickRight = card[right] + solve(card, left, right - 1, k - 1, memo);

        return memo[left][right][k] = Math.max(pickLeft, pickRight);
    }

    // Optimized Approach -> Sliding window technique
    // Since we are allowed to take either from start or from end
    public static int maxScoreOpt(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int leftSum = 0;
        for (int i=0; i<k; i++) leftSum += cardPoints[i];

        // Now keep removing from latest elements from left sum and keep adding from end
        int maxSum = leftSum;
        int rightSum = 0, right = n-1;
        while (--k >= 0) {
            leftSum -= cardPoints[k];
            rightSum += cardPoints[right];
            right--;
            maxSum = Math.max(maxSum, leftSum + rightSum);
        }

        return maxSum;
    }
    public static void main(String[] args) {
        System.out.println(maxScoreOpt(new int[]{1,2,3,4,5,6,1},3));
        System.out.println(maxScoreOpt(new int[]{2,2,2},2));
        System.out.println(maxScoreOpt(new int[]{9,7,7,9,7,7,9},7));
    }
}
