// 2974. Minimum Number Game
package Easy;
import java.util.Arrays;

public class Easy_2974_Minimum_Number_Game {
    public static int[] numberGame(int[] nums) {
        Arrays.sort(nums);
        int temp;
        for (int i=0; i<nums.length-1; i+=2) {
            temp = nums[i];
            nums[i] = nums[i+1];
            nums[i+1] = temp;
        } return nums;
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(numberGame(new int[] {5,4,2,3})));
        System.out.println(Arrays.toString(numberGame(new int[] {2,5})));
    }
}
