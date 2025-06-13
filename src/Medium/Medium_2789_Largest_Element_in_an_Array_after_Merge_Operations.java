// 2789. Largest Element in an Array after Merge Operations
package Medium;

public class Medium_2789_Largest_Element_in_an_Array_after_Merge_Operations {
    public static long maxArrayValue(int[] nums) {
        long value = nums[nums.length-1];

        for (int i=nums.length-2; i>=0; i--) {
            if (nums[i] > value) value = nums[i];
            else value = value + nums[i];
        }
        return value;
    }
    public static void main(String[] args) {
        System.out.println(maxArrayValue(new int[]{2,3,7,9,3}));
        System.out.println(maxArrayValue(new int[]{5,3,3}));
    }
}
