// 2697. Lexicographically Smallest Palindrome
package Easy;

public class Easy_2697_Lexicographically_Smallest_Palindrome {
    public static String makeSmallestPalindrome(String s) {
        int start = 0, end = s.length()-1;
        char[] cArr = s.toCharArray();
        while (start < end) {
            cArr[start] = cArr[end] = (char) Math.min(cArr[start], cArr[end]);
            start++; end--;
        } return new String(cArr);
    }
    public static void main(String[] args) {
        System.out.println(makeSmallestPalindrome("egcfe"));
        System.out.println(makeSmallestPalindrome("abcd"));
        System.out.println(makeSmallestPalindrome("seven"));
    }
}
