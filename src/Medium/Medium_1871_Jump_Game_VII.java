// 1871. Jump Game VII
package Medium;

public class Medium_1871_Jump_Game_VII {
    public static boolean canReach(String s, int minJump, int maxJump) {
        int n = s.length();
        int cnt = 0;

        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == '1'){
                cnt++;
                if(cnt >= maxJump) return false;
            }
            else{
                cnt = 0;
            }
        }
        Boolean[] dp = new Boolean[n+1];
        return solve(dp, s.toCharArray(), 0, n-1, minJump, maxJump);
    }
    private static boolean solve(Boolean[] dp, char[] crr, int idx, int target, int minJump, int maxJump) {
        if (idx > target || crr[idx] == '1') return false;
        if (idx == target) return true;

        if (dp[idx] != null) return dp[idx];

        for (int i=minJump; i<=maxJump; i++) {
            if(solve(dp, crr, idx + i, target, minJump, maxJump))
                return dp[idx] = true;
        }
        return dp[idx] = false;
    }
    public static boolean canReachOpt(String s, int minJump, int maxJump) {
        int n = s.length();
        if (s.charAt(n-1) == '1') return false;

        boolean[] dp = new boolean[n];
        dp[0] = true; // dp[i] -> true if we can reach the index i

        int start = 0, end = 0;
        for (int i=0; i<n; i++) {
            if (!dp[i]) continue; // cannot reach index i

            start = Math.max(i+minJump, end+1);
            end = Math.min(n-1, i+maxJump);

            for (int j=start; j<=end; j++) {
                if (s.charAt(j) == '0')
                    dp[j] = true;
            }

            if (dp[n-1]) return true;
        }
        return dp[n-1];
    }
    public static void main(String[] args) {
        System.out.println(canReach("011010",2,3));
        System.out.println(canReach("01101110",2,3));
    }
}
