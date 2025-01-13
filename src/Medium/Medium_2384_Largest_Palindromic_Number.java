// 2384. Largest Palindromic Number
package Medium;

public class Medium_2384_Largest_Palindromic_Number {
    // TC -> O(N), SC -> O(N)
    public static String largestPalindromic(String num) {
        // For the largest palindrome -> even counts at the both end, odd counts in the middle
        int[] digitCount = new int[10];
        for (char c : num.toCharArray())
            digitCount[c-'0']++;

        // Traverse from the right to left -> higher to lower digits
        char maxOddDigit = '\0';

        StringBuilder sb = new StringBuilder();
        for (int i=9; i>=0; i--) {
            if (digitCount[i] > 0) {
                if ((digitCount[i] & 1) == 1) {
                    // Want to put the maximum digit with odd occurrence in the middle
                    if (maxOddDigit == '\0')
                        maxOddDigit = (char) ('0' + i);
                    // Use one occurrence of the odd-count digit
                    digitCount[i]--;
                }
            }
            // Add even counts (half of each for mirroring)
            sb.append(String.valueOf((char) ('0'+i)).repeat(digitCount[i]/2));
        }

        // If the leading number is 0, the result is also expected to be 0 (ignoring the max odd)
        // Because 0 was expected to be at the end of mirror string
        if (!sb.isEmpty() && sb.charAt(0) == '0')
            sb = new StringBuilder();

        StringBuilder rev = new StringBuilder(sb).reverse();

        if (maxOddDigit != '\0')
            sb.append(maxOddDigit);

        if (sb.isEmpty()) return "0";
        return String.valueOf(sb.append(rev));
    }
    public static void main(String[] args) {
        System.out.println(largestPalindromic("444947137"));
        System.out.println(largestPalindromic("00009"));
    }
}
