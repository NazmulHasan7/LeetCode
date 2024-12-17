// 1291. Sequential Digits
package Medium;
import java.util.ArrayList;
import java.util.List;

public class Medium_1291_Sequential_Digits {
    public static List<Integer> sequentialDigits(int low, int high) {
        int minDigits = String.valueOf(low).length();
        int maxDigits = String.valueOf(high).length();
        String str = "123456789";

        List<Integer> answer = new ArrayList<>();
        for (int digits = minDigits; digits <= maxDigits; digits++) {
            for (int i=0; i<=9-digits; i++) {
                int number = Integer.parseInt(str.substring(i, i+digits));
                if (number >= low && number <= high) {
                    answer.add(number);
                }
            }
        } return answer;
    }
    public static void main(String[] args) {
        System.out.println(sequentialDigits(100, 300));
        System.out.println(sequentialDigits(1000, 13000));
    }
}
