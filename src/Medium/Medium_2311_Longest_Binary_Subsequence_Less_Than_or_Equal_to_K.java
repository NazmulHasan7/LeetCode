// 2311. Longest Binary Subsequence Less Than or Equal to K
package Medium;
import java.util.HashMap;

public class Medium_2311_Longest_Binary_Subsequence_Less_Than_or_Equal_to_K {
     public int longestSubsequence(String s, int k) {
         int n = s.length();
         return solve(s.toCharArray(), 0, n, k, 0, new HashMap<String, Integer>());
     }
     private static int solve(char[] crr, int idx, int n, int k, int number, HashMap<String, Integer> dp) {
         if (idx == n) return 0; // out of bound

         String key = idx + "_" + number;
         if (dp.containsKey(key)) dp.get(key);

         int skip = solve(crr, idx+1, n, k, number, dp);

         int take = 0;
         if (crr[idx] == '1') {
             int newNumber = (number << 1) + 1;
             if (newNumber <= k)
                 take = 1 + solve(crr, idx+1, n, k, newNumber, dp);
         } else {
             int newNumber = number << 1;
             if (newNumber <= k)
                 take = 1 + solve(crr, idx+1, n, k, newNumber, dp);
         }
         int answer = Math.max(take, skip);
         dp.put(key, answer);
         return answer;
     }
    public static int longestSubsequenceOpt(String s, int k) {
        int n = s.length();
        int number = 0;
        int zeroCount = 0, oneCount = 0;

        for (int i=n-1; i>=0; i--) {
            char c = s.charAt(i);
            if (c == '0') {
                zeroCount++;
            } else {
                number = (int) (number + Math.pow(2, (n-i-1)));
                if (number <= k)
                    oneCount++;
            }
        }
        return zeroCount + oneCount;
    }
    public static void main(String[] args) {
        System.out.println(longestSubsequenceOpt("1001010", 5));
        System.out.println(longestSubsequenceOpt("00101001", 1));
    }
}
