// 125. Valid Palindrome
package Easy;

public class Easy_125_Valid_Palindrome {
    public static boolean isAlphaNumeric(char c) {
        return ((c>='0' && c<='9') || (c>='a' && c<='z') || (c>='A' && c<='Z'));
    }
    public static boolean isPalindrome(String s) {
        char c1, c2;
        int length = s.length();
        for (int i=0, j=length-1; i<j; ) {
            c1 = s.charAt(i);
            c2 = s.charAt(j);
            if (isAlphaNumeric(c1) && isAlphaNumeric(c2)) {
                if (Character.isUpperCase(c1))
                    c1 = (char)(c1+32);
                if (Character.isUpperCase(c2))
                    c2 = (char)(c2+32);
                if (c1 != c2) return false;
                i++; j--;
            } else {
                if (!isAlphaNumeric(c1)) i++;
                if (!isAlphaNumeric(c2)) j--;
            }
        } return true;
    }
    public static void main(String[] args) {
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(isPalindrome("race a car"));
        System.out.println(isPalindrome(" "));
    }
}
