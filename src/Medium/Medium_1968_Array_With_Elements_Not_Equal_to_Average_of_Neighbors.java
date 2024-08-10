// 1968. Array With Elements Not Equal to Average of Neighbors
package Medium;
import java.util.Arrays;

public class Medium_1968_Array_With_Elements_Not_Equal_to_Average_of_Neighbors {
    public static int[] rearrangeArray(int[] nums) {
        Arrays.sort(nums);
        int temp;
        for (int i=0; i<nums.length-1; i+=2) {
            temp = nums[i];
            nums[i] = nums[i+1];
            nums[i+1] = temp;
        } return nums;
    }
    public static int[] rearrangeArrayBetter(int[] nums) {
        boolean needToCheck = true;
        while (needToCheck) {
            needToCheck = false;
            for (int i=1; i<nums.length-1; i++) {
                if (nums[i-1]+nums[i+1] == 2*nums[i]) {
                    int temp = nums[i];
                    nums[i] = nums[i-1];
                    nums[i-1] = temp;
                    needToCheck = true;
                }
            }
        } return nums;
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(rearrangeArray(new int[]{1,2,3,4,5})));
        System.out.println(Arrays.toString(rearrangeArray(new int[]{6,2,0,9,7})));
    }
}
