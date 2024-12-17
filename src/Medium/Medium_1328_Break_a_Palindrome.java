// 1328. Break a Palindrome
package Medium;

public class Medium_1328_Break_a_Palindrome {
    public static String breakPalindrome(String palindrome) {
        char[] crr = palindrome.toCharArray();
        int n = crr.length;
        if (n < 2) return "";

        // Since the string is palindrome we need to check till the mid-point only
        for (int i=0; i<n/2; i++) {
            if (crr[i] != 'a') {
                // Looking for the lexicographically smallest string
                crr[i] = 'a'; // Find the first non 'a' character and replace it with 'a'
                return String.valueOf(crr);
            }
        }
        // No 'a' found till the mid-point -> aaayaaa, aaaa
        // Set the last character to 'b'
        crr[n-1] = 'b';
        return String.valueOf(crr);
    }
    public static void main(String[] args) {
        System.out.println(breakPalindrome("abccba"));
        System.out.println(breakPalindrome("a"));
    }
}
