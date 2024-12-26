// 2120. Execution of All Suffix Instructions Staying in a Grid
package Medium;
import java.util.Arrays;

public class Medium_2120_Execution_of_All_Suffix_Instructions_Staying_in_a_Grid {
    public static int[] executeInstructions(int n, int[] startPos, String s) {
        int m = s.length();
        int[] answer = new int[m];

        for (int i=0; i<m; i++)
            answer[i] = solve(startPos[0], startPos[1], n, i, s.toCharArray());

        return answer;
    }
    private static int solve(int r, int c, int n, int idx, char[] crr) {
        if (r < 0 || c < 0 || r >= n || c >= n || idx >= crr.length)
            return 0; // out of bound

        int count = 0;
        if (crr[idx] == 'L' && c > 0)
            count += 1 + solve(r, c-1, n, idx+1, crr);
        else if (crr[idx] == 'R' && c < n-1)
            count += 1 + solve(r, c+1, n, idx+1, crr);
        else if (crr[idx] == 'U' && r > 0)
            count += 1 + solve(r-1, c, n, idx+1, crr);
        else if (crr[idx] == 'D' && r < n-1)
            count += 1 + solve(r+1, c, n, idx+1, crr);

        return count;
    }
    public static int[] executeInstructionsBetter(int n, int[] startPos, String s) {
        int m = s.length();
        char[] crr = s.toCharArray();
        int[] answer = new int[m];

        for (int i=0; i<m; i++) {
            int r = startPos[0];
            int c = startPos[1];
            int count = 0;

            for (int j=i; j<m; j++) {
                switch (crr[j]) {
                    case 'L' -> c--;
                    case 'R' -> c++;
                    case 'U' -> r--;
                    case 'D' -> r++;
                }
                if (r < 0 || c < 0 || r >= n || c >= n)
                    break;
                else count++;
            }
            answer[i] = count;
        }
        return answer;
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(executeInstructions(3, new int[]{0,1}, "RRDDLU")));
        System.out.println(Arrays.toString(executeInstructions(2, new int[]{1,1}, "LURD")));
        System.out.println(Arrays.toString(executeInstructions(1, new int[]{0,0}, "LRUD")));
    }
}
