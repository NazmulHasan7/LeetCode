// 2562. Find the Array Concatenation Value
package Easy;

public class Easy_2562_Find_the_Array_Concatenation_Value {
    public static int digitCount(int num) {
        int count = 1;
        while (num != 0) {
            count *= 10;
            num /= 10;
        } return count;
    }
    public static long findTheArrayConcVal(int[] nums) {
        long result = 0;
        int length = nums.length;
        if (length == 1) return nums[0];

        int start = 0, end = length-1;
        while (start < end)
            result += ((long) nums[start++] * digitCount(nums[end]) + nums[end--]);

        if (length % 2 != 0)
            result += nums[length/2];
        return result;
    }
    public static void main(String[] args) {
        System.out.println(findTheArrayConcVal(new int[] {7,52,2,4}));
        System.out.println(findTheArrayConcVal(new int[] {5,14,13,8,12}));
    }
}
