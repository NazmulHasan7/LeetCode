// 2575. Find the Divisibility Array of a String
package Medium;
import java.util.Arrays;

public class Medium_2575_Find_the_Divisibility_Array_of_a_String {
    public static int[] divisibilityArray(String word, int m) {
        int n = word.length();
        int[] answer = new int[n];
        int idx = 0;

        long number = 0;
        for (char c : word.toCharArray()) {
            number = number * 10 + c-'0';
            if (number % m == 0)
                answer[idx++] = 1;
            else answer[idx++] = 0;
            number %= m;
        }
        return answer;
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(divisibilityArray("998244353",3)));
        System.out.println(Arrays.toString(divisibilityArray("1010",10)));
    }
}
