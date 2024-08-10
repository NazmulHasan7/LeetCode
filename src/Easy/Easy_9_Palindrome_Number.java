// 9. Palindrome Number
package Easy;

public class Easy_9_Palindrome_Number {
    public static boolean isPalindrome(int x) {
        if (x < 0)
            return false;
        int tempNumber = x;
        int reversedNumber = 0;
        while (x != 0) {
            reversedNumber = reversedNumber * 10 + x % 10;
            x /= 10;
        }
        return reversedNumber == tempNumber;
    }
    public static void main(String[] args) {
        System.out.println(isPalindrome(121));
        System.out.println(isPalindrome(-121));
        System.out.println(isPalindrome(10));
    }
}
