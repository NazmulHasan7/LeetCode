// 917. Reverse Only Letters
package Easy;

public class Easy_917_Reverse_Only_Letters {
    public static String reverseOnlyLetters(String s) {
        char[] cArr = s.toCharArray();
        for (int i=0, j=cArr.length-1; i<j; i++, j--) {
            if (!Character.isAlphabetic(cArr[i])) j++;
            else if (!Character.isAlphabetic(cArr[j])) i--;
            else {
                char temp = cArr[i];
                cArr[i] = cArr[j];
                cArr[j] = temp;
            }
        } return String.valueOf(cArr);
    }
    public static void main(String[] args) {
        System.out.println(reverseOnlyLetters("ab-cd"));
        System.out.println(reverseOnlyLetters("a-bC-dEf-ghIj"));
        System.out.println(reverseOnlyLetters("Test1ng-Leet=code-Q!"));
    }
}
