// 3191. Minimum Operations to Make Binary Array Elements Equal to One I
package Medium;

public class Medium_3191_Minimum_Operations_to_Make_Binary_Array_Elements_Equal_to_One_I {
    public static int minOperations(int[] nums) {
        int n = nums.length;
        int count = 0;

        for (int i=0; i<n-2; i++) {
            if (nums[i] == 0) {
                nums[i] = 1;
                nums[i+1] = nums[i+1] == 0 ? 1 : 0;
                nums[i+2] = nums[i+2] == 0 ? 1 : 0;
                count++;
            }
        }
        if (nums[n-2] == 1 && nums[n-1] == 1)
            return count;
        return -1;
    }
    public static void main(String[] args) {
        System.out.println(minOperations(new int[]{0,1,1,1,0,0}));
        System.out.println(minOperations(new int[]{0,1,1,1}));
    }
}
