// 2535. Difference Between Element Sum and Digit Sum of an Array
package Easy;

public class Easy_2535_Difference_Between_Element_Sum_and_Digit_Sum_of_an_Array {
    public static int getDigitSum(int num) {
        int sum = 0;
        while (num != 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
    public static int differenceOfSum(int[] nums) {
        int sum = 0, digitSum = 0;
        for (int num: nums) {
            sum += num;
            digitSum += getDigitSum(num);
        }
        return Math.abs(sum - digitSum);
    }
    public static void main(String[] args) {
        System.out.println(differenceOfSum(new int[] {1,15,6,3}));
        System.out.println(differenceOfSum(new int[] {1,2,3,4}));
    }
}
