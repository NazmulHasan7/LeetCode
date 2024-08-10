// 2710. Remove Trailing Zeros From a String
package Easy;

public class Easy_2710_Remove_Trailing_Zeros_From_a_String {
    public static String removeTrailingZeros(String num) {
        int length = num.length()-1;
        while (length >= 0) {
            if (num.charAt(length) != '0') break;
            length--;
        } return num.substring(0, length+1);
    }
    public static void main(String[] args) {
        System.out.println(removeTrailingZeros("51230100"));
        System.out.println(removeTrailingZeros("123"));
    }
}
