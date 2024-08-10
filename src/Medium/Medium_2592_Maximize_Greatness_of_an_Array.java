// 2592. Maximize Greatness of an Array
package Medium;
import java.util.Arrays;

public class Medium_2592_Maximize_Greatness_of_an_Array {
    public static int maximizeGreatness(int[] nums) {
        // Try replacing with the next greater element
        Arrays.sort(nums);
        int count = 0, i = 0, j = 1;
        while (j < nums.length) {
            if (nums[i] < nums[j]) {
                count++;
                i++;
            } j++;
        } return count;
    }
    public static void main(String[] args) {
        System.out.println(maximizeGreatness(new int[]{1,3,5,2,1,3,1}));
        System.out.println(maximizeGreatness(new int[]{1,2,3,4}));
    }
}
