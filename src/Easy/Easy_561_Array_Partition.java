// 561. Array Partition
package Easy;
import java.util.Arrays;

public class Easy_561_Array_Partition {
    public static int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for (int i=0; i<nums.length-1; i+=2)
            sum += nums[i];
        return sum;
    }
    public static void main(String[] args) {
        System.out.println(arrayPairSum(new int[]{1,4,2,3}));
        System.out.println(arrayPairSum(new int[]{6,2,6,5,1,2}));
    }
}
