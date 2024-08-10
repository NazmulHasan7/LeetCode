// 1389. Create Target Array in the Given Order
package Easy;
import java.util.ArrayList;
import java.util.Arrays;

public class Easy_1389_Create_Target_Array_in_the_Given_Order {
    public static int[] createTargetArray(int[] nums, int[] index) {
        ArrayList<Integer> target = new ArrayList<>();
        int[] targetArr = new int[nums.length];

        for (int i=0; i<nums.length; i++)
            target.add(index[i], nums[i]);

        for (int i=0; i<nums.length; i++)
            targetArr[i] = target.get(i);

        return targetArr;
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(
                createTargetArray(new int[] {0,1,2,3,4}, new int[] {0,1,2,2,1}))
        );
    }
}
