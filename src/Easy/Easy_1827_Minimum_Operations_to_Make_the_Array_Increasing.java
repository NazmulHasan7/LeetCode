// 1827. Minimum Operations to Make the Array Increasing
package Easy;

public class Easy_1827_Minimum_Operations_to_Make_the_Array_Increasing {
    public static int minOperations(int[] nums) {
        int count = 0;
        int n = nums.length;
        int diff;
        for (int i=0; i<n-1; i++) {
            if (nums[i+1] <= nums[i]) {
                diff = nums[i]+1 - nums[i+1];
                nums[i+1] += diff;
                count += diff;
            }
        } return count;
    }
    public static void main(String[] args) {
        System.out.println(minOperations(new int[] {1,1,1}));
        System.out.println(minOperations(new int[] {1,5,2,4,1}));
        System.out.println(minOperations(new int[] {8}));
    }
}
