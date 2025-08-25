// 166. Fraction to Recurring Decimal
package Medium;
import java.util.HashMap;

public class Medium_166_Fraction_to_Recurring_Decimal {
    public static String fractionToDecimal(int num, int denom) {
        if (num == 0) return "0";
        boolean isResNeg = (num < 0 || denom < 0) && !(num < 0 && denom < 0);
        long numerator = Math.abs((long) num);
        long denominator = Math.abs((long) denom);

        StringBuilder answer = new StringBuilder();
        if (isResNeg) answer.append("-");

        long quotient = numerator / denominator;
        long remainder = numerator % denominator;
        answer.append(quotient);

        if (remainder == 0) {
            return answer.toString();
        } else {
            answer.append(".");
            HashMap<Long, Integer> map = new HashMap<>();
            while (remainder != 0) {
                if (map.containsKey(remainder)) {
                    int index = map.get(remainder);
                    answer.insert(index, "(");
                    answer.append(")");
                    break;
                } else {
                    map.put(remainder, answer.length());
                    remainder *= 10;
                    quotient = remainder / denominator;
                    remainder = remainder % denominator;
                    answer.append(quotient);
                }
            }
        } return answer.toString();
    }
    public static void main(String[] args) {
        System.out.println(fractionToDecimal(1,2));
        System.out.println(fractionToDecimal(2,1));
        System.out.println(fractionToDecimal(4,333));
    }
}
