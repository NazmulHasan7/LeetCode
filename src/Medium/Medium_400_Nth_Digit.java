// 400. Nth Digit
package Medium;

public class Medium_400_Nth_Digit {
    /* Group numbers by their digit length:
    1-digit numbers: 1..9 → 9 numbers → 9 * 1 digit
    2-digit numbers: 10..99 → 90 numbers → 90 * 2 digits
    3-digit numbers: 100..999 → 900 numbers → 900 * 3 digits

    Subtract whole groups from n until n falls inside a group of digits length.
    Compute the exact number that contains the nth digit:
    start = 10^(digits-1) is the first number in that group.
    num = start + (n-1)//digits
    Extract the digit at position (n-1) % digits from num. */

    public static int findNthDigit(int remainingDigits) {
        long tier = 1;
        long digits = 9; // number of digits in this tier
        long start = 1;

        // Step 1 -> Find the tier
        while (remainingDigits > tier * digits) {
            remainingDigits -= (int) (tier * digits);
            start *= 10;
            digits *= 10; // 9 90 900 .......
            tier++;
        }
        // Step 2 -> Find the number
        long tierNumber = remainingDigits / tier;
        long remainder = remainingDigits % tier;

        // Step 3 -> Find the digit
        if (remainder == 0) { // answer is the last digit of previous number
            String numberStr = String.valueOf(start + tierNumber - 1);
            System.out.println(numberStr);
            return numberStr.charAt(numberStr.length()-1) - '0';
        } else { // answer is the digit of current number
            String numberStr = String.valueOf(start + tierNumber);
            return numberStr.charAt((int) (remainder - 1)) - '0';
        }
    }
    public static void main(String[] args) {
        System.out.println(findNthDigit(250));
        System.out.println(findNthDigit(1000000000));
    }
}
