// 392. Is Subsequence
package Easy;

public class Easy_392_Is_Subsequence {
    public static boolean isSubsequence(String s, String t) {
        int sLength = s.length(), tLength = t.length();
        int i=0, j=0;
        while (i<tLength && j<sLength) {
            if (t.charAt(i) == s.charAt(j)) j++;
            i++;
        } return j == sLength;
    }
    public static void main(String[] args) {
        System.out.println(isSubsequence("abc", "ahbgdc"));
        System.out.println(isSubsequence("axc", "ahbgdc"));
    }
}
