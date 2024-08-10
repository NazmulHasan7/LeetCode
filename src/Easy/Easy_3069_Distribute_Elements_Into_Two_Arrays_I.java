// 3069. Distribute Elements Into Two Arrays I
package Easy;
import java.util.ArrayList;
import java.util.Arrays;

public class Easy_3069_Distribute_Elements_Into_Two_Arrays_I {
    public static int[] resultArray(int[] nums) {
        int length = nums.length;
        ArrayList<Integer> arr1 = new ArrayList<>();
        ArrayList<Integer> arr2 = new ArrayList<>();
        arr1.add(nums[0]);
        arr2.add(nums[1]);

        for (int i=2; i<length; i++) {
            if (arr1.get(arr1.size()-1) > arr2.get(arr2.size()-1))
                arr1.add(nums[i]);
            else arr2.add(nums[i]);
        }
        int index = 0;
        for (Integer num : arr1) nums[index++] = num;
        for (Integer num : arr2) nums[index++] = num;
        return nums;
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(resultArray(new int[] {2,3,1})));
        System.out.println(Arrays.toString(resultArray(new int[] {5,4,3,8})));
    }
}
