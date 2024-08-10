// 1332. Remove Palindromic Subsequences
package Easy;

public class Easy_1332_Remove_Palindromic_Subsequences {
    // Subsequence string - String after removing some characters
    public static boolean isPalindrome (String s) {
        int start = 0, end = s.length()-1;
        while (start < end)
            if (s.charAt(start++) != s.charAt(end--))
                return false;
        return true;
    }
    public static int removePalindromeSub(String s) {
        // Case 1: When the string is empty
        if (s.isEmpty()) return 0;
            // Case 2: If the string itself is palindrome
        else if (isPalindrome(s)) return 1;
            // Case 3: Since only 2 characters, sort -> aaaa bbbb
        else return 2;
    }
    public static void main(String[] args) {
        System.out.println(removePalindromeSub("ababa"));
        System.out.println(removePalindromeSub("abb"));
        System.out.println(removePalindromeSub("baabb"));
    }
}
