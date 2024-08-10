// 2520. Count the Digits That Divide a Number
package Easy;

public class Easy_2520_Count_the_Digits_That_Divide_a_Number {
    public static int countDigits(int num) {
        int temp = num, count = 0;
        while (temp != 0) {
            if (num % (temp % 10) == 0) count++;
            temp /= 10;
        } return count;
    }
    public static void main(String[] args) {
        System.out.println(countDigits(7));
        System.out.println(countDigits(121));
        System.out.println(countDigits(1248));
    }
}
