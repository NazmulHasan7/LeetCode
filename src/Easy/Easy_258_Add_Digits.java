// 258. Add Digits
package Easy;

public class Easy_258_Add_Digits {
    public static int addDigits(int num) {
        int digitSum;
        while (num / 10 != 0) {
            digitSum = 0;
            while (num != 0) {
                digitSum += num % 10;
                num /= 10;
            } num = digitSum;
        } return num;
    }
    public static int addDigitsBetter(int num) {
        if (num == 0) return 0;
        else if (num % 9 == 0) return 9;
        return (num % 9);
    }
    public static void main(String[] args) {
        System.out.println(addDigits(38));
        System.out.println(addDigits(0));
    }
}
