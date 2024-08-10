// 2180. Count Integers With Even Digit Sum
package Easy;

public class Easy_2180_Count_Integers_With_Even_Digit_Sum {
    public static boolean isEvenDigitSum(int num) {
        int sum = 0;
        while (num != 0) {
            sum += num % 10;
            num /= 10;
        } return sum % 2 == 0;
    }
    public static int countEven(int num) {
        int count = 0;
        for (int i=2; i<=num; i++)
            if (isEvenDigitSum(i))
                count++;
        return count;
    }
    public static void main(String[] args) {
        System.out.println(countEven(4));
        System.out.println(countEven(30));
    }
}
