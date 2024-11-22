// 978. Longest Turbulent Subarray
package Medium;
import java.util.Arrays;

public class Medium_978_Longest_Turbulent_Subarray {
    // Recursion + Memoization, TC & SC O(2n) -> O(n)
    public static int maxTurbulenceSize(int[] arr) {
        int n = arr.length;
        int[][] dp = new int[n+1][2];
        for (int[] d : dp) Arrays.fill(d, -1);

        int answer = 0;
        for (int i=0; i<n; i++)
            answer = Math.max(answer,
                    Math.max(solve(dp, arr, i+1, n, 0), solve(dp, arr, i+1, n, 1)));

        return answer + 1;
    }
    private static int solve(int[][] dp, int[] arr, int idx, int n, int flag) {
        if (idx >= n) return 0;
        if (dp[idx][flag] != -1) return dp[idx][flag];

        int size = 0;
        if (flag == 0) {
            if (arr[idx] >= arr[idx-1]) return 0;
            size = 1 + solve(dp, arr, idx+1, n, 1);
        } else {
            if (arr[idx] <= arr[idx-1]) return 0;
            size = 1 + solve(dp, arr, idx+1, n, 0);
        }
        dp[idx][flag] = size;
        return size;
    }
    // Sliding window approach
    public static int maxTurbulenceSizeOpt(int[] arr) {
        int n = arr.length;
        int maxLen = 1, left = 0, right = 1;
        char prev = '=';

        while (right < n) {
            if (arr[right-1] < arr[right]) {
                if (prev == '>' || prev == '=')
                    maxLen = Math.max(maxLen, right-left+1);
                else left = right - 1;
                prev = '<';
            }
            else if (arr[right-1] > arr[right]) {
                if (prev == '<' || prev == '=')
                    maxLen = Math.max(maxLen, right-left+1);
                else left = right - 1;
                prev = '>';
            }
            else {
                prev = '=';
                left = right;
            }
            right++;
        }
        return maxLen;
    }
    public static void main(String[] args) {
        System.out.println(maxTurbulenceSizeOpt(new int[]{9,4,2,10,7,8,8,1,9}));
        System.out.println(maxTurbulenceSizeOpt(new int[]{4,8,12,16}));
        System.out.println(maxTurbulenceSizeOpt(new int[]{100}));
    }
}