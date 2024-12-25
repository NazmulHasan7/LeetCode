// 43. Multiply Strings
package Medium;

public class Medium_43_Multiply_Strings {
    public static String multiply(String num1, String num2) {
        int n1 = num1.length();
        int n2 = num2.length();

        if (n1 == 0 || n2 == 0 || num1.equals("0") || num2.equals("0"))
            return "0";

        int[] product = new int[n1 + n2];

        for (int i=n1-1; i>=0; i--) {
            for (int j=n2-1; j>=0; j--) {
                int d1 = num1.charAt(i) - '0';
                int d2 = num2.charAt(j) - '0';

                int mul = d1 * d2;
                int sum = mul + product[i+j+1];

                product[i+j+1] = sum % 10;
                product[i+j] += sum / 10;
            }
        }
        StringBuilder answer = new StringBuilder();
        for (int x : product)
            if (!(x == 0 && answer.isEmpty()))
                answer.append(x);

        return answer.toString();
    }
    public static void main(String[] args) {
        System.out.println(multiply("2", "3"));
        System.out.println(multiply("123", "456"));
    }
}
