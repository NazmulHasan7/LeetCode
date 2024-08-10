// 67. Add Binary
package Easy;

public class Easy_67_Add_Binary {
    public static String addBinary(String a, String b) {
        StringBuilder result = new StringBuilder();
        int i=a.length()-1, j=b.length()-1;
        int sum, carry = 0, n1, n2;
        while (i >= 0 || j >= 0) {
            n1 = n2 = 0;
            if (i >= 0)
                n1 = a.charAt(i--)-'0';
            if (j >= 0)
                n2 = b.charAt(j--)-'0';
            sum = n1 + n2 + carry;
            if (sum == 3) {
                result.append(1);
                carry = 1;
            } else if (sum == 2) {
                result.append(0);
                carry = 1;
            } else {
                result.append(sum);
                carry = 0;
            }
        } if (carry > 0) result.append(1);
        return result.reverse().toString();
    }
    public static void main(String[] args) {
        System.out.println(addBinary("11", "1"));
        System.out.println(addBinary("1010", "1011"));
    }
}
