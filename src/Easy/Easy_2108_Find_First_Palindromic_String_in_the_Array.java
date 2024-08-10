// 2108. Find First Palindromic String in the Array
package Easy;

public class Easy_2108_Find_First_Palindromic_String_in_the_Array {
    public static String firstPalindrome(String[] words) {
        boolean palindrome;
        for (String word : words) {
            palindrome = true;
            for (int i=0, j=word.length()-1; i<=j; i++, j--) {
                if (word.charAt(i) != word.charAt(j)) {
                    palindrome = false;
                    break;
                }
            } if(palindrome) return word;
        } return "";
    }
    public static void main(String[] args) {
        System.out.println(firstPalindrome(new String[] {"abc","car","ada","racecar","cool"}));
    }
}