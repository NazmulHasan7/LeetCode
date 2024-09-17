// 2544. Alternating Digit Sum
package Easy;

public class Easy_2544_Alternating_Digit_Sum {
    public static int alternateDigitSum(int n) {
        String number = String.valueOf(n);
        int answer = 0, sign = 1;

        for (char c : number.toCharArray()) {
            answer += sign * (c - '0');
            sign *= -1;
        } return answer;
    }
    public static void main(String[] args) {
        System.out.println(alternateDigitSum(521));
        System.out.println(alternateDigitSum(111));
        System.out.println(alternateDigitSum(886996));
    }
}
