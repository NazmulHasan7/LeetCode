// 1653. Minimum Deletions to Make String Balanced
package Medium;

public class Medium_1653_Minimum_Deletions_to_Make_String_Balanced {
    public static int minimumDeletions(String s) {
        int countB = 0, ops = 0;
        for (char c : s.toCharArray()) {
            if (c == 'a') {
                // If any b appears before a remove it  and count operations
                if (countB > 0) {
                    ops++;
                    countB--;
                }
            } else countB++;
        } return ops;
    }
    public static int minimumDeletionsStack(String s) {
        int stackPtr = -1, ops = 0;
        for (char c : s.toCharArray()) {
            if (c == 'b') {
                stackPtr++;
            } else if (stackPtr >= 0) {
                ops++;
                stackPtr--;
            }
        } return ops;
    }
    public static void main(String[] args) {
        System.out.println(minimumDeletions("aababbab"));
        System.out.println(minimumDeletions("bbaaaaabb"));
        System.out.println(minimumDeletionsStack("aababbab"));
        System.out.println(minimumDeletionsStack("bbaaaaabb"));
    }
}
