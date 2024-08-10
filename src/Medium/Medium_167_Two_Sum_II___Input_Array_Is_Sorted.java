// 167. Two Sum II - Input Array Is Sorted
package Medium;
import java.util.Arrays;

public class Medium_167_Two_Sum_II___Input_Array_Is_Sorted {
    public static int[] twoSum(int[] numbers, int target) {
        int start = 0, end = numbers.length-1;
        while (start < end) {
            int sum = numbers[start] + numbers[end];
            if (sum == target)
                return new int[] {start+1, end+1};
            else if (sum < target)
                start++;
            else end--;
        } return new int[] {-1, -1};
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[] {2,7,11,15}, 9)));
        System.out.println(Arrays.toString(twoSum(new int[] {2,3,4}, 6)));
        System.out.println(Arrays.toString(twoSum(new int[] {-1,0}, -1)));
    }
}
