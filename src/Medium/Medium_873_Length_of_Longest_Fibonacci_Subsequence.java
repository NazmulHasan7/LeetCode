// 873. Length of Longest Fibonacci Subsequence
package Medium;
import java.util.HashMap;
import java.util.HashSet;

public class Medium_873_Length_of_Longest_Fibonacci_Subsequence {
    // Recursion + Memoization -> TLE
    // TC -> O(n), SC -> O(n)
    public static int lenLongestFibSubseq(int[] arr) {
        int n = arr.length;
        int answer = solve(arr, 0, n, -1, -1, new HashMap<String, Integer>());
        return answer < 3 ? 0 : answer;
    }
    private static int solve(int[] arr, int idx, int n, int prev1, int prev2, HashMap<String, Integer> dp) {
        if (idx >= n) return 0; // out of bound

        String key = idx + "_" + prev1 + "_" + prev2;
        if (dp.containsKey(key))
            return dp.get(key);

        int take = 0, skip = 0;
        if (prev1 == -1 || prev2 == -1 || prev1 + prev2 == arr[idx]) {
            // follows the fibonacci sequence, we have two options
            skip = solve(arr, idx+1, n, prev1, prev2, dp);
            take = 1 + solve(arr, idx+1, n, prev2, arr[idx], dp);
        } else {
            // as it does not follow the sequence, we only have the option to skip
            skip = solve(arr, idx+1, n, prev1, prev2, dp);
        }
        int answer = Math.max(take, skip);
        dp.put(key, answer);
        return answer;
    }

    // Working code
    // TC -> O(n^2) SC -> O(n)
    public static int lenLongestFibSubseqOpt(int[] arr) {
        int n = arr.length;

        HashSet<Integer> set = new HashSet<>();
        for (int x : arr) set.add(x);

        int answer = 0;
        for (int i=0; i<n; i++) {
            for (int j=i+1; j<n; j++) {

                int prev1 = arr[i];
                int prev2 = arr[j];
                int currLen = 2;

                while (set.contains(prev1 + prev2)) {
                    prev2 = prev1 + prev2;
                    prev1 = prev2 - prev1;
                    currLen++;
                }

                answer = Math.max(answer, currLen);
            }
        }
        return answer < 3 ? 0 : answer;
    }
    public static void main(String[] args) {
        System.out.println(lenLongestFibSubseq(new int[]{1,2,3,4,5,6,7,8}));
        System.out.println(lenLongestFibSubseq(new int[]{1,3,7,11,12,14,18}));
    }
}
