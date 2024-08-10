// 1616. Split Two Strings to Make Palindrome
package Medium;

public class Medium_1616_Split_Two_Strings_to_Make_Palindrome {
    private static boolean isPalindrome(String s, int start, int end){
        System.out.println("In palindrome check -> " + s.substring(start, end+1));
        while (start < end) {
            if (s.charAt(start) != s.charAt(end))
                return false;
            start++;
            end--;
        } return true;
    }
    private static boolean check(String a, String b) {
        System.out.println("In check -> " + a + " " + b);
        int start = 0, end = a.length()-1;
        // When a[start] != b[end], we get a split index
        while (start < end && a.charAt(start) == b.charAt(end)) {
            start++; end--;
        }
        /* Consider test case =>
            a => pvhmupgqeltozftlmfjjde
            b => yjgpzbezspnnpszebzmhvp
        split position 3, since a[0,3] == reverse(b[n-1,n-4])
            a-prefix = pvhm
            a-suffix = upgqeltozftlmfjjde
            b-prefix = yjgpz
            b-suffix = [zbezspnnpszebz]mhvp
        a-prefix + b-suffix => pvhmzbezspnnpszebzmhvp
        which is a valid palindrome... */
        // If not then we need to check for b-prefix + a-suffix

        // Need to check the remaining substring in the middle is palindorme or not
        return isPalindrome(a, start, end) || isPalindrome(b, start, end);
    }
    public static boolean checkPalindromeFormation(String a, String b) {
        // The start of a (a-prefix) and the end of b (b-suffix),
        // The start of b (b-prefix) and the end of a (a-suffix)
        return check(a, b) || check(b, a);
    }
    public static void main(String[] args) {
        System.out.println(checkPalindromeFormation("pvhmupgqeltozftlmfjjde", "yjgpzbezspnnpszebzmhvp"));
        System.out.println(checkPalindromeFormation("ulacfd", "jizalu"));
        System.out.println(checkPalindromeFormation("abdef", "fecab"));
    }
}
