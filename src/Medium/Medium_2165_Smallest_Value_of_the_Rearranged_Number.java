// 2165. Smallest Value of the Rearranged Number
package Medium;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Medium_2165_Smallest_Value_of_the_Rearranged_Number {
    public static long smallestNumber(long num) {
        boolean isNeg = num < 0;
        if (isNeg) num *= -1;

        ArrayList<Integer> digits = new ArrayList<>();
        if (num == 0) {
            digits.add(0);
        } else {
            while (num != 0) {
                digits.add((int)(num % 10));
                num /= 10;
            }
        }

        long answer = 0;
        if (isNeg) {
            digits.sort((a, b) -> (b - a));
            for (int dig : digits)
                answer = answer * 10 + dig;
            return -answer;
        } else {
            Collections.sort(digits);
            int firstNonZero = 0;
            while (firstNonZero < digits.size() && digits.get(firstNonZero) == 0)
                firstNonZero++;

            if (firstNonZero < digits.size() && firstNonZero != 0)
                Collections.swap(digits, 0, firstNonZero);

            for (int dig : digits)
                answer = answer * 10 + dig;
            return answer;
        }
    }
    public static long smallestNumberOpt(long num) {
        // USING ARRAY
        boolean isNeg = num < 0;
        if (isNeg) num *= -1;

        int[] digits = new int[20]; // Enough for all long values
        int size = 0;
        if (num == 0) {
            digits[size++] = 0;
        } else {
            while (num != 0) {
                digits[size++] = (int)(num % 10);
                num /= 10;
            }
        }

        long answer = 0;

        if (isNeg) {
            // Sort in descending order for negative numbers
            Arrays.sort(digits, 0, size);
            reverseArray(digits, size);
            for (int i = 0; i < size; i++) {
                answer = answer * 10 + digits[i];
            }
            return -answer;
        } else {
            // Sort in ascending order for positive numbers
            Arrays.sort(digits, 0, size);

            // Handle leading zeros
            int firstNonZero = 0;
            while (firstNonZero < size && digits[firstNonZero] == 0) {
                firstNonZero++;
            }

            if (firstNonZero < size && firstNonZero != 0) {
                // Swap first non-zero with first zero
                int temp = digits[0];
                digits[0] = digits[firstNonZero];
                digits[firstNonZero] = temp;
            }

            for (int i = 0; i < size; i++) {
                answer = answer * 10 + digits[i];
            }
            return answer;
        }
    }
    private static void reverseArray(int[] arr, int size) {
        for (int i = 0; i < size / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[size - 1 - i];
            arr[size - 1 - i] = temp;
        }
    }
    public static void main(String[] args) {
        System.out.println(smallestNumber(310));
        System.out.println(smallestNumber(-7605));
        System.out.println(smallestNumber(2170596702L));
    }
}
