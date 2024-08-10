// 1295. Find Numbers with Even Number of Digits
package Easy;

public class Easy_1295_Find_Numbers_with_Even_Number_of_Digits {
    public static int findNumbers(int[] nums) {
        int count = 0, digits;
        for (int num : nums) {
            digits = 0;
            while (num != 0) {
                digits++;
                num /= 10;
            }
            if (digits % 2 == 0)
                count++;
        } return count;
    }
    public static void main(String[] args) {
        System.out.println(findNumbers(new int[] {12,345,2,6,7896}));
        System.out.println(findNumbers(new int[] {555,901,482,1771}));
    }
}
