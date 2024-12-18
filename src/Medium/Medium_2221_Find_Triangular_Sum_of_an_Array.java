// 2221. Find Triangular Sum of an Array
package Medium;

public class Medium_2221_Find_Triangular_Sum_of_an_Array {
    public static int triangularSum(int[] nums) {
        int n = nums.length;
        while (n > 1) {
            for (int i=0; i<n-1; i++) {
                nums[i] = (nums[i] + nums[i+1]) % 10;
            }
            n--;
        }
        return nums[0];
    }
    public static void main(String[] args) {
        System.out.println(triangularSum(new int[]{1,2,3,4,5}));
        System.out.println(triangularSum(new int[]{5}));
    }
}
