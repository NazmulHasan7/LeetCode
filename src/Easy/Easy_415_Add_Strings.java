// 415. Add Strings
package Easy;

public class Easy_415_Add_Strings {
    public static String addStrings(String num1, String num2) {
        StringBuilder result = new StringBuilder();
        int i = num1.length()-1, j = num2.length()-1;
        int carry = 0, n1, n2;

        while (i >= 0 || j >= 0) {
            n1 = n2 = 0;
            if (i >= 0)
                n1 = num1.charAt(i--)-'0';
            if (j >= 0)
                n2 = num2.charAt(j--)-'0';
            int sum = n1 + n2 + carry;
            if (sum >= 10) {
                result.append(sum-10);
                carry = 1;
            } else {
                result.append(sum);
                carry = 0;
            }
        } if (carry > 0) result.append(carry);
        return result.reverse().toString();
    }
    public static void main(String[] args) {
        System.out.println(addStrings("11", "123"));
        System.out.println(addStrings("456", "77"));
        System.out.println(addStrings("0", "0"));
        System.out.println(addStrings("6913259244", "71103343"));
    }
}
