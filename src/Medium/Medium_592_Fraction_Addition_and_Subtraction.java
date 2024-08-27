// 592. Fraction Addition and Subtraction
package Medium;

public class Medium_592_Fraction_Addition_and_Subtraction {
    public static String fractionAddition(String expression) {
        int numerator = 0;
        int denominator = 1;
        int sign = 1;

        int i = 0, n = expression.length();
        while (i < n) {
            if (expression.charAt(i) == '+' || expression.charAt(i) == '-') {
                sign = (expression.charAt(i) == '+') ? 1 : -1;
                i++;
            }
            int currentNumerator = 0;
            while (i < n && Character.isDigit(expression.charAt(i))) {
                currentNumerator = (currentNumerator * 10) + (expression.charAt(i) - '0');
                i++;
            }
            i++; // skipping /
            currentNumerator *= sign;

            int currentDenom = 0;
            while (i < n && Character.isDigit(expression.charAt(i))) {
                currentDenom = (currentDenom * 10) + (expression.charAt(i) - '0');
                i++;
            }
            // a/b + c/d = (ad + bc) / bd
            numerator = numerator * currentDenom + denominator * currentNumerator;
            denominator = denominator * currentDenom;

            int g = gcd(Math.abs(numerator), denominator);
            numerator /= g;
            denominator /= g;
        }
        return numerator + "/" + denominator;
    }
    private static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        } return a;
    }
    public static void main(String[] args) {
        System.out.println(fractionAddition("-1/2+1/2"));
        System.out.println(fractionAddition("-1/2+1/2+1/3"));
        System.out.println(fractionAddition("1/3-1/2"));
    }
}
