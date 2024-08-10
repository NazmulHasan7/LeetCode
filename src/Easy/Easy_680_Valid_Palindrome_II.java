// 680. Valid Palindrome II
package Easy;

public class Easy_680_Valid_Palindrome_II {
    public static boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start) != s.charAt(end))
                return false;
            start++;
            end--;
        } return true;
    }
    public static boolean validPalindrome(String s) {
        int start = 0, end = s.length() - 1, count = 0;
        while (start <= end) {
            if (s.charAt(start) != s.charAt(end)) {
                // Try deleting the character at start index
                if (isPalindrome(s, start+1, end)) return true;
                    // Try deleting the character at end index
                else if (isPalindrome(s, start, end-1)) return true;
                    // Neither deletion work, it cannot be made palindrome
                else return false;
            }
            start++;
            end--;
        } return true;
    }
    public static void main(String[] args) {
        System.out.println(validPalindrome("aba"));
        System.out.println(validPalindrome("abca"));
        System.out.println(validPalindrome("abc"));
        System.out.println(validPalindrome("cbbcc"));
    }
}
