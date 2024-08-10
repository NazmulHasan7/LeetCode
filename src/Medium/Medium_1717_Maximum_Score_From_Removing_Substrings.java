// 1717. Maximum Score From Removing Substrings
package Medium;

public class Medium_1717_Maximum_Score_From_Removing_Substrings {
    public static int maximumGain(String s, int x, int y) {
        // if x > y --> remove ab else remove ba
        boolean removeAB = x > y;
        // Using a stack like data structure
        char[] stack = new char[s.length()];
        int stackPtr = -1;

        int answer = 0;
        if (removeAB) {
            // Check for the 'ab'
            for (char c : s.toCharArray()) {
                if (stackPtr > -1 && stack[stackPtr] == 'a' && c == 'b') {
                    stackPtr--;
                    answer += x;
                } else stack[++stackPtr] = c;
            }
            // Now check for the remaining 'ba'
            int n = stackPtr;
            stackPtr = -1;
            for (int i=0; i<=n; i++) {
                if (stackPtr > -1 && stack[stackPtr] == 'b' && stack[i] == 'a') {
                    answer += y;
                    stackPtr--;
                } else stack[++stackPtr] = stack[i];
            }
        } else {
            // Check for 'ba'
            for (char c : s.toCharArray()) {
                if (stackPtr > -1 && stack[stackPtr] == 'b' && c == 'a') {
                    stackPtr--;
                    answer += y;
                } else stack[++stackPtr] = c;
            }
            // Now check for the remaining 'ab'
            int n = stackPtr;
            stackPtr = -1;
            for (int i=0; i<=n; i++) {
                if (stackPtr > -1 && stack[stackPtr] == 'a' && stack[i] == 'b') {
                    answer += x;
                    stackPtr--;
                } else stack[++stackPtr] = stack[i];
            }
        } return answer;
    }
    public static void main(String[] args) {
        System.out.println(maximumGain("cdbcbbaaabab", 4, 5));
        System.out.println(maximumGain("aabbaaxybbaabb", 5, 4));
    }
}
